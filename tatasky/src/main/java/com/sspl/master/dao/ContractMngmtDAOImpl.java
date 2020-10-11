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

import com.sspl.entity.ContractReviewEntity;
import com.sspl.entity.ContractTypeEntity;
import com.sspl.entity.DocumentsEntity;
import com.sspl.entity.ProfileSignatoriesEntity;

@Service
public class ContractMngmtDAOImpl implements ContractMngmtDAO {

	private Logger loggerInfo = Logger.getLogger("tatasky_info");
	private Logger loggerTech = Logger.getLogger("tatasky_tech");
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Map<String, Object> viewContractType() {
			loggerInfo.info("**[ viewContractType List ]**");
			Map<String, Object> mapData=new HashMap<String, Object>();
			List<ContractTypeEntity> contractTypeList=new ArrayList<ContractTypeEntity>();
			List<DocumentsEntity> documentList=new ArrayList<DocumentsEntity>();
			List<ProfileSignatoriesEntity> profileSignatoriesEntityList=new ArrayList<ProfileSignatoriesEntity>();
			
			contractTypeList=this.sessionFactory.getCurrentSession().createQuery("from ContractTypeEntity").list();
			documentList=this.sessionFactory.getCurrentSession().createQuery("from DocumentsEntity where status='1'").list();
			profileSignatoriesEntityList=this.sessionFactory.getCurrentSession().createQuery("from ProfileSignatoriesEntity where status='1'").list();
			
			mapData.put("contractTypeList", contractTypeList);
			mapData.put("documentList", documentList);
			mapData.put("profileSignatoriesEntityList", profileSignatoriesEntityList);
			return mapData;
		}

	@Override
	public Map<String, Object> editContractType(Integer id) {
		Map<String, Object> mapData=new HashMap<String, Object>();
		loggerInfo.info("**[ editContractType Edit ContractType  ]**");
		loggerTech.info("**[ editContractType Edit ContractType ContractTypeid "+id+"]**");
		
		List<ContractTypeEntity> editContractTypeList=new ArrayList<ContractTypeEntity>();
		List<ContractTypeEntity> contractTypeList=new ArrayList<ContractTypeEntity>();
		List<DocumentsEntity> documentList=new ArrayList<DocumentsEntity>();
		List<ProfileSignatoriesEntity> profileSignatoriesEntityList=new ArrayList<ProfileSignatoriesEntity>();
		
		editContractTypeList=this.sessionFactory.getCurrentSession().createQuery("from ContractTypeEntity as ue where ue.id="+id).list();
		contractTypeList=this.sessionFactory.getCurrentSession().createQuery("from ContractTypeEntity").list();
		documentList=this.sessionFactory.getCurrentSession().createQuery("from DocumentsEntity where status='1'").list();
		profileSignatoriesEntityList=this.sessionFactory.getCurrentSession().createQuery("from ProfileSignatoriesEntity where status='1'").list();

		mapData.put("editContractTypeList", editContractTypeList);
		mapData.put("contractTypeList", contractTypeList);
		mapData.put("documentList", documentList);
		mapData.put("profileSignatoriesEntityList", profileSignatoriesEntityList);
		return mapData;
	}

	@Override
	public Map<String, Object> saveContractType(Map<String, Object> map) {
		System.out.println("************ In save ContractType in ContractTypeDAO imple *****************");
		loggerInfo.info("**[ saveContractType Save ContractType ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		List<ContractTypeEntity> uniquedata=new  ArrayList<ContractTypeEntity>();
		ContractTypeEntity entity=new ContractTypeEntity();
		entity=(ContractTypeEntity)map.get("contractTypeEntity");
        
		uniquedata=(List<ContractTypeEntity>)this.sessionFactory.getCurrentSession().createCriteria(ContractTypeEntity.class).add(Restrictions.eq("contractTypeName", entity.getContractTypeName())).list(); 
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
    		loggerInfo.info("**[ ContractType Saved ]**");
    		
    	}catch(RuntimeException e){
    		try
    		{
    			loggerTech.info("**[ saveContractType Couldn’t roll back transaction ]**");
    			tx.rollback();
    		}
    		catch(RuntimeException rbe)
    		{
    			loggerTech.info("**[ saveContractType Couldn’t roll back transaction ]**");
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
	public Map<String, Object> modifyContractType(Map<String, Object> map) {
		loggerInfo.info("**[ modifyContractType update ContractType  ]**");
		loggerTech.info("**[ modifyContractType update ContractType ContractTypeid ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		ContractTypeEntity contractTypeEntity=new ContractTypeEntity();
		contractTypeEntity=(ContractTypeEntity)map.get("contractTypeEntity");
		
		Session session = null;
    	Transaction tx = null;
 
    	try{
    		session = this.sessionFactory.openSession();
    		tx = session.beginTransaction();
    		if(contractTypeEntity!=null && contractTypeEntity.getId()!=null && contractTypeEntity.getId()>0){
    			ContractTypeEntity editcontractTypeEntity= (ContractTypeEntity) session.load(
    					ContractTypeEntity.class, contractTypeEntity.getId());
    	        if (null != editcontractTypeEntity) 
    	        {
    	        	
    	        	//editcontractTypeEntity.setContractDocument(contractTypeEntity.getContractDocument());
    	        	editcontractTypeEntity.setContractTypeName(contractTypeEntity.getContractTypeName());
    	        	editcontractTypeEntity.setDocumentsEntity(contractTypeEntity.getDocumentsEntity());
    	        	editcontractTypeEntity.setEnabled(contractTypeEntity.getEnabled());
    	        	editcontractTypeEntity.setProfileSignatoriesEntity(contractTypeEntity.getProfileSignatoriesEntity());
    	        	editcontractTypeEntity.setLastChgBy(contractTypeEntity.getLastChgBy());
    	        	editcontractTypeEntity.setLastChgDate(new Date());
    	        	editcontractTypeEntity.setLastChgTime(contractTypeEntity.getLastChgTime());
    	        	session.saveOrUpdate(editcontractTypeEntity);
        			loggerTech.info("**[ modifycontractType  Data found ]**");
    	        }
    		}else{
    			loggerTech.info("**[ modifycontractType  No Data found ]**");
    		} 
    		tx.commit();
    	}catch(RuntimeException e){
    		try{
    			loggerTech.info("**[ modifycontractType  roll back transaction ]**");

    			tx.rollback();
    		}catch(RuntimeException rbe){
    			loggerTech.info("**[ modifycontractType Couldn’t roll back transaction ]**");

    		}
    		throw e;
    	}finally{
    		if(session!=null){
    			session.close();
    		}
    	}
				return mapData;
	}

	
	@Override
	public Map<String, Object> viewContractReview() {
			loggerInfo.info("**[ viewContractReview List ]**");
			Map<String, Object> mapData=new HashMap<String, Object>();
			List<ContractReviewEntity> contractReviewList=new ArrayList<ContractReviewEntity>();
			List<ProfileSignatoriesEntity> profileSignatoriesEntityList=new ArrayList<ProfileSignatoriesEntity>();
			
			contractReviewList=this.sessionFactory.getCurrentSession().createQuery("from ContractReviewEntity").list();
			profileSignatoriesEntityList=this.sessionFactory.getCurrentSession().createQuery("from ProfileSignatoriesEntity where status='1'").list();
			
			mapData.put("contractReviewList", contractReviewList);
			mapData.put("profileSignatoriesEntityList", profileSignatoriesEntityList);
			return mapData;
		}

	@Override
	public Map<String, Object> editContractReview(Integer id) {
		Map<String, Object> mapData=new HashMap<String, Object>();
		loggerInfo.info("**[ editContractReview Edit ContractReview  ]**");
		loggerTech.info("**[ editContractReview Edit ContractReview ContractReviewid "+id+"]**");
		
		List<ContractReviewEntity> editContractReviewList=new ArrayList<ContractReviewEntity>();
		List<ContractReviewEntity> contractReviewList=new ArrayList<ContractReviewEntity>();
		List<ProfileSignatoriesEntity> profileSignatoriesEntityList=new ArrayList<ProfileSignatoriesEntity>();
		
		editContractReviewList=this.sessionFactory.getCurrentSession().createQuery("from ContractReviewEntity as ue where ue.id="+id).list();
		contractReviewList=this.sessionFactory.getCurrentSession().createQuery("from ContractReviewEntity").list();
		profileSignatoriesEntityList=this.sessionFactory.getCurrentSession().createQuery("from ProfileSignatoriesEntity where status='1'").list();

		mapData.put("editContractReviewList", editContractReviewList);
		mapData.put("contractReviewList", contractReviewList);
		mapData.put("profileSignatoriesEntityList", profileSignatoriesEntityList);
		return mapData;
	}

	@Override
	public Map<String, Object> saveContractReview(Map<String, Object> map) {
		System.out.println("************ In save ContractReview in ContractReviewDAO imple *****************");
		loggerInfo.info("**[ saveContractReview Save ContractReview ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		List<ContractReviewEntity> uniquedata=new  ArrayList<ContractReviewEntity>();
		ContractReviewEntity entity=new ContractReviewEntity();
		entity=(ContractReviewEntity)map.get("contractReviewEntity");
        
		uniquedata=(List<ContractReviewEntity>)this.sessionFactory.getCurrentSession().createCriteria(ContractReviewEntity.class).add(Restrictions.eq("contractReviewName", entity.getContractReviewName())).list(); 
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
    		loggerInfo.info("**[ ContractReview Saved ]**");
    		
    	}catch(RuntimeException e){
    		try
    		{
    			loggerTech.info("**[ saveContractReview Couldn’t roll back transaction ]**");
    			tx.rollback();
    		}
    		catch(RuntimeException rbe)
    		{
    			loggerTech.info("**[ saveContractReview Couldn’t roll back transaction ]**");
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
	public Map<String, Object> modifyContractReview(Map<String, Object> map) {
		loggerInfo.info("**[ modifyContractReview update ContractReview  ]**");
		loggerTech.info("**[ modifyContractReview update ContractReview ContractReviewid ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		ContractReviewEntity contractReviewEntity=new ContractReviewEntity();
		contractReviewEntity=(ContractReviewEntity)map.get("contractReviewEntity");
		
		Session session = null;
    	Transaction tx = null;
 
    	try{
    		session = this.sessionFactory.openSession();
    		tx = session.beginTransaction();
    		if(contractReviewEntity!=null && contractReviewEntity.getId()!=null && contractReviewEntity.getId()>0){
    			ContractReviewEntity editcontractReviewEntity= (ContractReviewEntity) session.load(
    					ContractReviewEntity.class, contractReviewEntity.getId());
    	        if (null != editcontractReviewEntity) 
    	        {
    	        	
    	        	editcontractReviewEntity.setContractReviewName(contractReviewEntity.getContractReviewName());
    	        	editcontractReviewEntity.setProfileSignatoriesEntity(contractReviewEntity.getProfileSignatoriesEntity());
    	        	editcontractReviewEntity.setEnabled(contractReviewEntity.getEnabled());
    	        	editcontractReviewEntity.setLastChgBy(contractReviewEntity.getLastChgBy());
    	        	editcontractReviewEntity.setLastChgDate(new Date());
    	        	editcontractReviewEntity.setLastChgTime(contractReviewEntity.getLastChgTime());
    	        	session.saveOrUpdate(editcontractReviewEntity);
        			loggerTech.info("**[ modifycontractReview  Data found ]**");
    	        }
    		}else{
    			loggerTech.info("**[ modifycontractReview  No Data found ]**");
    		} 
    		tx.commit();
    	}catch(RuntimeException e){
    		try{
    			loggerTech.info("**[ modifycontractReview  roll back transaction ]**");

    			tx.rollback();
    		}catch(RuntimeException rbe){
    			loggerTech.info("**[ modifycontractReview Couldn’t roll back transaction ]**");

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
