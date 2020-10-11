/**
 * 
 * @author Mukesh Narayan Singh
 *
 */

package com.sspl.master.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sspl.entity.EmployeeEntity;
import com.sspl.entity.Role;
import com.sspl.entity.UsersEntity;
import com.sspl.entity.UsersRole;

@Repository
public class UserDAOImpl implements UserDAO
{
	private Logger loggerInfo = Logger.getLogger("tatasky_info");
	private Logger loggerTech = Logger.getLogger("tatasky_tech");
	
	@Autowired
    private SessionFactory sessionFactory;
	
	
	public Map<String, Object> viewUser() 
	{
		loggerInfo.info("**[ viewuser User List ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		List<UsersEntity> userList=new ArrayList<UsersEntity>();
		List<Role> roleList=new ArrayList<Role>();
		List<EmployeeEntity> employeList=new ArrayList<EmployeeEntity>();
		
		userList=this.sessionFactory.getCurrentSession().createQuery("from UsersEntity").list();
        roleList=this.sessionFactory.getCurrentSession().createQuery("from Role ").list();
		employeList=this.sessionFactory.getCurrentSession().createQuery("from EmployeeEntity where status='1'").list();

		mapData.put("employeList", employeList);
		mapData.put("userList", userList);
		mapData.put("roleList", roleList);
		return mapData;
	}
	
	
	public Map<String, Object> editUser(Integer id) {
		Map<String, Object> mapData=new HashMap<String, Object>();
		loggerInfo.info("**[ editUser Edit User  ]**");
		loggerTech.info("**[ editUser Edit User userid "+id+"]**");
		
		List<UsersEntity> userList=new ArrayList<UsersEntity>();
		List<UsersEntity> editUserList=new ArrayList<UsersEntity>();
		List<UsersRole> roleList=new ArrayList<UsersRole>();
		List<Role> roles=new ArrayList<Role>();
		List<EmployeeEntity> employeList=new ArrayList<EmployeeEntity>();
		employeList=this.sessionFactory.getCurrentSession().createQuery("from EmployeeEntity where status='1'").list();
		mapData.put("employeList", employeList);
		
		editUserList=this.sessionFactory.getCurrentSession().createQuery("from UsersEntity as ue where ue.id="+id).list();
		userList=this.sessionFactory.getCurrentSession().createQuery("from UsersEntity").list();
		roleList=this.sessionFactory.getCurrentSession().createQuery("from UsersRole ur where ur.usersEntity="+id).list();
		roles=this.sessionFactory.getCurrentSession().createQuery("from Role").list();

		mapData.put("roleList", roleList);		
		mapData.put("editUserList", editUserList);
		mapData.put("userList", userList);
		mapData.put("roles",roles);
		
		return mapData;
		
	}
	
	
	public Map<String, Object> saveUser(Map<String, Object> map) {
		System.out.println("************ In save user in UserDAO imple *****************");
		loggerInfo.info("**[ saveUser Save User ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		List<UsersEntity> uniquedata=new  ArrayList<UsersEntity>();
		UsersRole usersRole= new  UsersRole();
		UsersEntity entity=new UsersEntity();
		Role role=new Role();
		entity=(UsersEntity)map.get("usersEntity");
		role=(Role)map.get("role");
		System.out.println(entity.getfName()+"===="+role.getId());
        entity.setPassword("hello");
        
		uniquedata=(List<UsersEntity>)this.sessionFactory.getCurrentSession().createCriteria(UsersEntity.class).add(Restrictions.eq("username", entity.getUsername())).list(); 
		System.out.println("size=="+uniquedata.size());
		if(uniquedata.size()>0)
		{
			mapData.put("alreadyexisting",uniquedata);
		}
		else{
		
		
		Session session = null;
    	Transaction tx = null;
    	
    	usersRole.setUsersEntity(entity);
    	usersRole.setRole(role);
    	usersRole.setEnabled(Integer.parseInt(entity.getEnabled()));
 
    	try{
    		session = this.sessionFactory.openSession();
    		tx = session.beginTransaction();
    		session.save(entity);
    		session.save(usersRole);
    		tx.commit();
    		loggerInfo.info("**[ User Saved ]**");
    		
    	}catch(RuntimeException e){
    		try
    		{
    			loggerTech.info("**[ saveUser Couldn’t roll back transaction ]**");
    			tx.rollback();
    		}
    		catch(RuntimeException rbe)
    		{
    			loggerTech.info("**[ saveUser Couldn’t roll back transaction ]**");
    		}
    		throw e;
    	}finally
    	{
    		if(session!=null)
    		{
    			session.close();
    		}
    	}
		}
		return mapData;
	}
	
	
	// update/ modify user start
	
	public Map<String, Object> modifyUser(Map<String, Object> map) {
		loggerInfo.info("**[ modifyUser update User  ]**");
		loggerTech.info("**[ modifyUser update User userid ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		UsersEntity usersEntity=new UsersEntity();
		Role role=new Role();
		usersEntity=(UsersEntity)map.get("usersEntity");
		role=(Role)map.get("role");
		System.out.println(usersEntity.getfName()+"===="+role.getId());
		usersEntity.setPassword("hello");
		
		Session session = null;
    	Transaction tx = null;
 
    	try{
    		session = this.sessionFactory.openSession();
    		tx = session.beginTransaction();
    		if(usersEntity!=null && usersEntity.getId()!=null && usersEntity.getId()>0){
    			UsersEntity editUsersEntity= (UsersEntity) session.load(
    			UsersEntity.class, usersEntity.getId());
    	        if (null != editUsersEntity) 
    	        {
    	        	
    	        	editUsersEntity.setCreationDate(usersEntity.getCreationDate());
    	        	editUsersEntity.setdName(usersEntity.getdName());
    	        	editUsersEntity.setEmailId(usersEntity.getEmailId());
    	        	editUsersEntity.setfName(usersEntity.getfName());
    	        	editUsersEntity.setmName(usersEntity.getmName());
    	        	
    	        	editUsersEntity.setlName(usersEntity.getlName());
    	        	editUsersEntity.setEmployeeId(usersEntity.getEmployeeId());
    	        	editUsersEntity.setMobileNo(usersEntity.getMobileNo());
    	        	editUsersEntity.setModifiedBy(usersEntity.getModifiedBy());
    	        	editUsersEntity.setModifiedDate(usersEntity.getModifiedDate());
    	        	editUsersEntity.setPassword(editUsersEntity.getPassword());
    	        	session.saveOrUpdate(editUsersEntity);
        			loggerTech.info("**[ modifyUser  Data found ]**");
    	        }
    		}else{
    			loggerTech.info("**[ modifyUser  No Data found ]**");
    		} 
    		String deleteQuery = "delete UsersRole ur where ur.usersEntity= :userroleid";
    		int value=session.createQuery(deleteQuery).setInteger("userroleid", usersEntity.getId()).executeUpdate();
    		
    		
    		tx.commit();
 
 
    	}catch(RuntimeException e){
    		try{
    			loggerTech.info("**[ modifyUser  roll back transaction ]**");

    			tx.rollback();
    		}catch(RuntimeException rbe){
    			loggerTech.info("**[ modifyUser Couldn’t roll back transaction ]**");

    		}
    		throw e;
    	}finally{
    		if(session!=null){
    			session.close();
    		}
    	}
				return mapData;
	}

	
	}
