package com.sspl.master.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;

import com.sspl.entity.SystemParameterEntity;
@Repository
public class SystemParameterDAOImpl implements SystemParameterDAO {

	@Autowired
	private SessionFactory sessionfactory;
		
	@SuppressWarnings("unchecked")
	public Object viewSystemParameter() {
		Map<String,Object> sysparamdata=new HashMap<String,Object>();
		List<SystemParameterEntity> sysparamlist=new  ArrayList<SystemParameterEntity>();
		System.out.println("inside syst dao");
		sysparamlist=this.sessionfactory.getCurrentSession().createQuery("from SystemParameterEntity where id="+1).list();
		sysparamdata.put("systemparameterlist",sysparamlist);
		
		return sysparamdata ;
	}

	public Map<String, Object> modifySystemParameter(SystemParameterEntity systemparameterentity) {
		
		Map<String,Object> modifyMap=new HashMap<String,Object>();
		this.sessionfactory.getCurrentSession().update(systemparameterentity);
		
		
		return modifyMap;
	}


	public Map<String, Object> saveSystemParameter(SystemParameterEntity systemParameterEntity) {
		
		Map<String,Object> saveMap=new HashMap<String,Object>();
		List<SystemParameterEntity> saveList=new ArrayList<SystemParameterEntity>();
		Session session=null;
		Transaction ts=null;
		try
		{
			session=this.sessionfactory.openSession();
			ts=session.beginTransaction();
			session.save(systemParameterEntity);
			ts.commit();
			
		}catch(HibernateException he)
		
		{
		System.out.println(he);
		try{
			ts.rollback();
		}catch(HibernateObjectRetrievalFailureException hrfe)
		{
			System.out.println(hrfe);
			
			
			 
		}
		}
		
		
		return saveMap;
	}

}
