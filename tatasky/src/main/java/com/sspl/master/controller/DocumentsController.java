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

import com.sspl.entity.DocumentsEntity;
import com.sspl.entity.SignatoryEntity;
import com.sspl.entity.Users;
import com.sspl.master.service.DocumentService;

@Controller
public class DocumentsController {
	private Logger loggerInfo = Logger.getLogger("bankreco_info");
	private Logger loggerTech = Logger.getLogger("bankreco_tech");

	@Autowired
	private DocumentService documentService;

	public void setDocumentService(
			DocumentService documentService) {
		this.documentService = documentService;
	}
	@RequestMapping(value = "/viewDocuments", method = { RequestMethod.GET,RequestMethod.POST })
	public String viewDocuments(ModelMap map) 
	{
		loggerInfo.info("** &&[ viewDocuments ] &&**");
		map.addAttribute("documentsEntity", new DocumentsEntity());
		Map<String, Object> viewDocuments = (Map<String, Object>) documentService.viewDocuments();
		map.addAttribute("documentsList", viewDocuments.get("documentsList"));
		map.addAttribute("contentJsp","viewDocuments");
		return "index";
	}


	@RequestMapping(value = "/editDocuments/{id}" , method = RequestMethod.GET)
	public String editDocuments(ModelMap map,@PathVariable("id") Integer id) 
	{

		loggerInfo.info("**[ editDocuments Edit Documents]**");
		loggerTech.info("**[ editDocuments Edit Documents for edit Documents"+id+"]**");

		Map<String, Object> viewDocuments = (Map<String, Object>) documentService.editDocuments(id);
		List<DocumentsEntity> editDocumentsList=new ArrayList<DocumentsEntity>();


		if(viewDocuments.get("editDocumentsList")!=null){
			editDocumentsList=(List<DocumentsEntity>) viewDocuments.get("editDocumentsList");
		}
		map.addAttribute("readonly","true");
		map.addAttribute("readonlyTxt","readonlyTxt");
		map.addAttribute("disabled", "disabled");

		map.addAttribute("documentsEntity", editDocumentsList.get(0));
		map.addAttribute("editDocumentsList",viewDocuments.get("editDocumentsList") );
		map.addAttribute("documentsList",viewDocuments.get("documentsList") );
		
		map.addAttribute("contentJsp","editDocuments");
		return "index";

	}

	@RequestMapping(value = "/addDocuments", method = RequestMethod.POST)
	public String saveDocuments(@ModelAttribute(value="DocumentsEntity") DocumentsEntity documentsEntity,HttpServletRequest request, BindingResult result) 
	{
		HttpSession  session=request.getSession();
		Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
			usersObj=(Users)session.getAttribute("usersObj");
			documentsEntity.setLastChgBy(usersObj.getId());
			documentsEntity.setLastChgTime("");
		}

		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("documentsEntity", documentsEntity);
		Map<String, Object> users = (Map<String, Object>) documentService.saveDocuments(map);
		return "redirect:/viewDocuments";
	}

	@RequestMapping(value = "/editDocumentsActive/{id}" , method = RequestMethod.POST)
	public String editDocumentsActive(ModelMap map,@PathVariable("id") Integer id) 
	{
		loggerInfo.info("**[ editDocumentsActive Edit Documents]**");
		loggerTech.info("**[ editDocumentsActive edit Documents for edit Documentsid="+id+"]**");
		Map<String, Object> viewDocuments = (Map<String, Object>) documentService.editDocuments(id);
		List<DocumentsEntity> editDocumentsList=new ArrayList<DocumentsEntity>();
		if(viewDocuments.get("editDocumentsList")!=null){
			editDocumentsList=(List<DocumentsEntity>) viewDocuments.get("editDocumentsList");
		}
		map.addAttribute("readonly","false");
		map.addAttribute("documentsEntity", editDocumentsList.get(0));
		map.addAttribute("documentsList", viewDocuments.get("documentsList"));

		map.addAttribute("contentJsp","editDocuments");
		return "index";
	}


	@RequestMapping(value = "/modifyDocuments/{id}")
	public String modifyDocuments(@PathVariable("id") Integer id,@ModelAttribute(value="DocumentsEntity") DocumentsEntity documentsEntity,HttpServletRequest request, BindingResult result) 
	{

		HttpSession  session=request.getSession();
		Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
			usersObj=(Users)session.getAttribute("usersObj");
			documentsEntity.setLastChgBy(usersObj.getId());
			documentsEntity.setLastChgTime("");
		}
		documentsEntity.setLastChgDate(new Date());
		loggerInfo.info("**[ modifyDocuments Update Documents]**");
		loggerTech.info("**[ modifyDocuments Update Documents]]**");

		documentsEntity.setId(id);

		Map<String, Object> map=new HashMap<String, Object>();

		map.put("documentsEntity", documentsEntity);

		Map<String, Object> viewUser = (Map<String, Object>) documentService.modifyDocuments(map);
		return "redirect:/viewDocuments";
	}


	/*
	 * Code for Contract Review
	 */
	@RequestMapping(value = "/viewSignatory", method = { RequestMethod.GET,RequestMethod.POST })
	public String viewSignatory(ModelMap map) 
	{
		loggerInfo.info("** &&[ viewSignatory ] &&**");
		map.addAttribute("signatoryEntity", new SignatoryEntity());
		Map<String, Object> viewSignatory = (Map<String, Object>) documentService.viewSignatory();
		map.addAttribute("signatoryList", viewSignatory.get("signatoryList"));

		map.addAttribute("contentJsp","viewSignatory");
		return "index";
	}


	@RequestMapping(value = "/editSignatory/{id}" , method = RequestMethod.GET)
	public String editSignatory(ModelMap map,@PathVariable("id") Integer id) 
	{

		loggerInfo.info("**[ editSignatory Edit Signatory]**");
		loggerTech.info("**[ editSignatory Edit Signatory for edit Signatory"+id+"]**");

		Map<String, Object> viewSignatory = (Map<String, Object>) documentService.editSignatory(id);
		List<SignatoryEntity> editSignatoryList=new ArrayList<SignatoryEntity>();
		if(viewSignatory.get("editSignatoryList")!=null){
			editSignatoryList=(List<SignatoryEntity>) viewSignatory.get("editSignatoryList");
		}
		map.addAttribute("readonly","true");
		map.addAttribute("readonlyTxt","readonlyTxt");
		map.addAttribute("disabled", "disabled");

		map.addAttribute("signatoryEntity", editSignatoryList.get(0));
		map.addAttribute("editSignatoryList",viewSignatory.get("editSignatoryList") );
		map.addAttribute("signatoryList",viewSignatory.get("signatoryList") );
		
		map.addAttribute("contentJsp","editSignatory");
		return "index";

	}

	@RequestMapping(value = "/addSignatory", method = RequestMethod.POST)
	public String saveSignatory(@ModelAttribute(value="SignatoryEntity") SignatoryEntity signatoryEntity,HttpServletRequest request, BindingResult result) 
	{
		HttpSession  session=request.getSession();
		Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
			usersObj=(Users)session.getAttribute("usersObj");
			signatoryEntity.setLastChgBy(usersObj.getId());
			signatoryEntity.setLastChgTime("");
		}

		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("signatoryEntity", signatoryEntity);
		Map<String, Object> users = (Map<String, Object>) documentService.saveSignatory(map);
		return "redirect:/viewSignatory";
	}

	@RequestMapping(value = "/editSignatoryActive/{id}" , method = RequestMethod.POST)
	public String editSignatoryActive(ModelMap map,@PathVariable("id") Integer id) 
	{
		loggerInfo.info("**[ editSignatoryActive Edit Signatory]**");
		loggerTech.info("**[ editSignatoryActive edit Signatory for edit Signatoryid="+id+"]**");
		System.out.println("**[ editSignatoryActive edit Signatory for edit Signatoryid="+id+"]**");
		Map<String, Object> viewSignatory = (Map<String, Object>) documentService.editSignatory(id);
		List<SignatoryEntity> editSignatoryList=new ArrayList<SignatoryEntity>();
		if(viewSignatory.get("editSignatoryList")!=null){
			editSignatoryList=(List<SignatoryEntity>) viewSignatory.get("editSignatoryList");
		}
		map.addAttribute("readonly","false");
		map.addAttribute("signatoryEntity", editSignatoryList.get(0));
		map.addAttribute("signatoryList", viewSignatory.get("signatoryList"));

		map.addAttribute("contentJsp","editSignatory");
		return "index";
	}


	@RequestMapping(value = "/modifySignatory/{id}")
	public String modifySignatory(@PathVariable("id") Integer id,@ModelAttribute(value="SignatoryEntity") SignatoryEntity signatoryEntity,HttpServletRequest request, BindingResult result) 
	{

		HttpSession  session=request.getSession();
		Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
			usersObj=(Users)session.getAttribute("usersObj");
			signatoryEntity.setLastChgBy(usersObj.getId());
			signatoryEntity.setLastChgTime("");
		}
		signatoryEntity.setLastChgDate(new Date());
		loggerInfo.info("**[ modifyUser Update User]**");
		loggerTech.info("**[ modifyUser Update User]]**");

		signatoryEntity.setId(id);

		Map<String, Object> map=new HashMap<String, Object>();

		map.put("signatoryEntity", signatoryEntity);

		Map<String, Object> viewUser = (Map<String, Object>) documentService.modifySignatory(map);
		return "redirect:/viewSignatory";
	}


}
