package org.study.pma.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.pma.DAO.ProjectRepository;
import org.study.pma.DTO.ChartData;
import org.study.pma.Entities.Project;


@Service
public class ProjectService {
	@Autowired
	ProjectRepository proRepo;
	
	
	public Project save(Project project) {
		return proRepo.save(project);
	}


	public List<Project> findAll() {
		return proRepo.findAll();
	}
	
	public List<ChartData> getProjectStatus(){
		return proRepo.getProjectStatus();
	}
	
	/*
	public List<TimeChartData> getTimeData(){
		return proRepo.getTimeData();
	}*/
}
