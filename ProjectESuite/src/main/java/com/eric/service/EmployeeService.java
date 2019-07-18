package com.eric.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eric.dao.DeptRepo;
import com.eric.dao.EmployeeRepo;
import com.eric.model.Department;
import com.eric.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private DeptRepo deptRepo;
	
	public List<Employee> retrieveAllEmployees() {
		return (List<Employee>) empRepo.findAll();
	}
	
	public List<Department> retrieveAllDepartments() {
		return (List<Department>) deptRepo.findAll();
	}


}
