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

import com.sspl.entity.ProfileEntity;
import com.sspl.entity.Users;
import com.sspl.master.service.ProfileService;

/**
 * 
 * @author Mukesh Narayan Singh
 *
 */
@Controller
public class ProfileController {

	private Logger loggerInfo = Logger.getLogger("bankreco_info");
	private Logger loggerTech = Logger.getLogger("bankreco_tech");
	
	@Autowired
	private ProfileService profileService;
	
	public void setProfileService(
			ProfileService profileService) {
		this.profileService = profileService;
	}
	@RequestMapping(value = "/viewProfile", method = { RequestMethod.GET,RequestMethod.POST })
	public String viewProfile(ModelMap map) 
	{
		loggerInfo.info("** &&[ viewProfile ] &&**");
		map.addAttribute("profileEntity", new ProfileEntity());
		Map<String, Object> viewProfile = (Map<String, Object>) profileService.viewProfile();
		map.addAttribute("profileList", viewProfile.get("profileList"));
		map.addAttribute("contentJsp","profile");
		return "index";
	}

	
	@RequestMapping(value = "/editProfile/{id}" , method = RequestMethod.GET)
	public String editProfile(ModelMap map,@PathVariable("id") Integer id) 
	{
		
		loggerInfo.info("**[ editProfile Edit Profile]**");
		loggerTech.info("**[ editProfile Edit Profile for edit Profile"+id+"]**");
	
		Map<String, Object> viewProfile = (Map<String, Object>) profileService.editProfile(id);
		List<ProfileEntity> editProfileList=new ArrayList<ProfileEntity>();
		
		
		if(viewProfile.get("editProfileList")!=null){
			editProfileList=(List<ProfileEntity>) viewProfile.get("editProfileList");
		}
		map.addAttribute("readonly","true");
		map.addAttribute("readonlyTxt","readonlyTxt");
		map.addAttribute("disabled", "disabled");
		
		map.addAttribute("profileEntity", editProfileList.get(0));
		map.addAttribute("profileList", viewProfile.get("profileList"));
		map.addAttribute("contentJsp","editProfile");
		return "index";
	
	}
	
	

	
	@RequestMapping(value = "/addProfile", method = RequestMethod.POST)
	public String saveProfile(@ModelAttribute(value="profileEntity") ProfileEntity profileEntity,HttpServletRequest request, BindingResult result) 
	{
		HttpSession  session=request.getSession();
		 Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
		usersObj=(Users)session.getAttribute("usersObj");
		}
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("profileEntity", profileEntity);
		
		
		Map<String, Object> profile = (Map<String, Object>) profileService.saveProfile(map);
		return "redirect:/viewProfile";
	}
	
	@RequestMapping(value = "/editProfileActive/{id}" , method = RequestMethod.POST)
	public String editProfileActive(ModelMap map,@PathVariable("id") Integer id) 
	{
		loggerInfo.info("**[ editProfileActive Edit Profile]**");
		loggerTech.info("**[ editProfileActive edit Profile for edit profileid="+id+"]**");
		Map<String, Object> viewProfile = (Map<String, Object>) profileService.editProfile(id);
	List<ProfileEntity> editProfileList=new ArrayList<ProfileEntity>();
	if(viewProfile.get("editProfileList")!=null){
		editProfileList=(List<ProfileEntity>) viewProfile.get("editProfileList");
	}
	map.addAttribute("readonly","false");
	map.addAttribute("profileEntity", editProfileList.get(0));
	map.addAttribute("profileList", viewProfile.get("profileList"));
	
	map.addAttribute("contentJsp","editProfile");
	return "index";
	}
	
	
	@RequestMapping(value = "/modifyProfile/{id}")
	public String modifyProfile(@PathVariable("id") Integer id,@ModelAttribute(value="profileEntity") ProfileEntity profileEntity,HttpServletRequest request, BindingResult result) 
	{
		
		HttpSession  session=request.getSession();
		 Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
		usersObj=(Users)session.getAttribute("usersObj");
		}
		profileEntity.setLastChgDate(new Date());
		loggerInfo.info("**[ modifyProfile Update Profile]**");
		loggerTech.info("**[ modifyProfile Update Profile]**");
		
		profileEntity.setId(id);
		
		System.out.println("check======"+id);
		Map<String, Object> map=new HashMap<String, Object>();

		map.put("profileEntity", profileEntity);
				
		Map<String, Object> viewProfile = (Map<String, Object>) profileService.modifyProfile(map);
		return "redirect:/viewProfile";
	}
	


}
