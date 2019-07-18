package com.eric.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eric.dao.DeptRepo;
import com.eric.dao.EmployeeRepo;
import com.eric.model.Department;
import com.eric.model.Employee;
import com.eric.service.AdminService;

@RequestMapping(value = "/Admin**", method = RequestMethod.GET)
@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;

//	@GetMapping("/")
//	public String Hello(){
//		return "Hello world";
//	}
//	
	@GetMapping("/employees")
	public List<Employee> retrieveAllEmployees() {
		return adminService.retrieveAllEmployees();
	}

//	@GetMapping("/employees")
//	public List<Employee> retrieveAllEmployees() {
//		return (List<Employee>) empRepo.findAll();
//	}

	@RequestMapping(path = "/employee/{id}")
	public Employee retrieveEmployee(@PathVariable("id") long id) {
		return adminService.retrieveEmployee(id);
	}

	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable long id) {
		return;
	}

	@PostMapping("/newEmployee/{deptname}")
	public Employee create(@RequestBody Employee emp, @PathVariable String deptname) {
		return adminService.create(emp, deptname);

	}

	@PutMapping("/employee/{id}")
	public Employee update(@RequestBody Employee emp, @PathVariable Long id) {
		return adminService.update(emp, id);
	}

	@GetMapping("/departments")
	public List<Department> retrieveAllDepartments() {
		return adminService.retrieveAllDepartments();
	}

	@RequestMapping(path = "/department/{deptname}")
	public Department retrieveDepartment(@PathVariable("deptname") String deptname) {
		return adminService.retrieveDepartment(deptname);
	}

	@PostMapping("/newDepartment")
	public Department create(@RequestBody String deptname) {
		return adminService.create(deptname);

	}

	@PutMapping("/department/{deptname}")
	public Department update(@RequestBody Department dept, @PathVariable String deptname) {
		return adminService.update(dept, deptname);
	}

}
