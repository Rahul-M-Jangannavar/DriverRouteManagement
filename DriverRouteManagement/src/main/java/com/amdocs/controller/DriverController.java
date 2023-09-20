package com.amdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.entity.DriverEntity;
import com.amdocs.service.impl.DriverServiceImpl;

@Controller
public class DriverController {

	@Autowired
	private DriverServiceImpl empService;
	
	@RequestMapping("/")
	public String loadForm(Model model)
	{
		DriverEntity emp=new DriverEntity();
		model.addAttribute("emp", emp);
		
		return "employee";
	}
	
	@RequestMapping("/insert")
	public String handleEmpForm(@ModelAttribute("emp")DriverEntity emp,Model model)
	{
		
		//intract to service layer
		boolean saveEmployee = empService.saveEmployee(emp);
		
		String msg="";
		
		if(saveEmployee)
			msg="Data Inserted SuccessFully";
		else
			msg="Data Not Inserted SuccessFully";
		
		model.addAttribute("msg", msg);
		return "employee";
	}
	
	
	@RequestMapping("/viewAll")
	public String viewAllEmployees(Model model)
	{
		//fetch the data from the databse ,can interact service layer
		List<DriverEntity> allEmployees = empService.getAllEmployees();
		
		model.addAttribute("employees", allEmployees);
		return "view";
	}
	
	@RequestMapping("/deleteEmp")
	public String deleteEmployee(@RequestParam("eid")     int id)
	{
		boolean flag = empService.deleteEmployee(id);
		
		if(flag)
		return "redirect:/viewAll";
		else
		return "redirect:/viewAll";
	}
	
	
	@RequestMapping("/editEmp")
	public String editEmployee(@RequestParam("eid")   int id,Model model)
	{
		DriverEntity emp = empService.getEmployeeId(id);
		
		model.addAttribute("emp", emp);
		return "editDriver";
	}
	
	@RequestMapping("/update")
	public String updateEmployee(DriverEntity emp)
	{
		boolean updateBook = empService.updateBook(emp);
		
		return "redirect:/viewAll";

	}
	
	
	
	
	
}
