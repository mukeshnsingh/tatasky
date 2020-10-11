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

import com.sspl.entity.DocumentsEntity;
import com.sspl.entity.SignatoryEntity;

@Service
public class DocumentDAOImpl implements DocumentDAO {

	private Logger loggerInfo = Logger.getLogger("tatasky_info");
	private Logger loggerTech = Logger.getLogger("tatasky_tech");
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Map<String, Object> viewDocuments() {
			loggerInfo.info("**[ viewDocuments List ]**");
			Map<String, Object> mapData=new HashMap<String, Object>();
			List<DocumentsEntity> documentsList=new ArrayList<DocumentsEntity>();
			documentsList=this.sessionFactory.getCurrentSession().createQuery("from DocumentsEntity").list();
			mapData.put("documentsList", documentsList);
			return mapData;
		}

	@Override
	public Map<String, Object> editDocuments(Integer id) {
		Map<String, Object> mapData=new HashMap<String, Object>();
		loggerInfo.info("**[ editDocuments Edit Documents  ]**");
		loggerTech.info("**[ editDocuments Edit Documents Documentsid "+id+"]**");
		
		List<DocumentsEntity> editDocumentsList=new ArrayList<DocumentsEntity>();
		List<DocumentsEntity> documentsList=new ArrayList<DocumentsEntity>();
		
		editDocumentsList=this.sessionFactory.getCurrentSession().createQuery("from DocumentsEntity as ue where ue.id="+id).list();
		documentsList=this.sessionFactory.getCurrentSession().createQuery("from DocumentsEntity").list();

		mapData.put("editDocumentsList", editDocumentsList);
		mapData.put("documentsList", documentsList);
		return mapData;
	}

	@Override
	public Map<String, Object> saveDocuments(Map<String, Object> map) {
		System.out.println("************ In save Documents in DocumentsDAO imple *****************");
		loggerInfo.info("**[ saveDocuments Save Documents ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		List<DocumentsEntity> uniquedata=new  ArrayList<DocumentsEntity>();
		DocumentsEntity entity=new DocumentsEntity();
		entity=(DocumentsEntity)map.get("documentsEntity");
        
		uniquedata=(List<DocumentsEntity>)this.sessionFactory.getCurrentSession().createCriteria(DocumentsEntity.class).add(Restrictions.eq("DocumentsName", entity.getDocumentName())).list(); 
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
    		loggerInfo.info("**[ Documents Saved ]**");
    		
    	}catch(RuntimeException e){
    		try
    		{
    			loggerTech.info("**[ saveDocuments Couldn’t roll back transaction ]**");
    			tx.rollback();
    		}
    		catch(RuntimeException rbe)
    		{
    			loggerTech.info("**[ saveDocuments Couldn’t roll back transaction ]**");
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
	public Map<String, Object> modifyDocuments(Map<String, Object> map) {
		loggerInfo.info("**[ modifyDocuments update Documents  ]**");
		loggerTech.info("**[ modifyDocuments update Documents Documentsid ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		DocumentsEntity documentsEntity=new DocumentsEntity();
		documentsEntity=(DocumentsEntity)map.get("documentsEntity");
		
		Session session = null;
    	Transaction tx = null;
 
    	try{
    		session = this.sessionFactory.openSession();
    		tx = session.beginTransaction();
    		if(documentsEntity!=null && documentsEntity.getId()!=null && documentsEntity.getId()>0){
    			DocumentsEntity editDocumentsEntity= (DocumentsEntity) session.load(
    					DocumentsEntity.class, documentsEntity.getId());
    	        if (null != editDocumentsEntity) 
    	        {
    	        	
    	        	editDocumentsEntity.setDocumentCode(documentsEntity.getDocumentCode());
    	        	editDocumentsEntity.setDocumentName(documentsEntity.getDocumentName());
    	        	editDocumentsEntity.setStatus(documentsEntity.getStatus());
    	        	editDocumentsEntity.setLastChgBy(documentsEntity.getLastChgBy());
    	        	editDocumentsEntity.setLastChgDate(new Date());
    	        	editDocumentsEntity.setLastChgTime(documentsEntity.getLastChgTime());
    	        	session.saveOrUpdate(editDocumentsEntity);
        			loggerTech.info("**[ modifyDocuments  Data found ]**");
    	        }
    		}else{
    			loggerTech.info("**[ modifyDocuments  No Data found ]**");
    		} 
    		tx.commit();
    	}catch(RuntimeException e){
    		try{
    			loggerTech.info("**[ modifyDocuments  roll back transaction ]**");

    			tx.rollback();
    		}catch(RuntimeException rbe){
    			loggerTech.info("**[ modifyDocuments Couldn’t roll back transaction ]**");

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
	public Map<String, Object> viewSignatory() {
			loggerInfo.info("**[ viewSignatory List ]**");
			Map<String, Object> mapData=new HashMap<String, Object>();
			List<SignatoryEntity> signatoryList=new ArrayList<SignatoryEntity>();
			
			signatoryList=this.sessionFactory.getCurrentSession().createQuery("from SignatoryEntity").list();
			
			mapData.put("signatoryList", signatoryList);
			return mapData;
		}

	@Override
	public Map<String, Object> editSignatory(Integer id) {
		Map<String, Object> mapData=new HashMap<String, Object>();
		loggerInfo.info("**[ editSignatory Edit Signatory  ]**");
		loggerTech.info("**[ editSignatory Edit Signatory Signatoryid "+id+"]**");
		
		List<SignatoryEntity> editSignatoryList=new ArrayList<SignatoryEntity>();
		List<SignatoryEntity> signatoryList=new ArrayList<SignatoryEntity>();
		
		editSignatoryList=this.sessionFactory.getCurrentSession().createQuery("from SignatoryEntity as ue where ue.id="+id).list();
		signatoryList=this.sessionFactory.getCurrentSession().createQuery("from SignatoryEntity").list();

		mapData.put("editSignatoryList", editSignatoryList);
		mapData.put("signatoryList", signatoryList);
		return mapData;
	}

	@Override
	public Map<String, Object> saveSignatory(Map<String, Object> map) {
		System.out.println("************ In save Signatory in SignatoryDAO imple *****************");
		loggerInfo.info("**[ saveSignatory Save Signatory ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		List<SignatoryEntity> uniquedata=new  ArrayList<SignatoryEntity>();
		SignatoryEntity entity=new SignatoryEntity();
		entity=(SignatoryEntity)map.get("signatoryEntity");
        
		uniquedata=(List<SignatoryEntity>)this.sessionFactory.getCurrentSession().createCriteria(SignatoryEntity.class).add(Restrictions.eq("signatoriesName", entity.getSignatoriesName())).list(); 
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
    		loggerInfo.info("**[ Signatory Saved ]**");
    		
    	}catch(RuntimeException e){
    		try
    		{
    			loggerTech.info("**[ saveSignatory Couldn’t roll back transaction ]**");
    			tx.rollback();
    		}
    		catch(RuntimeException rbe)
    		{
    			loggerTech.info("**[ saveSignatory Couldn’t roll back transaction ]**");
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
	public Map<String, Object> modifySignatory(Map<String, Object> map) {
		loggerInfo.info("**[ modifySignatory update Signatory  ]**");
		loggerTech.info("**[ modifySignatory update Signatory Signatoryid ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		SignatoryEntity signatoryEntity=new SignatoryEntity();
		signatoryEntity=(SignatoryEntity)map.get("signatoryEntity");
		
		Session session = null;
    	Transaction tx = null;
 
    	try{
    		session = this.sessionFactory.openSession();
    		tx = session.beginTransaction();
    		if(signatoryEntity!=null && signatoryEntity.getId()!=null && signatoryEntity.getId()>0){
    			SignatoryEntity editSignatoryEntity= (SignatoryEntity) session.load(
    					SignatoryEntity.class, signatoryEntity.getId());
    	        if (null != editSignatoryEntity) 
    	        {
    	        	
    	        	editSignatoryEntity.setSignatoriesName(signatoryEntity.getSignatoriesName());
    	        	editSignatoryEntity.setSignatoriesCode(signatoryEntity.getSignatoriesCode());
    	        	editSignatoryEntity.setEnabled(signatoryEntity.getEnabled());
    	        	editSignatoryEntity.setLastChgBy(signatoryEntity.getLastChgBy());
    	        	editSignatoryEntity.setLastChgDate(new Date());
    	        	editSignatoryEntity.setLastChgTime(signatoryEntity.getLastChgTime());
    	        	session.saveOrUpdate(editSignatoryEntity);
        			loggerTech.info("**[ modifySignatory  Data found ]**");
    	        }
    		}else{
    			loggerTech.info("**[ modifySignatory  No Data found ]**");
    		} 
    		tx.commit();
    	}catch(RuntimeException e){
    		try{
    			loggerTech.info("**[ modifySignatory  roll back transaction ]**");

    			tx.rollback();
    		}catch(RuntimeException rbe){
    			loggerTech.info("**[ modifySignatory Couldn’t roll back transaction ]**");

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
