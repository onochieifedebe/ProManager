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
import com.onochieifedebe.pmtool.dto.ChartData;
import com.onochieifedebe.pmtool.dto.EmployeeProject;
//import com.onochieifedebe.pmtool.entities.Employee;
import com.onochieifedebe.pmtool.entities.Project;
import com.onochieifedebe.pmtool.services.EmployeeService;
import com.onochieifedebe.pmtool.services.ProjectService;

@Controller
@RequestMapping
public class HomeController {
	
//	@Value("${version}")
//	private String version;
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/")
	public String home(Model model) throws JsonProcessingException {
		
//		model.addAttribute("version",version);
		
		List<Project> projects = proService.getAll();
		List<EmployeeProject> employeesProjectCount = empService.employeeProjects();
		
		List<ChartData> projectStatusList = proService.getprojectStatus();
		ObjectMapper objectMapper = new ObjectMapper();              //Converting projectStatusList to JSON structure
		String statusJsonString = objectMapper.writeValueAsString(projectStatusList);
		
		model.addAttribute("statusCount",statusJsonString);
		model.addAttribute("projects", projects);
		model.addAttribute("employeeProjectCountList",employeesProjectCount);
		return "main/home";
	}

}
