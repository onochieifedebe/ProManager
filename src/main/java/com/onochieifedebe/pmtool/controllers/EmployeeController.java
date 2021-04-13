package com.onochieifedebe.pmtool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.onochieifedebe.pmtool.entities.Employee;
import com.onochieifedebe.pmtool.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = empService.getAll();
		model.addAttribute("employees",employees);
		return "employees/listOfEmployees";
	}
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "employees/newemployee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		empService.save(employee);
		return "redirect:/employees/new";
	}
	

}
