package org.study.pma.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.study.pma.DAO.EmployeeRepository;
import org.study.pma.DAO.ProjectRepository;
import org.study.pma.DTO.ChartData;
import org.study.pma.DTO.EmployeeProject;
import org.study.pma.Entities.Employee;
import org.study.pma.Entities.Project;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;





@Controller
public class HomeController {
	
	@Value("${version}")
	private String ver;

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		model.addAttribute("versionNumber", ver);

		
		
       Map<String , Object> map = new HashMap<>();
		
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		List<ChartData> projectData = proRepo.getProjectStatus();


		// Lets convert projectData object into a json structure for use in javascript
				ObjectMapper objectMapper = new ObjectMapper();
				String jsonString = objectMapper.writeValueAsString(projectData);
				
				// [["NOTSTARTED", 1], ["INPROGRESS", 2], ["COMPLETED", 1]]
				
				model.addAttribute("projectStatusCnt", jsonString);

				// we are querying the database for employees
		List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
		model.addAttribute("employeesListProjectsCnt", employeesProjectCount);


				
		
		return "main/home";
		
	}

	
}
