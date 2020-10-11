package com.sspl.master.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

import com.sspl.entity.ContractTypeEntity;
import com.sspl.entity.DocumentWorkflowEntity;
import com.sspl.entity.DocumentsEntity;
import com.sspl.entity.EmployeeEntity;
import com.sspl.entity.ProfileSignatoriesEntity;
import com.sspl.entity.SignatoriesMappingEntiry;
import com.sspl.entity.SignatoryEntity;
import com.sspl.entity.Users;
import com.sspl.master.form.DocumentApprovarForm;
import com.sspl.master.service.DocumentApprovalService;
import com.sspl.utility.DataModifier;
import com.sspl.utility.Utility;

@Controller
public class DocumentApprovalController {
	private Logger loggerInfo = Logger.getLogger("bankreco_info");
	private Logger loggerTech = Logger.getLogger("bankreco_tech");

	@Autowired
	private DocumentApprovalService  documentApprovalService;

	public void setDocumentApprovalService(DocumentApprovalService documentApprovalService) {
		this.documentApprovalService = documentApprovalService;
	}
	
	@RequestMapping(value = "/followupDocumentList", method = { RequestMethod.GET,RequestMethod.POST })
	public String followupDocumentList(ModelMap map) 
	{
		loggerInfo.info("** &&[ followupDocumentList ] &&**");
		map.addAttribute("contractTypeEntity", new ContractTypeEntity());
		Map<String, Object> viewPendingDocument = (Map<String, Object>) documentApprovalService.followupDocumentList();
		map.addAttribute("contractTypeList", viewPendingDocument.get("contractTypeList"));
		map.addAttribute("documentList", viewPendingDocument.get("documentList"));
		map.addAttribute("profileSignatoriesEntityList", viewPendingDocument.get("profileSignatoriesEntityList"));

		map.addAttribute("contentJsp","followupDocumentList");
		return "index";
	}
	@RequestMapping(value = "/editFollowupDocumentList/{id}" , method = RequestMethod.GET)
	public String editFollowupDocumentList(ModelMap map,@PathVariable("id") Integer id,HttpServletRequest request) 
	{

		loggerInfo.info("**[ editFollowupDocumentList Edit ContractType]**");
		loggerTech.info("**[ editFollowupDocumentList Edit ContractType for edit ContractType"+id+"]**");
		HttpSession  session=request.getSession();
		Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
			usersObj=(Users)session.getAttribute("usersObj");
		}
		System.out.println();
		Map<String, Object> mapData=new HashMap<String, Object>();
		mapData.put("employeeId", usersObj.getEmployeeEntity().getId());
		mapData.put("documentId", id);
		Map<String, Object> viewContractType = (Map<String, Object>) documentApprovalService.editFollowupDocumentList(mapData);
		List<ContractTypeEntity> editContractTypeList=new ArrayList<ContractTypeEntity>();

		if(viewContractType.get("editContractTypeList")!=null){
			editContractTypeList=(List<ContractTypeEntity>) viewContractType.get("editContractTypeList");
		}
		List<SignatoriesMappingEntiry> profileSignatoriesMappingList=new ArrayList<SignatoriesMappingEntiry>();
		if(viewContractType.get("profileSignatoriesMappingList")!=null){
			profileSignatoriesMappingList=(List<SignatoriesMappingEntiry>) viewContractType.get("profileSignatoriesMappingList");
		}
		System.out.println("approvalAuth-->>"+profileSignatoriesMappingList.size());
		if(profileSignatoriesMappingList.size()>0){
			map.addAttribute("approvalAuth", "1");
		}else{
			map.addAttribute("approvalAuth", "0");
		}
		DocumentApprovarForm documentApprovarForm=new DocumentApprovarForm();
		map.addAttribute("readonly","true");
		map.addAttribute("readonlyTxt","readonlyTxt");
		map.addAttribute("disabled", "disabled");
		ContractTypeEntity contractTypeEntity=new ContractTypeEntity();
		contractTypeEntity=editContractTypeList.get(0);
		documentApprovarForm.setId(contractTypeEntity.getId());
		documentApprovarForm.setContractDocument(contractTypeEntity.getContractDocument());
		documentApprovarForm.setContractTypeName(contractTypeEntity.getContractTypeName());
		map.addAttribute("documentApprovarForm", documentApprovarForm);
		map.addAttribute("editContractTypeList",viewContractType.get("editContractTypeList") );
		map.addAttribute("contractTypeList",viewContractType.get("contractTypeList") );
		map.addAttribute("documentList",viewContractType.get("documentList") );
		map.addAttribute("profileSignatoriesEntityList",viewContractType.get("profileSignatoriesEntityList") );
		
		//map.addAttribute("contentJsp","editContractType");
		map.addAttribute("contentJsp","editFollowupDocumentList");
		return "index";

	}

	@RequestMapping(value = "/approveDocument/{id}")
	public String approveDocument(@PathVariable("id") Integer id,@ModelAttribute(value="documentApprovarForm") DocumentApprovarForm documentApprovarForm,HttpServletRequest request, BindingResult result) 
	{

		HttpSession  session=request.getSession();
		Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
			usersObj=(Users)session.getAttribute("usersObj");
		}
		loggerInfo.info("**[ approveDocument Update ContractType]**");
		loggerTech.info("**[ approveDocument Update ContractType]]**");

		ContractTypeEntity contractTypeEntity=new ContractTypeEntity();
		DocumentWorkflowEntity documentWorkflowEntity=new DocumentWorkflowEntity();
		contractTypeEntity.setId(documentApprovarForm.getId());
		contractTypeEntity.setContractStatus("Y");

		DataModifier modifier=Utility.getDataModifier(usersObj);
		documentWorkflowEntity.setFollowupDate(new Date());
		documentWorkflowEntity.setFollowup(documentApprovarForm.getFollowupComment());
		documentWorkflowEntity.setMailSent("N");
		documentWorkflowEntity.setStatus("Y");
		/*if(usersObj.getEmployeeEntity()!=null){
			documentWorkflowEntity.setEmployeeEntity(usersObj.getEmployeeEntity());
		}*/
		documentWorkflowEntity.setContractTypeEntity(contractTypeEntity);
		documentWorkflowEntity.setLastChgBy(modifier.getLastChgBy());
		documentWorkflowEntity.setLastChgTime(modifier.getLastChgTime());
		documentWorkflowEntity.setLastChgDate(new Date());
		System.out.println("approveDocumentList ** comment ["+documentApprovarForm.getFollowupComment()+"]");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("contractTypeEntity", contractTypeEntity);
		map.put("documentWorkflowEntity", documentWorkflowEntity);
		Map<String, Object> viewUser = (Map<String, Object>) documentApprovalService.approveDocument(map);
		//return "redirect:/viewContractType";
		return "redirect:/followupDocumentList";
	}


	@RequestMapping(value = "/rejectDocument/{id}")
	public String rejectDocument(@PathVariable("id") Integer id,@ModelAttribute(value="documentApprovarForm") DocumentApprovarForm documentApprovarForm,HttpServletRequest request, BindingResult result) 
	{

		HttpSession  session=request.getSession();
		Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
			usersObj=(Users)session.getAttribute("usersObj");
		}
		loggerInfo.info("**[ approveDocument Update ContractType]**");
		loggerTech.info("**[ approveDocument Update ContractType]]**");


		ContractTypeEntity contractTypeEntity=new ContractTypeEntity();
		contractTypeEntity.setId(documentApprovarForm.getId());
		contractTypeEntity.setContractStatus("N");

		DocumentWorkflowEntity documentWorkflowEntity=new DocumentWorkflowEntity();
		DataModifier modifier=Utility.getDataModifier(usersObj);
		documentWorkflowEntity.setFollowupDate(new Date());
		documentWorkflowEntity.setFollowup(documentApprovarForm.getFollowupComment());
		documentWorkflowEntity.setMailSent("N");
		documentWorkflowEntity.setStatus("N");
		/*if(usersObj.getEmployeeEntity()!=null){
			documentWorkflowEntity.setEmployeeEntity(usersObj.getEmployeeEntity());
		}*/
		documentWorkflowEntity.setContractTypeEntity(contractTypeEntity);
		documentWorkflowEntity.setLastChgBy(modifier.getLastChgBy());
		documentWorkflowEntity.setLastChgTime(modifier.getLastChgTime());
		documentWorkflowEntity.setLastChgDate(new Date());
		System.out.println("approveDocumentList ** comment ["+documentApprovarForm.getFollowupComment()+"]");
		Map<String, Object> map=new HashMap<String, Object>();

		map.put("contractTypeEntity", contractTypeEntity);

		map.put("documentWorkflowEntity", documentWorkflowEntity);
		
		System.out.println("approveDocumentList ** comment ["+documentApprovarForm.getFollowupComment()+"] approve/reject ["+documentApprovarForm.getEnabled()+"]");
		
		Map<String, Object> viewUser = (Map<String, Object>) documentApprovalService.approveDocument(map);
		return "redirect:/followupDocumentList";
	}

}
