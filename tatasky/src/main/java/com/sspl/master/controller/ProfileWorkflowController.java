package com.sspl.master.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sspl.entity.DocumentsEntity;
import com.sspl.entity.ProfileEntity;
import com.sspl.entity.ProfileSignatoriesEntity;
import com.sspl.entity.Role;
import com.sspl.entity.SignatoryEntity;
import com.sspl.entity.Users;
import com.sspl.entity.UsersEntity;
import com.sspl.master.service.ProfileWorkflowService;

/**
 * 
 * @author Mukesh Narayan Singh
 *
 */
@Controller
public class ProfileWorkflowController {

		private Logger loggerInfo = Logger.getLogger("bankreco_info");
		private Logger loggerTech = Logger.getLogger("bankreco_tech");
		
		@Autowired
		private ProfileWorkflowService profileWorkflowService;
		
		public void setProfileWorkflow(
				ProfileWorkflowService profileWorkflowService) {
			this.profileWorkflowService = profileWorkflowService;
		}
		@RequestMapping(value = "/viewProfileWorkflow", method = { RequestMethod.GET,RequestMethod.POST })
		public String viewProfileWorkflow(ModelMap map) 
		{
			loggerInfo.info("** &&[ viewProfile ] &&**");
			map.addAttribute("profileSignatoriesEntity", new ProfileSignatoriesEntity());
			Map<String, Object> viewProfileWorkflow = (Map<String, Object>) profileWorkflowService.viewProfileWorkflow();
			map.addAttribute("profileSignatoriesList", viewProfileWorkflow.get("profileSignatoriesList"));
			map.addAttribute("signatoriesList", viewProfileWorkflow.get("signatoriesList"));
			map.addAttribute("profileList", viewProfileWorkflow.get("profileList"));
			map.addAttribute("documentsList", viewProfileWorkflow.get("documentsList"));
			map.addAttribute("contentJsp","profileWorkFlow");
			return "index";
		}
		@RequestMapping(value = "/addProfileWorkflow", method = RequestMethod.POST)
		public String saveProfileWorkflow(@ModelAttribute(value="profileSignatoriesEntity") ProfileSignatoriesEntity profileSignatoriesEntity,HttpServletRequest request, BindingResult result) 
		{
			HttpSession  session=request.getSession();
			 Users usersObj=new Users();
			if(session.getAttribute("usersObj")!=null)
			{
			usersObj=(Users)session.getAttribute("usersObj");
			}
			System.out.println(request.getParameter("profile"));
			
			Map<String, Object> map=new HashMap<String, Object>();
			
			String profileId=request.getParameter("profile");	
			String documentId=request.getParameter("document");
			String signatory1Id=request.getParameter("signatory1");
			String signatory2Id=request.getParameter("signatory2");
			String signatory3Id=request.getParameter("signatory3");
			String signatory4Id=request.getParameter("signatory4");
			String signatory5Id=request.getParameter("signatory5");
			
			if(profileId!=""){
				ProfileEntity profileEntity=new ProfileEntity();
				profileEntity.setId(Integer.parseInt(profileId));
				profileSignatoriesEntity.setProfileEntity(profileEntity);
			}
			if(documentId!=""){
				DocumentsEntity documentsEntity=new DocumentsEntity();
				documentsEntity.setId(Integer.parseInt(documentId));
				profileSignatoriesEntity.setDocumentsEntity(documentsEntity);
			}
			if(signatory1Id!=""){
				SignatoryEntity signatoryEntity=new SignatoryEntity();
				signatoryEntity.setId(Integer.parseInt(signatory1Id));
				profileSignatoriesEntity.setSignatoryEntity1(signatoryEntity);
			}
			if(signatory2Id!=""){
				SignatoryEntity signatoryEntity=new SignatoryEntity();
				signatoryEntity.setId(Integer.parseInt(signatory2Id));
				profileSignatoriesEntity.setSignatoryEntity2(signatoryEntity);
			}
			if(signatory3Id!=""){
				SignatoryEntity signatoryEntity=new SignatoryEntity();
				signatoryEntity.setId(Integer.parseInt(signatory3Id));
				profileSignatoriesEntity.setSignatoryEntity3(signatoryEntity);
			}
			if(signatory4Id!=""){
				SignatoryEntity signatoryEntity=new SignatoryEntity();
				signatoryEntity.setId(Integer.parseInt(signatory4Id));
				profileSignatoriesEntity.setSignatoryEntity4(signatoryEntity);
			}
			if(signatory5Id!=""){
				SignatoryEntity signatoryEntity=new SignatoryEntity();
				signatoryEntity.setId(Integer.parseInt(signatory5Id));
				profileSignatoriesEntity.setSignatoryEntity5(signatoryEntity);
			}
			System.out.println("profileId ["+profileId+"]documentId ["+documentId+"]signatory1Id ["+signatory1Id+"] ["+signatory2Id+"]["+signatory3Id+"] ["+signatory4Id+"] ["+signatory5Id+"]");
			map.put("profileSignatoriesEntity", profileSignatoriesEntity);
			
			
			Map<String, Object> users = (Map<String, Object>) profileWorkflowService.saveProfileWorkflow(map);
			return "redirect:/viewProfileWorkflow";
		}


}
