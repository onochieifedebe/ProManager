package com.onochieifedebe.pmtool.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
	@SequenceGenerator(name = "project_seq", sequenceName = "project_seq",allocationSize = 1,initialValue=1)
	private long projectId;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},     //The Cascade type tells you what happens to the child class when the parent is deleted or altered.
			fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee",joinColumns = @JoinColumn(name="project_id"),inverseJoinColumns = @JoinColumn(name="employee_id"))
	private List<Employee> employees;
	
	private String name;
	private String description;
	private String stage;
	
//<----------------------------------------->	
	
	public Project() {
		
	}
	
	public Project(String name, String description, String stage) {
		super();
		this.name = name;
		this.description = description;
		this.stage = stage;
	}
	
//<-------------------------------------------->	
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;		
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}

	public void addEmployee(Employee emp) {
		if(employees == null) {
			employees = new ArrayList<>();
		}
		employees.add(emp);
		
	}
	
	
	

}
