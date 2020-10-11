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

@Service
public class DepartmentDAOImpl implements DepartmentDAO {


	private Logger loggerInfo = Logger.getLogger("tatasky_info");
	private Logger loggerTech = Logger.getLogger("tatasky_tech");

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Map<String, Object> viewDepartment() {
			loggerInfo.info("**[ viewDepartment List ]**");
			Map<String, Object> mapData=new HashMap<String, Object>();
			List<Department> departmentList=new ArrayList<Department>();
			departmentList=this.sessionFactory.getCurrentSession().createQuery("from Department").list();
			mapData.put("departmentList", departmentList);
			return mapData;
		}

	@Override
	public Map<String, Object> editDepartment(Integer id) {
		Map<String, Object> mapData=new HashMap<String, Object>();
		loggerInfo.info("**[ editDepartment Edit Department  ]**");
		loggerTech.info("**[ editDepartment Edit Department Departmentid "+id+"]**");
		
		List<Department> editDepartmentList=new ArrayList<Department>();
		List<Department> departmentList=new ArrayList<Department>();
		
		editDepartmentList=this.sessionFactory.getCurrentSession().createQuery("from Department as ue where ue.id="+id).list();
		departmentList=this.sessionFactory.getCurrentSession().createQuery("from Department").list();

		mapData.put("editDepartmentList", editDepartmentList);
		mapData.put("departmentList", departmentList);
		return mapData;
	}

	@Override
	public Map<String, Object> saveDepartment(Map<String, Object> map) {
		System.out.println("************ In save Department in DepartmentDAO imple *****************");
		loggerInfo.info("**[ saveDepartment Save Department ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		List<Department> uniquedata=new  ArrayList<Department>();
		Department entity=new Department();
		entity=(Department)map.get("department");
        
		uniquedata=(List<Department>)this.sessionFactory.getCurrentSession().createCriteria(Department.class).add(Restrictions.eq("departmentName", entity.getDepartmentName())).list(); 
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
    		loggerInfo.info("**[ Department Saved ]**");
    		
    	}catch(RuntimeException e){
    		try
    		{
    			loggerTech.info("**[ saveDepartment Couldn’t roll back transaction ]**");
    			tx.rollback();
    		}
    		catch(RuntimeException rbe)
    		{
    			loggerTech.info("**[ saveDepartment Couldn’t roll back transaction ]**");
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

	@Override
	public Map<String, Object> modifyDepartment(Map<String, Object> map) {
		loggerInfo.info("**[ modifyDepartment update Department  ]**");
		loggerTech.info("**[ modifyDepartment update Department Departmentid ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		Department department=new Department();
		department=(Department)map.get("department");
		
		Session session = null;
    	Transaction tx = null;
 
    	try{
    		session = this.sessionFactory.openSession();
    		tx = session.beginTransaction();
    		if(department!=null && department.getId()!=null && department.getId()>0){
    			Department editDepartment= (Department) session.load(
    					Department.class, department.getId());
    	        if (null != editDepartment) 
    	        {
    	        	
    	        	editDepartment.setDepartmentCode(department.getDepartmentCode());
    	        	editDepartment.setDepartmentName(department.getDepartmentName());
    	        	editDepartment.setStatus(department.getStatus());
    	        	editDepartment.setLastChgBy(department.getLastChgBy());
    	        	editDepartment.setLastChgDate(new Date());
    	        	editDepartment.setLastChgTime(department.getLastChgTime());
    	        	session.saveOrUpdate(editDepartment);
        			loggerTech.info("**[ modifyDepartment  Data found ]**");
    	        }
    		}else{
    			loggerTech.info("**[ modifyDepartment  No Data found ]**");
    		} 
    		tx.commit();
    	}catch(RuntimeException e){
    		try{
    			loggerTech.info("**[ modifyDepartment  roll back transaction ]**");

    			tx.rollback();
    		}catch(RuntimeException rbe){
    			loggerTech.info("**[ modifyDepartment Couldn’t roll back transaction ]**");

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
