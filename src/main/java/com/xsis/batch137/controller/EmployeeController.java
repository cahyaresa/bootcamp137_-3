package com.xsis.batch137.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xsis.batch137.model.Employee;
import com.xsis.batch137.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	public String index(Model model) {
		List<Employee> emps = empService.selectAll();
		model.addAttribute("emps", emps);
		return "employee";
	}
	
	@ModelAttribute("employee")
	public Employee getEmployeeForm() {
		return new Employee();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String save(@Valid @ModelAttribute("employee") Employee emp, BindingResult binding, Model model) {
		if(binding.hasErrors()) {
			List<Employee> emps = empService.selectAll();
			model.addAttribute("emps", emps);
			return "employee";
		}
		empService.save(emp);
		return "redirrect:/employee";
	}
	
	
}