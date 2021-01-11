package org.study.pma.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.study.pma.DAO.EmployeeRepository;
import org.study.pma.DAO.ProjectRepository;
import org.study.pma.Entities.Employee;
import org.study.pma.Entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	// used to display table when request "/projects"
	//its by default a get method
	@RequestMapping()
	public String showProjects(Model model) {
		
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		
		return"/project/list-projects";
	}
	
	//@RequestMapping(value = "/new", method = RequestMethod.GET)

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		
		 List<Employee> employees= empRepo.findAll(); 
		
		
		model.addAttribute("project",aProject);
		
		model.addAttribute("employeesList",employees);
		
		return "/project/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project , Model model) {
		
		proRepo.save(project);
		
		
		// info <!-- *{name}=${project.name} -->

		//used when @many to one
		//  need to write @RequestParam List<Long> employees
		// we give the name employees b/c its the same name coming from the form

	/*	Iterable<Employee> chosenEmployees = empRepo.findAllById(employees);

		//Iterate by foreach and save
		
		for(Employee item : chosenEmployees) {
			item.setProject(project);
			empRepo.save(item);
		} */
		
		
		//use redirect to prevent duplicate submissions
		return "redirect:/projects/new";
	}
	

}
