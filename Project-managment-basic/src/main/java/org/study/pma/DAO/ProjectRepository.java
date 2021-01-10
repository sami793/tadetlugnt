package org.study.pma.DAO;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.study.pma.Entities.Project;


@Repository
public interface ProjectRepository  extends PagingAndSortingRepository<Project, Long>  {
	
	 public List<Project>  findAll(); 
	 //here we override to get a list instead of iterator


}
