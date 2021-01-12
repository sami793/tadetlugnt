package org.study.pma.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.study.pma.DTO.EmployeeProject;
import org.study.pma.Entities.Employee;
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{
	
	
	public List<Employee>  findAll(); 
	 //here we override to get a list instead of iterator
	
	
	@Query(nativeQuery=true, value="SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount " + 
			"FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id " + 
			"GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
	public List<EmployeeProject> employeeProjects();

	
	
	
}
