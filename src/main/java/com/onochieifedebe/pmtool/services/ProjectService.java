package com.onochieifedebe.pmtool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onochieifedebe.pmtool.dao.ProjectRepository;
import com.onochieifedebe.pmtool.dto.ChartData;
import com.onochieifedebe.pmtool.entities.Project;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository proRepo;
	
	public Project save(Project project) {
		return proRepo.save(project);
	}
	
	public List<Project> getAll(){
		return proRepo.findAll();
	}
	
	public List<ChartData> getprojectStatus(){
		return proRepo.projectStatus();
	}


}
