package com.sspl.master.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sspl.entity.Application;
import com.sspl.entity.Users;
import com.sspl.entity.UsersLog;
import com.sspl.utility.ApplicationComparator;
import com.sspl.utility.Utility;

/**
 * 
 * @author Mukesh Narayan Singh
 *
 */
@Repository
public class LoginDAOImpl implements LoginDAO {
	private Logger loggerInfo = Logger.getLogger("tatasky_info");
	private Logger loggerTech = Logger.getLogger("tatasky_tech");
	
	@Autowired
	private SessionFactory sessionFactory;

	public Map<String, Object> validate(Map<String, Object> mapData) {
		Map<String, Object> map=new HashMap<String, Object>();
		String userName="";
		String password="";
		if(mapData.get("userName")!=null){
			userName=(String)mapData.get("userName");
		}
		if(mapData.get("password")!=null){
			password=(String)mapData.get("password");
		}
		String url="";
		if(mapData.get("url")!=null){
			url=(String)mapData.get("url");
		}
		List<UsersLog> usersLogList=new ArrayList<UsersLog>();
		List<Users> usersList=new ArrayList<Users>();
		Set<Application> roleApp = ApplicationComparator .getApplicationTreeSet();
		List<Object[]> userList=new ArrayList<Object[]>();
		try{
		
			System.out.println("userName-->"+userName);
			String userRoleSql="SELECT users.user_id,role.role_name,role.role_id FROM role,users WHERE role.role_id=users.role_id AND users.enabled='1' AND role.enabled='Y' AND users.username ='"+userName+"' ";
		//	userList=this.sessionFactory.getCurrentSession().createQuery("from Users where password='"+password+"' and userName='"+userName+"' ").list();
		userList=this.sessionFactory.getCurrentSession().createSQLQuery(userRoleSql).list();
		
		int roleId=0;
		int userId=0;
			if(userList!=null && userList.size()>0){
				for (Iterator iterator = userList.iterator(); iterator
						.hasNext();) {
					Object[] objects = (Object[]) iterator.next();
					if(objects[2]!=null && !objects[2].toString().equalsIgnoreCase("")){
						roleId=Integer.parseInt(objects[2].toString());
						userId=Integer.parseInt(objects[0].toString());
						System.out.println("userId-->"+userId);
					}
				}
					
				//String userRollAppSql= "select * from user_role_application where role_id="+roleId;
				String userRollAppSql= "select app.app_id,app.name,app.url,app.parent_id from role_application as ura , application as app where app.app_id=ura.app_id and app.status='Y' and ura.role_id="+roleId;
				List<Object[]> userRollAppList=new ArrayList<Object[]>();
				List<Application> appList=new ArrayList<Application>();
				userRollAppList=this.sessionFactory.getCurrentSession().createSQLQuery(userRollAppSql).list();
				if(userRollAppList.size()>0){
					for (Iterator iterator = userRollAppList.iterator(); iterator
							.hasNext();) {
						Object[] objects = (Object[]) iterator.next();
						Application application=new Application();
						application.setApp_id(""+objects[0]);
						application.setName(""+objects[1]);
						application.setUrl(""+objects[2]);
						application.setParent_id(""+objects[3]);
						//application.setPermission(""+objects[4]);
						application.setPermission("0");
						appList.add(application);
						//System.out.println("App name "+objects[1]);
						roleApp.add(application);
					}
				}
				
			}else{
				map.put("message", "Not Authorized User");
			}
			if(roleApp.size()>0){
				map.put("roleApp", roleApp);	
			}else{
				map.put("message", "Not Authorized User");
			}
			Map<String, Object> dateMap = new HashMap<String, Object>();
		    String currentDate = "";
		    String currentTime="";
			dateMap = Utility.getCurrentDateAndTime();
			if (dateMap.get("currentDate")!= null) {
				currentDate = (String)dateMap.get("currentDate");
			}
			if (dateMap.get("currentTime")!= null) {
				currentTime = (String)dateMap.get("currentTime");
			}
			UsersLog usersLog=new UsersLog();
		       usersLog.setLastBy(userName);
		       if(userId>0){
		    	   usersLog.setUsersId(new Integer(userId));
		       }
		       usersLog.setLoginDate(Utility.convertStringTypeDateToDateType(currentDate));
		       usersLog.setStatus("Y");
		       usersLog.setLoginTime(currentTime);
		       usersLog.setUserIp(url);
		       this.sessionFactory.getCurrentSession().save(usersLog);
		       usersList=this.sessionFactory.getCurrentSession().createQuery("from Users ul where ul.id="+userId).list();
		       usersLogList=this.sessionFactory.getCurrentSession().createQuery("from UsersLog ul where ul.usersId="+userId+" order by id desc").list();
		       map.put("userId", userId);
		       map.put("usersList", usersList);
		} catch (Exception e) {
			e.printStackTrace();
			//throw e;
		}
		map.put("usersLogList", usersLogList);
	       
		return map;
	}

	public Map<String, Object> home(Map<String, Object> mapData) {
		Map<String, Object> map=new HashMap<String, Object>();
		   List<UsersLog> usersLogList=new ArrayList<UsersLog>();
	       usersLogList=this.sessionFactory.getCurrentSession().createQuery("from UsersLog ul order by id desc").list();
	       map.put("usersLogList", usersLogList);
		
		return map;
	}


}
