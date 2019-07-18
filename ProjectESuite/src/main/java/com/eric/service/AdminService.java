package com.eric.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import com.eric.controller.AdminNotFoundException;
import com.eric.dao.DeptRepo;
import com.eric.dao.EmployeeRepo;
import com.eric.model.Department;
import com.eric.model.Employee;

@Service
public class AdminService {

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private DeptRepo deptRepo;

	public List<Employee> retrieveAllEmployees() {
		return (List<Employee>) empRepo.findAll();
	}

	public Employee retrieveEmployee(long id) {
		Optional<Employee> employee = empRepo.findById(id);

		if (!employee.isPresent())
			throw new AdminNotFoundException("id-" + id);

		return employee.get();
	}

	public void deleteEmployee(long id) {
		empRepo.deleteById(id);

	}

	public Employee create(Employee emp, String deptname) {
		Department department = deptRepo.findBydeptName(deptname);
		emp.setDept_id(department);
		return empRepo.save(emp);
	}

	public Employee update(Employee emp, Long id) {
		Employee employee = empRepo.findByEmpid(id);
		emp.setEmpid(employee.getEmpid());
		emp.setDept_id(employee.getDept_id());

		return empRepo.save(emp);
	}

	public List<Department> retrieveAllDepartments() {
		return (List<Department>) deptRepo.findAll();
	}

	public Department retrieveDepartment(String deptname) {
		Department department = deptRepo.findBydeptName(deptname);

		return department;
	}

	public Department create(String deptname) {
		Department department = new Department();
		department.setDeptname(deptname);
		return deptRepo.save(department);
	}

	public Department update(Department dept, String deptname) {
		Department department = deptRepo.findBydeptName(deptname);
		dept.setDept_id(department.getDept_id());
		dept.setDeptname(department.getDeptname());

		return deptRepo.save(dept);
	}

}
