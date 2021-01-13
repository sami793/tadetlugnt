package org.study.pma.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.study.pma.DTO.ChartData;
import org.study.pma.Entities.Project;


//@Repository

@RepositoryRestResource(collectionResourceRel="apiprojects", path="apiprojects")

public interface ProjectRepository  extends PagingAndSortingRepository<Project, Long>  {
	
	 public List<Project>  findAll(); 
	 //here we override to get a list instead of iterator

	 @Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as value " + 
				"FROM project " + 
				"GROUP BY stage")
		public List<ChartData> getProjectStatus(); 

}
