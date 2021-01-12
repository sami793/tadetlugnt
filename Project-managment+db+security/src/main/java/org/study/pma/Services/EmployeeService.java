package org.study.pma.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.pma.DAO.EmployeeRepository;
import org.study.pma.DTO.EmployeeProject;
import org.study.pma.Entities.Employee;


@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;
	
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}


	public List<Employee> findAll() {
		return empRepo.findAll();
	}


	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}


	/*public Employee findByEmployeeId(long theId) {
		// TODO Auto-generated method stub
		return empRepo.findByEmployeeId(theId);
	}
*/
/*
	public void delete(Employee theEmp) {
		empRepo.delete(theEmp);
		
	}
*/
	
}
