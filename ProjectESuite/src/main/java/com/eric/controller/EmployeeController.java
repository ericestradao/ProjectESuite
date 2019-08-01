package com.eric.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.eric.model.LeaveRequest;
import com.eric.model.Meetings;
import com.eric.model.Tasks;
import com.eric.model.Training;
import com.eric.service.EmployeeService;

@CrossOrigin(origins="http://localhost:4200")

@RequestMapping({"/Employee**"})
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	//EMPLOYEE 
	
	@RequestMapping(path = "/employee/{empid}")
	public Optional<Employee> retrieveEmployee(@PathVariable("empid") Long empid) {
		return empService.retrieveEmployee(empid);
	}
	
	//LEAVES
	
	@RequestMapping(path = "/leaveRequest/{empid}")
	public List<LeaveRequest> retrieveRequest(@PathVariable("empid") Employee empid) {
		return empService.retrieveRequest(empid);
	}
	
	//TRAINING

	@RequestMapping(path = "/training/{empid}")
	public List<Training> retrieveTraining(@PathVariable("empid") Employee empid) {
		return empService.retrieveTraining(empid);
	}
	
	//MEETING
	
	@RequestMapping(path = "/meeting/{empid}")
	public List<Meetings> retrieveMeeting(@PathVariable("empid") Employee empid) {
		return empService.retrieveMeeting(empid);
	}
	
	//TASK

	@RequestMapping(path = "/task/{empid}")
	public List<Tasks> retrieveTask(@PathVariable("empid") Employee empid) {
		return empService.retrieveTask(empid);
	}
	

}
