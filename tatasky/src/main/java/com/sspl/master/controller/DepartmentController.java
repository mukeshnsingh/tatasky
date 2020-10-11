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
import com.sspl.entity.DocumentsEntity;
import com.sspl.entity.SignatoryEntity;
import com.sspl.entity.Users;
import com.sspl.master.service.DepartmentService;

@Controller
public class DepartmentController {

	private Logger loggerInfo = Logger.getLogger("bankreco_info");
	private Logger loggerTech = Logger.getLogger("bankreco_tech");

	@Autowired
	private DepartmentService departmentService;

	public void setDepartmentService(
			DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	@RequestMapping(value = "/viewDepartment", method = { RequestMethod.GET,RequestMethod.POST })
	public String viewDepartment(ModelMap map) 
	{
		loggerInfo.info("** &&[ viewDepartment ] &&**");
		map.addAttribute("department", new Department());
		Map<String, Object> viewDepartment = (Map<String, Object>) departmentService.viewDepartment();
		map.addAttribute("departmentList", viewDepartment.get("departmentList"));
		map.addAttribute("contentJsp","viewDepartment");
		return "index";
	}


	@RequestMapping(value = "/editDepartment/{id}" , method = RequestMethod.GET)
	public String editDepartment(ModelMap map,@PathVariable("id") Integer id) 
	{

		loggerInfo.info("**[ editDepartment Edit Department]**");
		loggerTech.info("**[ editDepartment Edit Department for edit Department"+id+"]**");

		Map<String, Object> viewDepartment = (Map<String, Object>) departmentService.editDepartment(id);
		List<Department> editDepartmentList=new ArrayList<Department>();


		if(viewDepartment.get("editDepartmentList")!=null){
			editDepartmentList=(List<Department>) viewDepartment.get("editDepartmentList");
		}
		map.addAttribute("readonly","true");
		map.addAttribute("readonlyTxt","readonlyTxt");
		map.addAttribute("disabled", "disabled");

		map.addAttribute("department", editDepartmentList.get(0));
		map.addAttribute("editDepartmentList",viewDepartment.get("editDepartmentList") );
		map.addAttribute("departmentList",viewDepartment.get("departmentList") );
		
		map.addAttribute("contentJsp","editDepartment");
		return "index";

	}

	@RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
	public String saveDepartment(@ModelAttribute(value="Department") Department department,HttpServletRequest request, BindingResult result) 
	{
		HttpSession  session=request.getSession();
		Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
			usersObj=(Users)session.getAttribute("usersObj");
			department.setLastChgBy(usersObj.getId());
			department.setLastChgTime("");
		}

		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("department", department);
		Map<String, Object> users = (Map<String, Object>) departmentService.saveDepartment(map);
		return "redirect:/viewDepartment";
	}

	@RequestMapping(value = "/editDepartmentActive/{id}" , method = RequestMethod.POST)
	public String editDepartmentActive(ModelMap map,@PathVariable("id") Integer id) 
	{
		loggerInfo.info("**[ editDepartmentActive Edit Department]**");
		loggerTech.info("**[ editDepartmentActive edit Department for edit Departmentid="+id+"]**");
		Map<String, Object> viewDepartment = (Map<String, Object>) departmentService.editDepartment(id);
		List<Department> editDepartmentList=new ArrayList<Department>();
		if(viewDepartment.get("editDepartmentList")!=null){
			editDepartmentList=(List<Department>) viewDepartment.get("editDepartmentList");
		}
		map.addAttribute("readonly","false");
		map.addAttribute("department", editDepartmentList.get(0));
		map.addAttribute("departmentList", viewDepartment.get("departmentList"));

		map.addAttribute("contentJsp","editDepartment");
		return "index";
	}


	@RequestMapping(value = "/modifyDepartment/{id}")
	public String modifyDepartment(@PathVariable("id") Integer id,@ModelAttribute(value="Department") Department department,HttpServletRequest request, BindingResult result) 
	{

		HttpSession  session=request.getSession();
		Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
			usersObj=(Users)session.getAttribute("usersObj");
			department.setLastChgBy(usersObj.getId());
			department.setLastChgTime("");
		}
		department.setLastChgDate(new Date());
		loggerInfo.info("**[ modifyDepartment Update Department]**");
		loggerTech.info("**[ modifyDepartment Update Department]]**");

		department.setId(id);

		Map<String, Object> map=new HashMap<String, Object>();

		map.put("department", department);

		Map<String, Object> viewUser = (Map<String, Object>) departmentService.modifyDepartment(map);
		return "redirect:/viewDepartment";
	}

}
