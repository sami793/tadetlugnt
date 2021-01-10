package org.study.pma.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.study.pma.DAO.EmployeeRepository;
import org.study.pma.DAO.ProjectRepository;
import org.study.pma.Entities.Employee;
import org.study.pma.Entities.Project;





@Controller
public class HomeController {

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		
		
		// we are querying the database for projects
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		//model.addAttribute("projectsList", proRepo.findAll());

		
		
		// we are querying the database for employees
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employeesList", employees);
		
//		model.addAttribute("employeesList", empRepo.findAll());

		
		return "main/home";
		
	}

	
}
