package com.sspl.master.controller;

import java.util.ArrayList;
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
import com.sspl.entity.Users;
import com.sspl.master.service.EmployeeService;

/**
 * 
 * @author Mukesh Narayan Singh
 *
 */
@Controller
public class EmployeeController {

	private Logger loggerInfo = Logger.getLogger("bankreco_info");
	private Logger loggerTech = Logger.getLogger("bankreco_tech");
	
	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	

	@RequestMapping(value = "/viewEmployee", method = { RequestMethod.GET,RequestMethod.POST })
	public String viewEmployee(ModelMap map) 
	{
		loggerInfo.info("** &&[ viewEmployee Employees] &&**");
		map.addAttribute("employeeEntity", new EmployeeEntity());
		Map<String, Object> viewEmployee = (Map<String, Object>) employeeService.viewEmployee();
		
		map.addAttribute("employeList", viewEmployee.get("employeList"));
		map.addAttribute("departmentList",viewEmployee.get("departmentList"));
		map.addAttribute("contentJsp","employee");
		return "index";
	}
	
	@RequestMapping(value = "/editEmployee/{id}" , method = RequestMethod.GET)
	public String editEmployee(ModelMap map,@PathVariable("id") Integer id) 
	{
		
		loggerInfo.info("**[ editEmployee Edit Employee]**");
		loggerTech.info("**[ editEmployee Edit Employee for edit Employee"+id+"]**");
	
		Map<String, Object> viewEmployee = (Map<String, Object>) employeeService.editEmployee(id);
		List<EmployeeEntity> editEmployeeList=new ArrayList<EmployeeEntity>();
		
		if(viewEmployee.get("editEmployeeList")!=null){
			editEmployeeList=(List<EmployeeEntity>) viewEmployee.get("editEmployeeList");
		}
		map.addAttribute("readonly","true");
		map.addAttribute("readonlyTxt","readonlyTxt");
		map.addAttribute("disabled", "disabled");
		
		map.addAttribute("employeeEntity", editEmployeeList.get(0));
		map.addAttribute("editEmployeeList",viewEmployee.get("editEmployeeList"));
		map.addAttribute("employeList",viewEmployee.get("employeList") );
		map.addAttribute("departmentList", viewEmployee.get("departmentList"));
		map.addAttribute("roles",viewEmployee.get("roles"));
		map.addAttribute("contentJsp","editEmployee");
		return "index";
	
	}
	
	
	
	
	@RequestMapping(value = "/addEmp1", method = RequestMethod.POST)
	public String saveEmp1(@ModelAttribute(value="employeeEntity") EmployeeEntity employeeEntity,HttpServletRequest request, BindingResult result) 
	{
		HttpSession  session=request.getSession();
		 Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
		usersObj=(Users)session.getAttribute("usersObj");
		employeeEntity.setLastChgBy(usersObj.getId());
		}
		//This field contain dept id
		System.out.println(""+request.getParameter("lastChgBy"));
		if(request.getParameter("lastChgBy")!=null){
			int deptObj=Integer.parseInt(request.getParameter("lastChgBy"));
			Department department=new Department();
			department.setId(deptObj);
			employeeEntity.setDeptObj(department);
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("employeeEntity", employeeEntity);
		Map<String, Object> users = (Map<String, Object>) employeeService.saveEmployee(map);
		return "redirect:/viewEmployee";
	}
	
	
	@RequestMapping(value = "/editEmployeeActive/{id}" , method = RequestMethod.POST)
	public String editEmployeeActive(ModelMap map,@PathVariable("id") Integer id) 
	{
		loggerInfo.info("**[ editEmployeeActive Edit Employee]**");
		loggerTech.info("**[ editEmployeeActive edit Employee for edit Employeeid="+id+"]**");
		Map<String, Object> viewEmployee = (Map<String, Object>) employeeService.editEmployee(id);
	List<EmployeeEntity> editEmployeeList=new ArrayList<EmployeeEntity>();
	if(viewEmployee.get("editEmployeeList")!=null){
		editEmployeeList=(List<EmployeeEntity>) viewEmployee.get("editEmployeeList");
	}
	map.addAttribute("readonly","false");
	
	map.addAttribute("employeeEntity", editEmployeeList.get(0));
	map.addAttribute("editEmployeeList",viewEmployee.get("editEmployeeList"));
	map.addAttribute("employeList",viewEmployee.get("employeList") );
	map.addAttribute("departmentList", viewEmployee.get("departmentList"));
	map.addAttribute("roles",viewEmployee.get("roles"));
	
	map.addAttribute("contentJsp","editEmployee");
	return "index";
	}
	
/*	@RequestMapping(value = "/modifyUser/{id}")
	public String modifyUser(@PathVariable("id") Integer id,@ModelAttribute(value="usersEntity") UsersEntity usersEntity,HttpServletRequest request, BindingResult result) 
	{
*/
	@RequestMapping(value = "/modifyEmp/{id}")
	public String modifyEmp(@PathVariable("id") Integer id,@ModelAttribute(value="employeeEntity") EmployeeEntity employeeEntity,HttpServletRequest request, BindingResult result) 
	{
		HttpSession  session=request.getSession();
		 Users usersObj=new Users();
		if(session.getAttribute("usersObj")!=null)
		{
		usersObj=(Users)session.getAttribute("usersObj");
		employeeEntity.setLastChgBy(usersObj.getId());
		}
		loggerInfo.info("**[ modifyEmployee Update Employee]**");
		loggerTech.info("**[ modifyEmployee Update Employee]]**");
		
		employeeEntity.setId(id);
		System.out.println(""+request.getParameter("lastChgBy"));
		if(request.getParameter("lastChgBy")!=null){
			int deptObj=Integer.parseInt(request.getParameter("lastChgBy"));
			Department department=new Department();
			department.setId(deptObj);
			employeeEntity.setDeptObj(department);
		}
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("employeeEntity", employeeEntity);
		Map<String, Object> viewEmployee = (Map<String, Object>) employeeService.modifyEmployee(map);
		return "redirect:/viewEmployee";
	}


}
