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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eric.dao.DeptRepo;
import com.eric.dao.EmployeeRepo;
import com.eric.model.Department;
import com.eric.model.Employee;

@RestController
public class AdminController {
	@Autowired
	private EmployeeRepo empRepo;
	@Autowired
	private DeptRepo deptRepo;
//	@GetMapping("/")
//	public String Hello(){
//		return "Hello world";
//	}
//	
	
	@GetMapping("/employees")
	public List<Employee> retrieveAllEmployees() {
		return (List<Employee>) empRepo.findAll();
	}
	
    @RequestMapping(path="/employee/{id}")
	public Employee retrieveEmployee(@PathVariable("id") long id) {
		Optional<Employee> employee = empRepo.findById(id);
		
		if(!employee.isPresent())
			throw new AdminNotFoundException("id-" + id);
		
		return employee.get();
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable long id) {
		empRepo.deleteById(id);
	}

	@PostMapping("/newEmployee/{deptname}")
    public Employee create(@RequestBody Employee emp, @PathVariable String deptname){
		Department department = deptRepo.findBydeptName(deptname);
		emp.setDept_id(department);
		return empRepo.save(emp);
		
	}

	@PutMapping("/employee/{id}")
    public Employee update(@RequestBody Employee emp, @PathVariable Long id){
        Employee employee = empRepo.findByEmpid(id);
        emp.setEmpid(employee.getEmpid());
        emp.setDept_id(employee.getDept_id());

        return empRepo.save(emp);
    }
	
	@GetMapping("/departments")
	public List<Department> retrieveAllDepartments() {
		return (List<Department>) deptRepo.findAll();
	}
	
	@RequestMapping(path="/department/{deptname}")
	public Department retrieveDepartment(@PathVariable("deptname") String deptname) {
		Department department = deptRepo.findBydeptName(deptname);
		
		return department;
	}
	
	@PostMapping("/newDepartment")
    public Department create(@RequestBody String deptname){
		Department department = new Department();
		department.setDeptname(deptname);
		return deptRepo.save(department);
		
	}
	
	@PutMapping("/department/{deptname}")
    public Department update(@RequestBody Department dept, @PathVariable String deptname){
        Department department = deptRepo.findBydeptName(deptname);
        dept.setDept_id(department.getDept_id());
        dept.setDeptname(department.getDeptname());

        return deptRepo.save(dept);
    }
	
}
