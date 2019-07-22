package com.eric.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.eric.controller.AdminNotFoundException;
import com.eric.dao.DeptRepo;
import com.eric.dao.EmployeeRepo;
import com.eric.dao.LeaveRepo;
import com.eric.dao.MeetingRoomRepo;
import com.eric.dao.MeetingsRepo;
import com.eric.dao.TaskRepo;
import com.eric.dao.TrainingRepo;
import com.eric.dao.TrainingRoomRepo;
import com.eric.model.Department;
import com.eric.model.Employee;
import com.eric.model.MeetingRoom;
import com.eric.model.Meetings;
import com.eric.model.Tasks;

@Service
public class AdminService {

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private DeptRepo deptRepo;
	
	@Autowired
	private LeaveRepo leaveRepo;

	@Autowired
	private MeetingRoomRepo meetingRoomRepo;

	@Autowired
	private MeetingsRepo meetingsRepo;

	@Autowired
	private TaskRepo taskRepo;

	@Autowired
	private TrainingRepo trainingRepo;

	@Autowired
	private TrainingRoomRepo trainingRoomRepo;

	//EMPLOYEE

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

	//DEPARTMENS 
	
	public List<Department> retrieveAllDepartments() {
		return (List<Department>) deptRepo.findAll();
	}

	public Department retrieveDepartment(String deptname) {
		Department department = deptRepo.findBydeptName(deptname);

		return department;
	}

	public Department createDepartment(String deptname) {
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
	
	//MEETING ROOMS
	
	public List<MeetingRoom> retrieveAllMeetingRooms() {
		return (List<MeetingRoom>) meetingRoomRepo.findAll();
	}
	
	public MeetingRoom createMeetingRoom(MeetingRoom mRoom) {
		return meetingRoomRepo.save(mRoom);
	}
	
	public Optional<MeetingRoom> retrieveMeetingRoom(long roomId) {
		Optional<MeetingRoom> meetingRoom = meetingRoomRepo.findById(roomId);

		return meetingRoom;
	}
	
	public MeetingRoom updateMeetingRoom(MeetingRoom mRoom, long roomId) {
		Optional<MeetingRoom> meetingRoom = meetingRoomRepo.findById(roomId);
		return meetingRoomRepo.save(mRoom);
	}
	
	//TASKS
	
	public List<Tasks> retrieveAllTasks() {
		return (List<Tasks>) taskRepo.findAll();
	}
	
	public Tasks createTask(Tasks tasks) {
		return taskRepo.save(tasks);
	}
	
	public Optional<Tasks> retrieveTask(long taskId) {
		Optional<Tasks> tasks = taskRepo.findById(taskId);

		return tasks;
	}
	
	public Tasks updateTask(Tasks tasks, long taskId) {
		Optional<Tasks> task = taskRepo.findById(taskId);
		return taskRepo.save(tasks);
	}	

}
