package com.onochieifedebe.pmtool.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onochieifedebe.pmtool.dao.EmployeeRepository;
import com.onochieifedebe.pmtool.dao.ProjectRepository;
import com.onochieifedebe.pmtool.dto.ChartData;
import com.onochieifedebe.pmtool.dto.EmployeeProject;
//import com.onochieifedebe.pmtool.entities.Employee;
import com.onochieifedebe.pmtool.entities.Project;

@Controller
@RequestMapping
public class HomeController {
	
	@Value("${version}")
	private String version;
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String home(Model model) throws JsonProcessingException {
		
		model.addAttribute("version",version);
		
		List<Project> projects = proRepo.findAll();
		List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
		
		List<ChartData> projectStatusList = proRepo.projectStatus();
		ObjectMapper objectMapper = new ObjectMapper();              //Converting projectStatusList to JSON structure
		String statusJsonString = objectMapper.writeValueAsString(projectStatusList);
		
		model.addAttribute("statusCount",statusJsonString);
		model.addAttribute("projects", projects);
		model.addAttribute("employeeProjectCountList",employeesProjectCount);
		return "main/home";
	}

}
