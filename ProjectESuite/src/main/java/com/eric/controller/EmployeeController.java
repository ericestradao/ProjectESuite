package com.eric.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eric.dao.DeptRepo;
import com.eric.dao.EmployeeRepo;
import com.eric.model.Department;
import com.eric.model.Employee;
import com.eric.service.EmployeeService;

@RequestMapping(value = "/Employee**", method = RequestMethod.GET)
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/employees")
	public List<Employee> retrieveAllEmployees() {
		return empService.retrieveAllEmployees();
	}
	
	@GetMapping("/departments")
	public List<Department> retrieveAllDepartments() {
		return empService.retrieveAllDepartments();
	}

}
