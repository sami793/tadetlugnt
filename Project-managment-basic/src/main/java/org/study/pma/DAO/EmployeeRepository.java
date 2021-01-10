package org.study.pma.DAO;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.study.pma.Entities.Employee;
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{
	
	
	public List<Employee>  findAll(); 
	 //here we override to get a list instead of iterator
}
