package com.sspl.master.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sspl.entity.Department;
import com.sspl.entity.EmployeeEntity;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {

	private Logger loggerInfo = Logger.getLogger("tatasky_info");
	private Logger loggerTech = Logger.getLogger("tatasky_tech");
	
	@Autowired
	private SessionFactory sessionFactory;

	public Map<String, Object> viewEmployee() 
	{
		loggerInfo.info("**[ viewEmployee Employee List ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		List<Department> departmentList=new ArrayList<Department>();
		List<EmployeeEntity> employeList=new ArrayList<EmployeeEntity>();
		
		employeList=this.sessionFactory.getCurrentSession().createQuery("from EmployeeEntity where status='1'").list();
		departmentList=this.sessionFactory.getCurrentSession().createQuery("from Department where status='1'").list();

		mapData.put("employeList", employeList);
		mapData.put("departmentList", departmentList);
		return mapData;
	}
	
	
	public Map<String, Object> editEmployee(Integer id) {
		Map<String, Object> mapData=new HashMap<String, Object>();
		loggerInfo.info("**[ editEmployee Edit Employee  ]**");
		loggerTech.info("**[ editEmployee Edit Employee userid "+id+"]**");
		
		List<EmployeeEntity> editEmployeeList=new ArrayList<EmployeeEntity>();
		List<Department> departmentList=new ArrayList<Department>();
		List<EmployeeEntity> employeList=new ArrayList<EmployeeEntity>();

		editEmployeeList=this.sessionFactory.getCurrentSession().createQuery("from EmployeeEntity as ue where ue.id="+id).list();
		employeList=this.sessionFactory.getCurrentSession().createQuery("from EmployeeEntity ").list();
		departmentList=this.sessionFactory.getCurrentSession().createQuery("from Department where status='1'").list();

		mapData.put("editEmployeeList", editEmployeeList);
		mapData.put("employeList", employeList);
		mapData.put("departmentList", departmentList);
		
		return mapData;
		
	}
	
	
	public Map<String, Object> saveEmployee(Map<String, Object> map) {
		System.out.println("************ In save Employee in UserDAO imple *****************");
		loggerInfo.info("**[ saveEmployee Save Employee ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		List<EmployeeEntity> uniquedata=new  ArrayList<EmployeeEntity>();
		EmployeeEntity entity=new EmployeeEntity();
		entity=(EmployeeEntity)map.get("employeeEntity");
        
		uniquedata=(List<EmployeeEntity>)this.sessionFactory.getCurrentSession().createCriteria(EmployeeEntity.class).add(Restrictions.eq("employeeName", entity.getEmployeeName())).list(); 
		System.out.println("size=="+uniquedata.size());
		if(uniquedata.size()>0)
		{
			mapData.put("alreadyexisting",uniquedata);
		}
		else{
		Session session = null;
    	Transaction tx = null;
    	try{
    		session = this.sessionFactory.openSession();
    		tx = session.beginTransaction();
    		session.save(entity);
    		tx.commit();
    		loggerInfo.info("**[ Employee Saved ]**");
    		
    	}catch(RuntimeException e){
    		try
    		{
    			loggerTech.info("**[ saveEmployee Couldn’t roll back transaction ]**");
    			tx.rollback();
    		}
    		catch(RuntimeException rbe)
    		{
    			loggerTech.info("**[ saveEmployee Couldn’t roll back transaction ]**");
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
	
	
	// update/ modify Employee start
	
	public Map<String, Object> modifyEmployee(Map<String, Object> map) {
		loggerInfo.info("**[ modifyEmployee update Employee  ]**");
		loggerTech.info("**[ modifyEmployee update Employee employeeid ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		EmployeeEntity employee=new EmployeeEntity();
		employee=(EmployeeEntity)map.get("employeeEntity");
		Session session = null;
    	Transaction tx = null;
    	try{
    		session = this.sessionFactory.openSession();
    		tx = session.beginTransaction();
    		if(employee!=null && employee.getId()!=null && employee.getId()>0){
    			EmployeeEntity editEmployeeEntity= (EmployeeEntity) session.load(
    					EmployeeEntity.class, employee.getId());
    	        if (null != editEmployeeEntity) 
    	        {
    	        	editEmployeeEntity.setEmployeeName(employee.getEmployeeName());
    	        	editEmployeeEntity.setEmployeeCode(employee.getEmployeeCode());
    	        	editEmployeeEntity.setEmail(employee.getEmail());
    	        	editEmployeeEntity.setMobileNo(employee.getMobileNo());
    	        	editEmployeeEntity.setStatus(employee.getStatus());
    	        	editEmployeeEntity.setLastChgBy(employee.getLastChgBy());
    	        	editEmployeeEntity.setLastChgDate(new Date());
    	        	editEmployeeEntity.setLastChgTime(employee.getLastChgTime());
    	        	
    	        	session.saveOrUpdate(editEmployeeEntity);
        			loggerTech.info("**[ modifyEmployee  Data found ]**");
    	        }
    		}else{
    			loggerTech.info("**[ modifyEmployee  No Data found ]**");
    		} 
    		tx.commit();
    	}catch(RuntimeException e){
    		try{
    			loggerTech.info("**[ modifyEmployee  roll back transaction ]**");

    			tx.rollback();
    		}catch(RuntimeException rbe){
    			loggerTech.info("**[ modifyEmployee Couldn’t roll back transaction ]**");

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
