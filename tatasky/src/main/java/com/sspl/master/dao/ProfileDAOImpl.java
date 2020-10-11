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

import com.sspl.entity.ProfileEntity;
import com.sspl.entity.Role;

public class ProfileDAOImpl implements ProfileDAO {
	private Logger loggerInfo = Logger.getLogger("tatasky_info");
	private Logger loggerTech = Logger.getLogger("tatasky_tech");

	@Autowired
	private SessionFactory sessionFactory;

	public Map<String, Object> viewProfile() 
	{
		loggerInfo.info("**[ viewProfile Profile List ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		List<ProfileEntity> profileList=new ArrayList<ProfileEntity>();
		profileList=this.sessionFactory.getCurrentSession().createQuery("from ProfileEntity").list();
		mapData.put("profileList", profileList);
		return mapData;
	}

	public Map<String, Object> modifyProfile(Map<String, Object> map) {
		loggerInfo.info("**[ modifyProfile update Profile  ]**");
		loggerTech.info("**[ modifyProfile update Profile profileid ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		ProfileEntity profileEntity=new ProfileEntity();
		profileEntity=(ProfileEntity)map.get("profileEntity");

		Session session = null;
		Transaction tx = null;

		try{
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
			if(profileEntity!=null && profileEntity.getId()!=null && profileEntity.getId()>0){
				ProfileEntity editProfileEntity= (ProfileEntity) session.load(
						ProfileEntity.class, profileEntity.getId());
				if (null != editProfileEntity) 
				{

					editProfileEntity.setProfileName(profileEntity.getProfileName());
					editProfileEntity.setProfileDescription(profileEntity.getProfileDescription());
					editProfileEntity.setInputFolder(profileEntity.getInputFolder());
					editProfileEntity.setOutputFolder(profileEntity.getOutputFolder());

					editProfileEntity.setEnabled(profileEntity.getEnabled());
					editProfileEntity.setLastChgBy(profileEntity.getLastChgBy());
					editProfileEntity.setLastChgDate(profileEntity.getLastChgDate());
					editProfileEntity.setLastChgTime(profileEntity.getLastChgTime());


					session.saveOrUpdate(editProfileEntity);
					loggerTech.info("**[ modifyProfile  Data found ]**");
				}
			}else{
				loggerTech.info("**[ modifyProfile  No Data found ]**");
			} 


			tx.commit();


		}catch(RuntimeException e){
			try{
				loggerTech.info("**[ modifyProfile  roll back transaction ]**");

				tx.rollback();
			}catch(RuntimeException rbe){
				loggerTech.info("**[ modifyProfile Couldn’t roll back transaction ]**");

			}
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return mapData;
	}

	public Map<String, Object> saveProfile(Map<String, Object> map) {
		System.out.println("************ In save Profile in ProfileDAO imple *****************");
		loggerInfo.info("**[ saveProfile Save Profile ]**");
		Map<String, Object> mapData=new HashMap<String, Object>();
		List<ProfileEntity> uniquedata=new  ArrayList<ProfileEntity>();
		ProfileEntity entity=new ProfileEntity();
		entity=(ProfileEntity)map.get("profileEntity");

		uniquedata=(List<ProfileEntity>)this.sessionFactory.getCurrentSession().createCriteria(ProfileEntity.class).add(Restrictions.eq("profileName", entity.getProfileName())).list(); 
		System.out.println("size=="+uniquedata.size());
		if(uniquedata.size()>0)
		{
			mapData.put("alreadyexisting",uniquedata);
		}else{
			Session session = null;
			Transaction tx = null;
			try{
				session = this.sessionFactory.openSession();
				tx = session.beginTransaction();
				session.save(entity);
				tx.commit();
				loggerInfo.info("**[ Profile Saved ]**");

			}catch(RuntimeException e){
				try
				{
					loggerTech.info("**[ saveProfile Couldn’t roll back transaction ]**");
					tx.rollback();
				}
				catch(RuntimeException rbe)
				{
					loggerTech.info("**[ saveProfile Couldn’t roll back transaction ]**");
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

	public Map<String, Object> editProfile(Integer id) {
		Map<String, Object> mapData=new HashMap<String, Object>();
		loggerInfo.info("**[ editProfile Edit Profile  ]**");
		loggerTech.info("**[ editProfile Edit Profileid "+id+"]**");

		List<ProfileEntity> profileList=new ArrayList<ProfileEntity>();
		List<ProfileEntity> editProfileList=new ArrayList<ProfileEntity>();
		List<Role> roles=new ArrayList<Role>();
		editProfileList=this.sessionFactory.getCurrentSession().createQuery("from ProfileEntity as ue where ue.id="+id).list();
		profileList=this.sessionFactory.getCurrentSession().createQuery("from ProfileEntity").list();
		mapData.put("editProfileList", editProfileList);
		mapData.put("profileList", profileList);

		return mapData;
	}
}
