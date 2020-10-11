package com.sspl.master.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sspl.entity.ContractReviewEntity;
import com.sspl.entity.ContractTypeEntity;
import com.sspl.entity.DocumentsEntity;
import com.sspl.entity.ProfileSignatoriesEntity;
import com.sspl.entity.Users;
import com.sspl.master.form.FileUploadDocForm;
import com.sspl.master.service.ContractMngmtService;
import com.sspl.utility.DataModifier;
import com.sspl.utility.Utility;

@Controller
public class ContractMngmtController {
	private Logger loggerInfo = Logger.getLogger("bankreco_info");
	private Logger loggerTech = Logger.getLogger("bankreco_tech");

	@Autowired
	private ContractMngmtService contractMngmtService;

	public void setContractMngmtService(
			ContractMngmtService contractMngmtService) {
		this.contractMngmtService = contractMngmtService;
	}
	@RequestMapping(value = "/viewContractType", method = { RequestMethod.GET,RequestMethod.POST })
	public String viewContractType(ModelMap map) 
	{
		loggerInfo.info("** &&[ viewContractType ] &&**");
		map.addAttribute("fileUploadDocForm", new FileUploadDocForm());
		Map<String, Object> viewContractType = (Map<String, Object>) contractMngmtService.viewContractType();
		map.addAttribute("contractTypeList", viewContractType.get("contractTypeList"));
		map.addAttribute("documentList", viewContractType.get("documentList"));
		map.addAttribute("profileSignatoriesEntityList", viewContractType.get("profileSignatoriesEntityList"));

		map.addAttribute("contentJsp","contractType");
		return "index";
	}

	@RequestMapping(value = "/viewContractTypeList", method = { RequestMethod.GET,RequestMethod.POST })
	public String viewContractTypeList(ModelMap map) 
	{
		loggerInfo.info("** &&[ viewContractTypeList ] &&**");
		map.addAttribute("contractTypeEntity", new ContractTypeEntity());
		Map<String, Object> viewContractTypeList = (Map<String, Object>) contractMngmtService.viewContractType();
		map.addAttribute("contractTypeList", viewContractTypeList.get("contractTypeList"));
		map.addAttribute("documentList", viewContractTypeList.get("documentList"));
		map.addAttribute("profileSignatoriesEntityList", viewContractTypeList.get("profileSignatoriesEntityList"));

		map.addAttribute("contentJsp","viewContractTypeList");
		return "index";
	}

	@RequestMapping(value = "/editContractType/{id}" , method = RequestMethod.GET)
	public String editContractType(ModelMap map,@PathVariable("id") Integer id) 
	{

		loggerInfo.info("**[ editContractType Edit ContractType]**");
		loggerTech.info("**[ editContractType Edit ContractType for edit ContractType"+id+"]**");

		Map<String, Object> viewContractType = (Map<String, Object>) contractMngmtService.editContractType(id);
		List<ContractTypeEntity> editContractTypeList=new ArrayList<ContractTypeEntity>();


		if(viewContractType.get("editContractTypeList")!=null){
			editContractTypeList=(List<ContractTypeEntity>) viewContractType.get("editContractTypeList");
		}
		map.addAttribute("readonly","true");
		map.addAttribute("readonlyTxt","readonlyTxt");
		map.addAttribute("disabled", "disabled");

		map.addAttribute("contractTypeEntity", editContractTypeList.get(0));
		map.addAttribute("editContractTypeList",viewContractType.get("editContractTypeList") );
		map.addAttribute("contractTypeList",viewContractType.get("contractTypeList") );
		map.addAttribute("documentList",viewContractType.get("documentList") );
		map.addAttribute("profileSignatoriesEntityList",viewContractType.get("profileSignatoriesEntityList") );
		
		//map.addAttribute("contentJsp","editContractType");
		map.addAttribute("contentJsp","modifyContractTypeList");
		return "index";

	}

	@RequestMapping(value = "/addContractType", method = RequestMethod.POST)
	public String saveContractType(@ModelAttribute(value="fileUploadDocForm") FileUploadDocForm fileUploadDocForm,Model map,final RedirectAttributes redirectAttributes,HttpServletRequest request) 
	{
		HttpSession  session=request.getSession();
		Users usersObj=new Users();
		ContractTypeEntity contractTypeEntity=new ContractTypeEntity();
		if(session.getAttribute("usersObj")!=null)
		{
			usersObj=(Users)session.getAttribute("usersObj");
			DataModifier obj=Utility.getDataModifier(usersObj);
			contractTypeEntity.setLastChgBy(obj.getLastChgBy());
			contractTypeEntity.setLastChgDate(obj.getLastChgDate());
			contractTypeEntity.setLastChgTime(obj.getLastChgTime());
		}

		loggerInfo.info("**[ saveFiles File Upload]**");
		String docId="";
		String signatoryId="";
		docId=fileUploadDocForm.getDocument();
		signatoryId=fileUploadDocForm.getProfile();
		System.out.println("**[ saveFiles Name "+fileUploadDocForm.getContractDocument()+"]**");
		System.out.println("**[ saveFiles  Doc type "+fileUploadDocForm.getContractTypeName()+"]**");
		System.out.println("**[ saveFiles  doc "+docId+"]**");
		System.out.println("**[ saveFiles  signatory "+signatoryId+"]**");
		System.out.println("**[ saveFiles  status  "+fileUploadDocForm.getEnabled()+"]**");
		System.out.println("**[ saveFiles  id "+fileUploadDocForm.getId()+"]**");
		System.out.println("**[ saveFiles  File "+fileUploadDocForm.getFiles()+"]**");

		
		contractTypeEntity.setContractTypeName(fileUploadDocForm.getContractTypeName());
		if(!docId.equalsIgnoreCase("")){
			DocumentsEntity documentsEntity=new DocumentsEntity();
			documentsEntity.setId(Integer.parseInt(fileUploadDocForm.getDocument()));
			contractTypeEntity.setDocumentsEntity(documentsEntity);	
		}
		if(!signatoryId.equalsIgnoreCase("")){
			ProfileSignatoriesEntity profileSignatoriesEntity=new ProfileSignatoriesEntity();
			profileSignatoriesEntity.setId(Integer.parseInt(fileUploadDocForm.getProfile()));
			contractTypeEntity.setProfileSignatoriesEntity(profileSignatoriesEntity);
		}
		contractTypeEntity.setEnabled(fileUploadDocForm.getEnabled());
		contractTypeEntity.setSignedContractPath("#");
		contractTypeEntity.setContractStatus("N");
		String rootPath="/APACHELOGS/UPLODED_FILE";
		Properties properties=new Properties();

		URL resourcePath =  Thread.currentThread().getContextClassLoader().getResource("messages_en.properties");
		try {
			properties.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(properties.getProperty("file.rootPath")!=null){
			rootPath=properties.getProperty("file.rootPath").toString().trim();
		}

		String startFileName="";
		startFileName=Utility.fileNameAppender();
		List<MultipartFile> files = fileUploadDocForm.getFiles();
		System.out.println("files.size() -->"+files.size() );
		if(null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {
				//	String name="";
				String fileName = startFileName+multipartFile.getOriginalFilename();
				contractTypeEntity.setContractDocument(multipartFile.getOriginalFilename());
				contractTypeEntity.setUploadedContractDocument(fileName);
				contractTypeEntity.setUploadedContractPath(rootPath);
				try {
					byte[] bytes = multipartFile.getBytes();

					// Creating the directory to store file
					//String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator);
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					/*				File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + name);
					 */	
					System.out.println("dir -->"+dir.getAbsolutePath());
					loggerTech.info("**[ saveFiles  Orignal "+multipartFile.getOriginalFilename()+" Name "+multipartFile.getName()+"]**");
					System.out.println("**[ saveFiles  Orignal "+multipartFile.getOriginalFilename()+" Name "+multipartFile.getName()+"]**");
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + startFileName+multipartFile.getOriginalFilename());
					System.out.println("serverFile -->"+serverFile.getAbsolutePath());
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					loggerTech.info("**[ saveFiles  Server File Location "+ serverFile.getAbsolutePath()+"]**");


				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		
		Map<String, Object> mapData=new HashMap<String, Object>();
		mapData.put("contractTypeEntity", contractTypeEntity);
		Map<String, Object> users = (Map<String, Object>) contractMngmtService.saveContractType(mapData);
		return "redirect:/viewContractTypeList";
	}
	
	@RequestMapping(value = "/downLoadDocument/{id}" , method = RequestMethod.GET)
	public String downLoadDocument(ModelMap map,@PathVariable("id") Integer id) 
	{

		loggerInfo.info("**[ downLoadDocument Edit ContractType]**");
		loggerTech.info("**[ downLoadDocument Edit ContractType for edit ContractType"+id+"]**");

		Map<String, Object> viewContractType = (Map<String, Object>) contractMngmtService.editContractType(id);
		List<ContractTypeEntity> editContractTypeList=new ArrayList<ContractTypeEntity>();


		if(viewContractType.get("editContractTypeList")!=null){
			editContractTypeList=(List<ContractTypeEntity>) viewContractType.get("editContractTypeList");
		}

		map.addAttribute("contractTypeEntity", editContractTypeList.get(0));
		map.addAttribute("editContractTypeList", editContractTypeList);
		
		map.addAttribute("contentJsp","downLoadDocument");
		return "downLoadDocument";

	}
	@RequestMapping(value = "/downLoadSignDocument/{id}" , method = RequestMethod.GET)
	public String downLoadSignDocument(ModelMap map,@PathVariable("id") Integer id) 
	{

		loggerInfo.info("**[ downLoadSignDocument Edit ContractType]**");
		loggerTech.info("**[ downLoadSignDocument Edit ContractType for edit "+id+"]**");

		Map<String, Object> viewContractType = (Map<String, Object>) contractMngmtService.editContractType(id);
		List<ContractTypeEntity> editContractTypeList=new ArrayList<ContractTypeEntity>();


		if(viewContractType.get("editContractTypeList")!=null){
			editContractTypeList=(List<ContractTypeEntity>) viewContractType.get("editContractTypeList");
		}

		map.addAttribute("contractTypeEntity", editContractTypeList.get(0));
		map.addAttribute("editContractTypeList", editContractTypeList);
		
		map.addAttribute("contentJsp","downLoadSignDocument");
		return "downLoadSignDocument";

	}
	
	//modifyContractTypeList
	@RequestMapping(value = "/modifyContractTypeList", method = { RequestMethod.GET,RequestMethod.POST })
	public String modifyContractTypeList(ModelMap map) 
	{
		loggerInfo.info("** &&[ modifyContractTypeList ] &&**");
		map.addAttribute("contractTypeEntity", new ContractTypeEntity());
		Map<String, Object> modifyContractTypeList = (Map<String, Object>) contractMngmtService.viewContractType();
		map.addAttribute("contractTypeList", modifyContractTypeList.get("contractTypeList"));
		map.addAttribute("documentList", modifyContractTypeList.get("documentList"));
		map.addAttribute("profileSignatoriesEntityList", modifyContractTypeList.get("profileSignatoriesEntityList"));

		map.addAttribute("contentJsp","modifyContractTypeList");
		return "index";
	}

	@RequestMapping(value = "/editContractTypeActive/{id}" , method = RequestMethod.POST)
	public String editContractTypeActive(ModelMap map,@PathVariable("id") Integer id) 
	{
		loggerInfo.info("**[ editContractTypeActive Edit ContractType]**");
		loggerTech.info("**[ editContractTypeActive edit ContractType for edit ContractTypeid="+id+"]**");
		Map<String, Object> viewContractType = (Map<String, Object>) contractMngmtService.editContractType(id);
		List<ContractTypeEntity> editContractTypeList=new ArrayList<ContractTypeEntity>();
		if(viewContractType.get("editContractTypeList")!=null){
			editContractTypeList=(List<ContractTypeEntity>) viewContractType.get("editContractTypeList");
		}
		map.addAttribute("readonly","false");
		map.addAttribute("contractTypeEntity", editContractTypeList.get(0));
		map.addAttribute("editContractTypeList",viewContractType.get("editContractTypeList") );
		map.addAttribute("contractTypeList",viewContractType.get("contractTypeList") );
		map.addAttribute("documentList",viewContractType.get("documentList") );
		map.addAttribute("profileSignatoriesEntityList",viewContractType.get("profileSignatoriesEntityList") );
		
		map.addAttribute("contentJsp","modifyContractTypeList");
		return "index";
	}


	@RequestMapping(value = "/modifyContractType/{id}")
	public String modifyContractType(@PathVariable("id") Integer id,@ModelAttribute(value="contractTypeEntity") ContractTypeEntity contractTypeEntity,HttpServletRequest request, BindingResult result) 
	{

		HttpSession  session=request.getSession();
		Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
			usersObj=(Users)session.getAttribute("usersObj");
			contractTypeEntity.setLastChgBy(usersObj.getId());
			contractTypeEntity.setLastChgTime("");
		}
		contractTypeEntity.setLastChgDate(new Date());
		loggerInfo.info("**[ modifyContractType Update ContractType]**");
		loggerTech.info("**[ modifyContractType Update ContractType]]**");

		contractTypeEntity.setId(id);
		
		String profileid=request.getParameter("profile");
		if(profileid!=""){
			ProfileSignatoriesEntity profileEntity=new ProfileSignatoriesEntity();
			profileEntity.setId(Integer.parseInt(profileid));
			contractTypeEntity.setProfileSignatoriesEntity(profileEntity);	
		}
		
		String documentid=request.getParameter("document");
		if(documentid!=""){
			DocumentsEntity documentsEntity=new DocumentsEntity();
			documentsEntity.setId(Integer.parseInt(documentid));
			contractTypeEntity.setDocumentsEntity(documentsEntity);	
		}
		System.out.println("modifyContractTypeList ** profileid ["+profileid+"] documentid ["+documentid+"]");
		Map<String, Object> map=new HashMap<String, Object>();

		map.put("contractTypeEntity", contractTypeEntity);

		Map<String, Object> viewUser = (Map<String, Object>) contractMngmtService.modifyContractType(map);
		//return "redirect:/viewContractType";
		return "redirect:/modifyContractTypeList";
	}


	/*
	 * Code for Contract Review
	 */
	@RequestMapping(value = "/viewContractReview", method = { RequestMethod.GET,RequestMethod.POST })
	public String viewContractReview(ModelMap map) 
	{
		loggerInfo.info("** &&[ viewContractReview ] &&**");
		map.addAttribute("contractReviewEntity", new ContractReviewEntity());
		Map<String, Object> viewContractReview = (Map<String, Object>) contractMngmtService.viewContractReview();
		map.addAttribute("contractReviewList", viewContractReview.get("contractReviewList"));
		map.addAttribute("profileSignatoriesEntityList", viewContractReview.get("profileSignatoriesEntityList"));

		map.addAttribute("contentJsp","contractReview");
		return "index";
	}


	@RequestMapping(value = "/editContractReview/{id}" , method = RequestMethod.GET)
	public String editContractReview(ModelMap map,@PathVariable("id") Integer id) 
	{

		loggerInfo.info("**[ editContractReview Edit ContractReview]**");
		loggerTech.info("**[ editContractReview Edit ContractReview for edit ContractReview"+id+"]**");

		Map<String, Object> viewContractReview = (Map<String, Object>) contractMngmtService.editContractReview(id);
		List<ContractReviewEntity> editContractReviewList=new ArrayList<ContractReviewEntity>();
		if(viewContractReview.get("editContractReviewList")!=null){
			editContractReviewList=(List<ContractReviewEntity>) viewContractReview.get("editContractReviewList");
		}
		map.addAttribute("readonly","true");
		map.addAttribute("readonlyTxt","readonlyTxt");
		map.addAttribute("disabled", "disabled");

		map.addAttribute("contractReviewEntity", editContractReviewList.get(0));
		map.addAttribute("editContractReviewList",viewContractReview.get("editContractReviewList") );
		map.addAttribute("contractReviewList",viewContractReview.get("contractReviewList") );
		map.addAttribute("profileSignatoriesEntityList",viewContractReview.get("profileSignatoriesEntityList") );
		
		map.addAttribute("contentJsp","editContractReview");
		return "index";

	}

	@RequestMapping(value = "/addContractReview", method = RequestMethod.POST)
	public String saveContractReview(@ModelAttribute(value="ContractReviewEntity") ContractReviewEntity contractReviewEntity,HttpServletRequest request, BindingResult result) 
	{
		HttpSession  session=request.getSession();
		Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
			usersObj=(Users)session.getAttribute("usersObj");
			contractReviewEntity.setLastChgBy(usersObj.getId());
			contractReviewEntity.setLastChgTime("");
		}

		Map<String, Object> map=new HashMap<String, Object>();
		String profileid=request.getParameter("profile");
		System.out.println("saveContractReview profileid-->"+profileid);
		if(profileid!=""){
			ProfileSignatoriesEntity profileEntity=new ProfileSignatoriesEntity();
			profileEntity.setId(Integer.parseInt(profileid));
			contractReviewEntity.setProfileSignatoriesEntity(profileEntity);	
		}
		
		
		map.put("contractReviewEntity", contractReviewEntity);
		Map<String, Object> users = (Map<String, Object>) contractMngmtService.saveContractReview(map);
		return "redirect:/viewContractReview";
	}

	@RequestMapping(value = "/editContractReviewActive/{id}" , method = RequestMethod.POST)
	public String editContractReviewActive(ModelMap map,@PathVariable("id") Integer id) 
	{
		loggerInfo.info("**[ editContractReviewActive Edit ContractReview]**");
		loggerTech.info("**[ editContractReviewActive edit ContractReview for edit ContractReviewid="+id+"]**");
		Map<String, Object> viewContractReview = (Map<String, Object>) contractMngmtService.editContractReview(id);
		List<ContractReviewEntity> editContractReviewList=new ArrayList<ContractReviewEntity>();
		if(viewContractReview.get("editContractReviewList")!=null){
			editContractReviewList=(List<ContractReviewEntity>) viewContractReview.get("editContractReviewList");
		}
		map.addAttribute("readonly","false");
		map.addAttribute("contractReviewEntity", editContractReviewList.get(0));
		map.addAttribute("editContractReviewList",viewContractReview.get("editContractReviewList") );
		map.addAttribute("contractReviewList",viewContractReview.get("contractReviewList") );
		map.addAttribute("profileSignatoriesEntityList",viewContractReview.get("profileSignatoriesEntityList") );
		
		map.addAttribute("contentJsp","editContractReview");
		return "index";
	}


	@RequestMapping(value = "/modifyContractReview/{id}")
	public String modifyContractReview(@PathVariable("id") Integer id,@ModelAttribute(value="contractReviewEntity") ContractReviewEntity contractReviewEntity,HttpServletRequest request, BindingResult result) 
	{

		HttpSession  session=request.getSession();
		Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
			usersObj=(Users)session.getAttribute("usersObj");
			contractReviewEntity.setLastChgBy(usersObj.getId());
			contractReviewEntity.setLastChgTime("");
		}
		contractReviewEntity.setLastChgDate(new Date());
		loggerInfo.info("**[ modifyContractReview Update ContractReview]**");
		loggerTech.info("**[ modifyContractReview Update ContractReview]]**");
		contractReviewEntity.setId(id);
		String profileid=request.getParameter("profile");
		System.out.println("modifyContractReview profileid-->"+profileid);
		if(profileid!=""){
			ProfileSignatoriesEntity profileEntity=new ProfileSignatoriesEntity();
			profileEntity.setId(Integer.parseInt(profileid));
			contractReviewEntity.setProfileSignatoriesEntity(profileEntity);	
		}
		
		Map<String, Object> map=new HashMap<String, Object>();

		map.put("contractReviewEntity", contractReviewEntity);

		Map<String, Object> viewUser = (Map<String, Object>) contractMngmtService.modifyContractReview(map);
		return "redirect:/viewContractReview";
	}


}
