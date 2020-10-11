package com.sspl.master.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sspl.entity.Department;
import com.sspl.entity.EmployeeEntity;
import com.sspl.entity.Role;
import com.sspl.entity.Users;
import com.sspl.entity.UsersEntity;
import com.sspl.master.service.UserService;

/**
 * 
 * @author Mukesh Narayan Singh
 *
 */
@Controller
public class UserController 
{
	private Logger loggerInfo = Logger.getLogger("bankreco_info");
	private Logger loggerTech = Logger.getLogger("bankreco_tech");
	
	@Autowired
	private UserService userService;
	
	public void setUserService(
			UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping(value = "/viewUser", method = { RequestMethod.GET,RequestMethod.POST })
	public String viewUser(ModelMap map) 
	{
		loggerInfo.info("** &&[ viewUser Users] &&**");
		map.addAttribute("usersEntity", new UsersEntity());
		Map<String, Object> viewUser = (Map<String, Object>) userService.viewUser();
		map.addAttribute("userList", viewUser.get("userList"));
		map.addAttribute("roleList",viewUser.get("roleList"));
		map.addAttribute("employeList",viewUser.get("employeList"));
		map.addAttribute("contentJsp","user");
		return "index";
	
		//return "user";
	}
	
	@RequestMapping(value = "/editUser/{id}" , method = RequestMethod.GET)
	public String editUser(ModelMap map,@PathVariable("id") Integer id) 
	{
		
		loggerInfo.info("**[ editUser Edit User]**");
		loggerTech.info("**[ editUser Edit User for edit User"+id+"]**");
	
		Map<String, Object> viewUser = (Map<String, Object>) userService.editUser(id);
		List<UsersEntity> editUserList=new ArrayList<UsersEntity>();
		
		
		if(viewUser.get("editUserList")!=null){
			editUserList=(List<UsersEntity>) viewUser.get("editUserList");
		}
		map.addAttribute("readonly","true");
		map.addAttribute("readonlyTxt","readonlyTxt");
		map.addAttribute("disabled", "disabled");
		
		map.addAttribute("usersEntity", editUserList.get(0));
		map.addAttribute("employeList",viewUser.get("employeList"));
		map.addAttribute("roleList",viewUser.get("roleList") );
		map.addAttribute("userList", viewUser.get("userList"));
		map.addAttribute("roles",viewUser.get("roles"));
		map.addAttribute("contentJsp","editUser");
		return "index";
	
	}
	
	

	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute(value="usersEntity") UsersEntity usersEntity,HttpServletRequest request, BindingResult result) 
	{
		HttpSession  session=request.getSession();
		 Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
		usersObj=(Users)session.getAttribute("usersObj");
		}
		System.out.println(request.getParameter("roleId"));
		
		Map<String, Object> map=new HashMap<String, Object>();
		int roleid=Integer.parseInt(request.getParameter("roleId"));
	    Role role=new Role();
	    role.setId(roleid);
	    usersEntity.setRoleObj(role);
		map.put("usersEntity", usersEntity);
		map.put("role", role);
		
		
		Map<String, Object> users = (Map<String, Object>) userService.saveUser(map);
		return "redirect:/viewUser";
	}
	
	@RequestMapping(value = "/editUserActive/{id}" , method = RequestMethod.POST)
	public String editUserActive(ModelMap map,@PathVariable("id") Integer id) 
	{
		loggerInfo.info("**[ editUserActive Edit user]**");
		loggerTech.info("**[ editUserActive edit user for edit userid="+id+"]**");
		Map<String, Object> viewUser = (Map<String, Object>) userService.editUser(id);
	List<UsersEntity> editUserList=new ArrayList<UsersEntity>();
	if(viewUser.get("editUserList")!=null){
		editUserList=(List<UsersEntity>) viewUser.get("editUserList");
	}
	map.addAttribute("readonly","false");
	map.addAttribute("usersEntity", editUserList.get(0));
	
	map.addAttribute("employeList",viewUser.get("employeList") );
	map.addAttribute("roleList",viewUser.get("roleList") );
	map.addAttribute("userList", viewUser.get("userList"));
	map.addAttribute("roles",viewUser.get("roles"));
	
	map.addAttribute("contentJsp","editUser");
	return "index";
	}
	
	
	@RequestMapping(value = "/modifyUser/{id}")
	public String modifyUser(@PathVariable("id") Integer id,@ModelAttribute(value="usersEntity") UsersEntity usersEntity,HttpServletRequest request, BindingResult result) 
	{
		
		HttpSession  session=request.getSession();
		 Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
		usersObj=(Users)session.getAttribute("usersObj");
		usersEntity.setModifiedBy(usersObj.getId());
		}
		usersEntity.setModifiedDate(new Date());
		loggerInfo.info("**[ modifyUser Update User]**");
		loggerTech.info("**[ modifyUser Update User]]**");
		
		usersEntity.setId(id);
		
		System.out.println("check======"+id);
		Map<String, Object> map=new HashMap<String, Object>();
		int role=Integer.parseInt(request.getParameter("roleId"));
		Role role2=new Role();
		role2.setId(role);
		System.out.println("role======="+role);
	    usersEntity.setRoleObj(role2);
		map.put("usersEntity", usersEntity);
		map.put("role",role2 );
		Map<String, Object> viewUser = (Map<String, Object>) userService.modifyUser(map);
		return "redirect:/viewUser";
	}
	
}