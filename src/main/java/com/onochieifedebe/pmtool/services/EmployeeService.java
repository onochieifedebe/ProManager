package com.onochieifedebe.pmtool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onochieifedebe.pmtool.dao.EmployeeRepository;
import com.onochieifedebe.pmtool.dto.EmployeeProject;
import com.onochieifedebe.pmtool.entities.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}
	
	public List<Employee> getAll(){
		return empRepo.findAll();
	}
	
	public List<EmployeeProject> employeeProjects(){
		return empRepo.employeeProjects();
	}

}
