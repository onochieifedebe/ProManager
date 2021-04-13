package com.onochieifedebe.pmtool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.onochieifedebe.pmtool.entities.Employee;
import com.onochieifedebe.pmtool.entities.Project;
import com.onochieifedebe.pmtool.services.EmployeeService;
import com.onochieifedebe.pmtool.services.ProjectService;


@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proService.getAll();
		model.addAttribute("projects",projects);
		return "projects/listOfProjects";
		
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project project = new Project();
		List<Employee> employees = empService.getAll();
		
		model.addAttribute("allemployees",employees);
		model.addAttribute("project",project);		
		return "projects/newproject";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		proService.save(project);
		return "redirect:/projects";
	}

}
