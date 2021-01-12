package org.study.pma.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.study.pma.DAO.EmployeeRepository;
import org.study.pma.Entities.Employee;
import org.study.pma.Services.EmployeeService;


@Controller
@RequestMapping("/employees")

public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	// used to display table when request "/projects"
		//its by default a get method
		@RequestMapping()
		public String showEmployees(Model model) {
			
			 List<Employee> employees= empService.findAll() ;
			model.addAttribute("employeesList",employees);
			return"/employee/list-employees";
		}
		
	//@RequestMapping(value = "/new", method = RequestMethod.GET)

		@GetMapping("/new")
		public String displayEmployeesForm(Model model) {
			Employee aEmployee = new Employee();
			
			model.addAttribute("employee",aEmployee);
			return "/employee/new-employee";
		}
		
		@PostMapping("/save")
		public String createEmployee(Employee employee  , Model model) {
			empService.save(employee);
			//use redirect to prevent duplicate submissions
			return "redirect:/employees/new";
		}
	
	
}
