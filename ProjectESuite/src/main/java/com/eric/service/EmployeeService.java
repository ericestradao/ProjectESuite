package com.eric.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.eric.dao.DeptRepo;
import com.eric.dao.EmployeeRepo;
import com.eric.dao.LeaveRepo;
import com.eric.dao.MeetingsRepo;
import com.eric.dao.TaskRepo;
import com.eric.dao.TrainingRepo;
import com.eric.model.Department;
import com.eric.model.Employee;
import com.eric.model.LeaveRequest;
import com.eric.model.Meetings;
import com.eric.model.Tasks;
import com.eric.model.Training;

@CrossOrigin(origins = "http://localhost:4200")
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private DeptRepo deptRepo;
	
	@Autowired
	private LeaveRepo leaveRepo;
	
	@Autowired
	private TrainingRepo trainingRepo;
	
	@Autowired
	private MeetingsRepo meetingsRepo;
	
	@Autowired
	private TaskRepo taskRepo;
	
	public Optional<Employee> retrieveEmployee(Long empid) {
		Optional<Employee> employee = empRepo.findById(empid);
		return employee;
	}
	
	//LEAVES
	
	public List<LeaveRequest> retrieveRequest(Employee empid) {
		return (List<LeaveRequest>)leaveRepo.findByEmpid(empid);
	}
	
	//TRAINING
	
	public List<Training> retrieveTraining(Employee empid) {
		return (List<Training>)trainingRepo.findByEmpid(empid);
	}
	
	//MEETING
	
	public List<Meetings> retrieveMeeting(Employee empid) {
		return (List<Meetings>)meetingsRepo.findByEmpid(empid);
	}
	
	//TRAINING
	
	public List<Tasks> retrieveTask(Employee assignedTo) {
		return (List<Tasks>)taskRepo.findByAssignedTo(assignedTo);
	}

}
