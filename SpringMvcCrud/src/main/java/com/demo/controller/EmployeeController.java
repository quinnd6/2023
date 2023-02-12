package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Employee;
import com.demo.service.EmployeeServices;

@Controller
@RequestMapping
public class EmployeeController {
	@Autowired
	EmployeeServices employeeServices;
	
	//load addEmployee form
	@GetMapping("addEmployee")
	public String addEmp() 
	{
		return "AddEmployee";
	}
	
	//save employee form
	@PostMapping("/insertEmployee")
	public String insertEmployee(@ModelAttribute("insertEmployee")Employee emp)
	{
		employeeServices.addEmp(emp);
		return "redirect:/employeeReport";
	}
	
	//load employee data
	@GetMapping("employeeReport")
	public String loadEmployee(Model m)
	{
		m.addAttribute("employee", employeeServices.getAllEmp());
		m.addAttribute("title", "Employee Report");
		
		return "EmployeeReport";
	}
	
	//load edit form
	@GetMapping("/editEmployee/{id}")
	public String loadEditForm(@PathVariable(value="id")Long id, Model m)
	{
		Employee emp = employeeServices.getById(id);
		m.addAttribute("employee", emp);
		m.addAttribute("title", "Edit Employee");
		
		//return jsp name
		return "EditEmployee";
	}
	
	@PostMapping("/editEmployee/updateEmployee")
	public String updateEmp(@ModelAttribute("updateEmployee")Employee emp) 
	{
		employeeServices.updateEmp(emp);
		return "redirect:/employeeReport";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable long id)
	{
		employeeServices.deleteEmp(id);
		return "redirect:/employeeReport";
	}
}
