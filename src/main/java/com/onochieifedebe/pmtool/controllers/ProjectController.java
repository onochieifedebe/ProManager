package com.onochieifedebe.pmtool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.onochieifedebe.pmtool.dao.EmployeeRepository;
import com.onochieifedebe.pmtool.dao.ProjectRepository;
import com.onochieifedebe.pmtool.entities.Employee;
import com.onochieifedebe.pmtool.entities.Project;


@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects",projects);
		return "projects/listOfProjects";
		
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project project = new Project();
		List<Employee> employees = empRepo.findAll();
		
		model.addAttribute("allemployees",employees);
		model.addAttribute("project",project);		
		return "projects/newproject";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		proRepo.save(project);
		return "redirect:/projects";
	}

}
