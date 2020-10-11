package com.sspl.master.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sspl.entity.EmployeeEntity;
import com.sspl.entity.Users;
import com.sspl.master.service.LoginService;
import com.sspl.utility.Utility;

/**
 * @author Mukesh Narayan Singh
 *
 */
@Controller
public class LoginController {
	//private static Logger logger = Logger.getLogger(LoginController.class);
	private Logger loggerInfo = Logger.getLogger("tatasky_info");
	private Logger loggerTech = Logger.getLogger("tatasky_tech");

@Autowired
private LoginService loginService;
	public LoginService getLoginService() {
	return loginService;
}
public void setLoginService(LoginService loginService) {
	this.loginService = loginService;
}
	@RequestMapping(value="/welcome1", method = RequestMethod.GET)
	public String executeSecurity(ModelMap model, Principal principal ) {
		
		System.out.println("**********executeSecurity**********");
		model.addAttribute("message", "Welcome To Login Form Based Spring Security Example!!!");
		return "viewBank";
 
	}
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap map,HttpServletRequest request,HttpServletResponse response) {
		map.addAttribute("user", new Users());
		Users usersObj=new Users();
	
		java.util.Enumeration<String> sessEnum = request.getSession().getAttributeNames();
		 String userName="";
		 String password="";
		String sessionAttr = null;
		 while (sessEnum.hasMoreElements()) {
		       String s = sessEnum.nextElement();

		       //System.out.println("s-->"+s);
		       SecurityContextImpl s1=null;
		       Users users=null;
			try {
				   
				   Object object=(Object)request.getSession().getAttribute(s);
				   if(object instanceof Users){
					   users = (Users)request.getSession().getAttribute(s);
				//	   System.out.println("User Object");
				   }else if(object instanceof SecurityContextImpl){
					   s1 = (SecurityContextImpl)request.getSession().getAttribute(s);
					//   System.out.println("SecurityContextImpl object");
				   }
				   
				   if(users!=null){
					   userName=users.getUserName();   
				   }else{
					   userName=s1.getAuthentication().getName();   
					   sessionAttr=""+s1;
				   }
				   String uname="";
				   if(request.getAttribute("j_username")!=null){
					   uname=(String)request.getAttribute("j_username");
				   }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		   }
/*		 Key[org.springframework.security.core.context.SecurityContextImpl@45255fd3] value[ Authentication]
				 Key[ Password] value[ [PROTECTED]]
				 Key[ Enabled] value[ true]
				 Key[ AccountNonExpired] value[ true]
				 Key[ credentialsNonExpired] value[ true]
				 Key[ AccountNonLocked] value[ true]
				 Key[ Granted Authorities] value[ ROLE_ADMIN]
				 Key[ Credentials] value[ [PROTECTED]]
				 Key[ Authenticated] value[ true]
				 Key[ Details] value[ org.springframework.security.web.authentication.WebAuthenticationDetails@957e]
				 Key[ SessionId] value[ null]
				 Key[ Granted Authorities] value[ ROLE_ADMIN]
				 User [admin] Role [ ROLE_ADMIN]
*/
		 
		 Map<String, Object> mapData = new HashMap<String, Object>();
		 mapData=Utility.getSessionAttribute(sessionAttr);
		 String role="";
		 if(mapData.get("Granted Authorities")!=null){
			 role=(String)mapData.get("Granted Authorities");
		 }
		 System.out.println("userName ["+userName+"]role ["+role+"]");
			usersObj.setUserRole(role.trim());
			usersObj.setUserName(userName);
		 
		String url="";
		try {
			url=request.getRemoteAddr();
		} catch (Exception e) {
			
		}
		Map<String, Object> mapValidate=new HashMap<String,Object>();
		
		mapValidate.put("url",url);
		mapValidate.put("userName", userName);
		mapValidate.put("password", password);
		mapValidate=loginService.validate(mapValidate);
		int userId=0;
		if(mapValidate.get("userId")!=null){
			userId=(Integer)mapValidate.get("userId");
		}
		List<Users> usersList=new ArrayList<Users>();
		if(mapValidate.get("usersList")!=null){
			usersList=(List<Users>)mapValidate.get("usersList");
		}
		if(usersList.size()>0){
			usersObj=usersList.get(0);
		}
		System.out.println("Employee Id "+usersObj.getEmployeeEntity().getId());
		usersObj.setUserName(userName);
	
		request.getSession().setAttribute("usersObj", usersObj);
		usersObj.setId(""+userId);
		map.addAttribute("usersObj", usersObj);
		
		map.addAttribute("roleApp", mapValidate.get("roleApp"));
		map.addAttribute("message", mapValidate.get("message"));
		map.addAttribute("usersLogList", mapValidate.get("usersLogList"));
		
	/*	mapData.put("userName", userName);
		mapData.put("password", password);
		mapData=loginService.validate(mapData);
		System.out.println("User ["+userName+"] Role ["+role+"]");
	*/	
		String accountNo="";
		
		System.out.println("accountNo-->"+accountNo);
		Map<String, Object> errorMap=new HashMap<String, Object>();
		String logingMsgInfo="";
		String logingMsgTech="";
		String logAppMsg="";
		logAppMsg="Login] Account No ["+accountNo+"]";
		errorMap=Utility.getLogMsg(usersObj,logAppMsg);
		logingMsgInfo=(String)errorMap.get("logingMsgInfo");
		logingMsgTech=(String)errorMap.get("logingMsgTech");
		loggerInfo.info(logingMsgInfo);
		loggerInfo.info(logingMsgTech);
		//return "loginNew";
		map.put("mapData", mapData);
//		return "home";
		return "index";
		
	}

	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(ModelMap map,HttpServletRequest request,HttpServletResponse response) {
		map.addAttribute("user", new Users());
		//Users usersObj=new Users();
		HttpSession session = request.getSession();
		Users usersObj=new Users();
		
		if(session.getAttribute("usersObj")!=null){
			usersObj=(Users)session.getAttribute("usersObj");
		}
		String url="";
		try {
			url=request.getRemoteAddr();
		} catch (Exception e) {
			
		}
		Map<String, Object> mapData=new HashMap<String,Object>();
		mapData.put("url",url);
		mapData.put("userName", usersObj.getUserName());
		mapData=loginService.home(mapData);
		
		Map<String, Object> errorMap=new HashMap<String, Object>();
		String logingMsgInfo="";
		String logingMsgTech="";
		errorMap=Utility.getLogMsg(usersObj,"Home");
		logingMsgInfo=(String)errorMap.get("logingMsgInfo");
		logingMsgTech=(String)errorMap.get("logingMsgTech");
		loggerInfo.info(logingMsgInfo);
		loggerInfo.info(logingMsgTech);
		
		map.addAttribute("usersLogList", mapData.get("usersLogList"));
		request.getSession().setAttribute("usersLogList", mapData.get("usersLogList"));
		
		
		map.addAttribute("usersObj", usersObj);
		//return "loginNew";
		map.addAttribute("contentJsp","home1");
		return "index";
 
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap map) {
		Users users=new Users();
		users.setUserName("Admin");
		
		map.addAttribute("users",users);
		map.addAttribute("usersObj", users);
		map.put("userName", "admin");
		//return "loginNew";
		return "login";
 
	}
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validate(ModelMap map,@ModelAttribute(value="user") Users user, BindingResult result,HttpServletRequest request,HttpServletResponse response) 
	{
		Users usersObj=new Users();
		
		
		String userName="";
		String password="";
		if(user.getUserName()!=null){
			userName=user.getUserName();
		}
		if(user.getPassword()!=null){
			password=user.getPassword();
		}

		//loggerInfo.info("user ["+userName +"] pwd ["+password+"]");
		if(userName.equalsIgnoreCase("") && password.equalsIgnoreCase("")){
			return "redirect:/login";
		}
		Map<String, Object> mapData=new HashMap<String,Object>();
		mapData.put("userName", userName);
		mapData.put("password", password);

		String url="";
		try {
			url=request.getRemoteAddr();
		} catch (Exception e) {
			
		}
		System.out.println("url-->"+url);
		mapData.put("url",url);

		mapData=loginService.validate(mapData);
		//return "redirect:/viewBank";
		//Set<Application> roleApp =
		map.addAttribute("roleApp", mapData.get("roleApp"));
		
	/*	String role="";
		 if(mapData.get("Granted Authorities")!=null){
			 role=(String)mapData.get("Granted Authorities");
		 }
			usersObj.setUserRole(role.trim());
	*/		
		List<Users> usersList=new ArrayList<Users>();
		if(mapData.get("usersList")!=null){
			usersList=(List<Users>)mapData.get("usersList");
		}
		if(usersList.size()>0){
			usersObj=usersList.get(0);
		}
		System.out.println("Employee Id "+usersObj.getEmployeeEntity().getId());
		usersObj.setUserName(userName);
	
	map.addAttribute("usersLogList", mapData.get("usersLogList"));
	request.getSession().setAttribute("usersObj", usersObj);
	request.getSession().setAttribute("usersLogList", mapData.get("usersLogList"));
		
		//return "navigation";
		return "index";
	}
 
	@RequestMapping(value="/fail2login", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		loggerInfo.info("**********loginerror**********");
		loggerTech.info("**********loginerror**********");
		model.addAttribute("error", "true");
		return "403";
 
	}
	@RequestMapping(value="/sessionExpired", method = RequestMethod.GET)
	public String sessionExpired(ModelMap model,HttpServletRequest request,HttpServletResponse response)
	 {	
		 HttpSession session = request.getSession();
		 if(session!=null){
			 session.removeAttribute("usersObj");
			 session.invalidate();
		 }
		 model.addAttribute("error", "true");
		return "500";
 
	}

	@RequestMapping(value="/logoutSuccess", method = RequestMethod.GET)
	public String logout(ModelMap map,HttpServletRequest request,HttpServletResponse response)
	 {	
		HttpSession session = request.getSession();
		Users usersObj=new Users();
		
		if(session.getAttribute("usersObj")!=null){
			usersObj=(Users)session.getAttribute("usersObj");
		}
		Map<String, Object> errorMap=new HashMap<String, Object>();
		String logingMsgInfo="";
		String logingMsgTech="";
		errorMap=Utility.getLogMsg(usersObj,"Logout");
		logingMsgInfo=(String)errorMap.get("logingMsgInfo");
		logingMsgTech=(String)errorMap.get("logingMsgTech");
		loggerInfo.info(logingMsgInfo);
		loggerInfo.info(logingMsgTech);
		
		 if(session!=null){
			 session.removeAttribute("usersObj");
			 session.invalidate();
		 }
		
		 map.put("messageLogout", "Logout Successfully...");
		return "customLogin";
		//return "loginTataSky";
	 }
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String customLogin(ModelMap map,HttpServletRequest request,HttpServletResponse response)
	 {	
		 return "customLogin";
		// return "loginTataSky";
	 }
	/*@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "login";
 
	}*/
	@RequestMapping(value="/loginDb", method = RequestMethod.GET)
	public String loginDb(ModelMap map) {
		Users users=new Users();
		users.setUserName("Admin");
		map.addAttribute("users",users);
		map.addAttribute("usersObj", users);
		return "loginNew";
 
	}

}
