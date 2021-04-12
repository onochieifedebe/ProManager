package com.onochieifedebe.pmtool.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.onochieifedebe.pmtool.dto.ChartData;
import com.onochieifedebe.pmtool.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value ="SELECT STAGE as label ,COUNT(STAGE) as value "
			+ "FROM PROJECT "
			+ "GROUP BY STAGE")
	public List<ChartData> projectStatus();

}
