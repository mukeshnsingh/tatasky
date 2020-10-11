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

import com.sspl.entity.DocumentsEntity;
import com.sspl.entity.ProfileEntity;
import com.sspl.entity.ProfileSignatoriesEntity;
import com.sspl.entity.Role;
import com.sspl.entity.SignatoryEntity;

public class ProfileWorkflowDOAImpl implements ProfileWorkflowDAO {

	private Logger loggerInfo = Logger.getLogger("tatasky_info");
	private Logger loggerTech = Logger.getLogger("tatasky_tech");

	@Autowired
	private SessionFactory sessionFactory;

	public Map<String, Object> viewProfileWorkflow() 
	{
		loggerInfo.info("**[ viewProfile Profile List ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		List<ProfileSignatoriesEntity> profileSignatoriesList=new ArrayList<ProfileSignatoriesEntity>();
		List<SignatoryEntity> signatoriesList=new ArrayList<SignatoryEntity>();
		List<ProfileEntity> profileList=new ArrayList<ProfileEntity>();
		List<DocumentsEntity> documentsList=new ArrayList<DocumentsEntity>();
		profileSignatoriesList=this.sessionFactory.getCurrentSession().createQuery("from ProfileSignatoriesEntity").list();
		signatoriesList=this.sessionFactory.getCurrentSession().createQuery("from SignatoryEntity").list();
		profileList=this.sessionFactory.getCurrentSession().createQuery("from ProfileEntity").list();
		documentsList=this.sessionFactory.getCurrentSession().createQuery("from DocumentsEntity").list();
		mapData.put("profileSignatoriesList", profileSignatoriesList);
		mapData.put("signatoriesList", signatoriesList);
		mapData.put("profileList", profileList);
		mapData.put("documentsList", documentsList);
		
		return mapData;
	}

	@Override
	public Map<String, Object> saveProfileWorkflow(Map<String, Object> map) {
		System.out.println("************ In save ProfileWorkflow in ProfileWorkflowDAO imple *****************");
		loggerInfo.info("**[ saveProfileWorkflow Save ProfileWorkflow ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		List<ProfileSignatoriesEntity> uniquedata=new  ArrayList<ProfileSignatoriesEntity>();
		ProfileSignatoriesEntity entity=new ProfileSignatoriesEntity();
		Role role=new Role();
		entity=(ProfileSignatoriesEntity)map.get("profileSignatoriesEntity");
		uniquedata=(List<ProfileSignatoriesEntity>)this.sessionFactory.getCurrentSession().createCriteria(ProfileSignatoriesEntity.class).add(Restrictions.eq("profileEntity.id", entity.getProfileEntity().getId())).list(); 
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
    		loggerInfo.info("**[ ProfileWorkflow Saved ]**");
    		
    	}catch(RuntimeException e){
    		try
    		{
    			loggerTech.info("**[ saveProfileWorkflow Couldn’t roll back transaction ]**");
    			tx.rollback();
    		}
    		catch(RuntimeException rbe)
    		{
    			loggerTech.info("**[ saveProfileWorkflow Couldn’t roll back transaction ]**");
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

	
}
