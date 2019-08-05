package com.eric.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.eric.model.LeaveRequest;
import com.eric.model.MeetingRoom;
import com.eric.model.Meetings;
import com.eric.model.Tasks;
import com.eric.model.Training;
import com.eric.model.TrainingRoom;

@CrossOrigin(origins = "http://localhost:4200")
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

	public Employee retrieveEmployee(String emailid) {
		Employee employee = empRepo.findByEmailid(emailid);

//		if (!employee.isPresent())
//			throw new AdminNotFoundException("id-" + id);

	//	return employee.getEmpid();
		return employee;
	}

	public void deleteEmployee(long id) {
		empRepo.deleteById(id);
	}

	public Employee create(Employee emp, String deptname) {
		Department department = deptRepo.findBydeptname(deptname);
		emp.setDept_id(department);
		return empRepo.save(emp);
	}

	public Employee update(Employee emp, Long id) {
		System.out.println(emp.getContacno());
		Employee employee = empRepo.findByEmpid(id);
		emp.setEmpid(employee.getEmpid());
		emp.setDept_id(employee.getDept_id());
		emp.setPassword(employee.getPassword());

		
		return empRepo.save(emp);
	}

	//DEPARTMENS 
	
	public List<Department> retrieveAllDepartments() {
		return (List<Department>) deptRepo.findAll();
	}

	public Department retrieveDepartment(String deptname) {
		Department department = deptRepo.findBydeptname(deptname);

		return department;
	}

	public Department createDepartment(Department dept) {
		return deptRepo.save(dept);
	}

	public Department update(Department dept, Long dept_id) {
		Optional<Department> department = deptRepo.findById(dept_id);
		dept.setDept_id(department.get().getDept_id());

		return deptRepo.save(dept);
	}
	
	public void deleteDepartment(Long dept_id) {
		deptRepo.deleteById(dept_id);
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
	
	public MeetingRoom updateMeetingRoom(MeetingRoom meetingRoom, Long roomId) {
		Optional<MeetingRoom> room = meetingRoomRepo.findById(roomId);
		meetingRoom.setRoomId(room.get().getRoomId());

		return meetingRoomRepo.save(meetingRoom);
	}
	
	public void deleteMeetingRoom(Long roomId) {
		meetingRoomRepo.deleteById(roomId);
	}
	
	//TRAINING ROOMS
	
	public List<TrainingRoom> retrieveAllTrainingRooms() {
		return (List<TrainingRoom>) trainingRoomRepo.findAll();
	}
	
	public TrainingRoom createTrainingRoom(TrainingRoom tRoom) {
		return trainingRoomRepo.save(tRoom);
	}
	
	public Optional<TrainingRoom> retrieveTrainingRoom(long roomId) {
		Optional<TrainingRoom> trainingRoom = trainingRoomRepo.findById(roomId);

		return trainingRoom;
	}
	
	public TrainingRoom updateTrainingRoom(TrainingRoom trainingRoom, Long roomId) {
		Optional<TrainingRoom> room = trainingRoomRepo.findById(roomId);
		trainingRoom.setRoomId(room.get().getRoomId());

		return trainingRoomRepo.save(trainingRoom);
	}
	
	public void deleteTrainingRoom(Long roomId) {
		trainingRoomRepo.deleteById(roomId);
	}
	
	//TASKS
	
	public List<Tasks> retrieveAllTasks() {
		return (List<Tasks>) taskRepo.findAll();
	}
	
	public Tasks createTask(Tasks tasks, long assignedBy, long assignedTo) {
		Employee by = empRepo.findByEmpid(assignedBy);
		Employee to = empRepo.findByEmpid(assignedTo);
		tasks.setAssignedBy(by);
		tasks.setAssignedTo(to);
		return taskRepo.save(tasks);
	}
	
	public Optional<Tasks> retrieveTask(long taskId) {
		Optional<Tasks> tasks = taskRepo.findById(taskId);

		return tasks;
	}
	
	public Tasks updateTask(Tasks tasks, Long taskId) {
		Tasks task = taskRepo.findBytaskId(taskId);
		tasks.setTaskId(task.getTaskId());
		tasks.setStatus(task.isStatus());
		tasks.setAssignedBy(task.getAssignedBy());
		tasks.setAssignedTo(task.getAssignedTo());

		
		return taskRepo.save(tasks);
	}
	
	public void deleteTask(long taskId) {
		taskRepo.deleteById(taskId);
	}
	
	// LEAVE REQUEST
	
	public List<LeaveRequest> retrieveAllRequests() {
		return (List<LeaveRequest>) leaveRepo.findAll();
	}
	
	public LeaveRequest createRequest(LeaveRequest leaveRequest, long empid) {
		Employee emp = empRepo.findByEmpid(empid);
		leaveRequest.setEmpid(emp);
		return leaveRepo.save(leaveRequest);
	}
	
	public Optional<LeaveRequest> retrieveRequest(Long leaveId) {
		Optional<LeaveRequest> leaveRequest = leaveRepo.findById(leaveId);

		return leaveRequest;
	}
	
	
	public LeaveRequest updateRequest(LeaveRequest leaveRequest, Long leaveId) {
		LeaveRequest leave = leaveRepo.findByLeaveId(leaveId);
		leaveRequest.setApprove(leave.getApprove());
		leaveRequest.setEmpid(leave.getEmpid());
		leaveRequest.setLeaveId(leave.getLeaveId());
		leaveRequest.setStatus(leave.isStatus());

		
		return leaveRepo.save(leaveRequest);
	}
	
	public void deleteRequest(long leaveId) {
		leaveRepo.deleteById(leaveId);
	}
	
	public ResponseEntity<Object> approveRequest(LeaveRequest leaveRequest, Long leaveId, String approve) {
		LeaveRequest leave = leaveRepo.findByLeaveId(leaveId);
		leaveRequest.setReason(leave.getReason());
		leaveRequest.setEmpid(leave.getEmpid());
		leaveRequest.setEndDate(leave.getEndDate());
		leaveRequest.setLeaveId(leave.getLeaveId());
		leaveRequest.setLeaveType(leave.getLeaveType());
		leaveRequest.setStartDate(leave.getStartDate());
		leaveRequest.setStatus(leave.isStatus());
		leaveRequest.setApprove(approve);
		leaveRepo.save(leaveRequest);
		return ResponseEntity.notFound().build();

	}	
	
	//MEETINGS
	
	public List<Meetings> retrieveAllMeetings() {
		return (List<Meetings>) meetingsRepo.findAll();
	}
	
	public Meetings createMeeting(Meetings meetings, long empid, long roomId) {
		Employee emp = empRepo.findByEmpid(empid);
		MeetingRoom room = meetingRoomRepo.findByRoomId(roomId);
		meetings.setEmpid(emp);
		meetings.setRoomId(room);
		return meetingsRepo.save(meetings);
	}
	
	public Optional<Meetings> retrieveMeeting(long requestId) {
		Optional<Meetings> meeting = meetingsRepo.findById(requestId);

		return meeting;
	}
	
	public void deleteMeeting(long requestId) {
		meetingsRepo.deleteById(requestId);
	}
	
	public Meetings updateMeeting(Meetings meeting, Long requestId) {
		Meetings meet = meetingsRepo.findByRequestId(requestId);
		meeting.setApprove(meet.getApprove());
		meeting.setEmpid(meet.getEmpid());
		meeting.setRoomId(meet.getRoomId());
		meeting.setRequestId(meet.getRequestId());	
		return meetingsRepo.save(meeting);
	}
	
	public ResponseEntity<Object> approveMeeting(Meetings meetings, Long requestId, String approve) {
		Meetings meet = meetingsRepo.findByRequestId(requestId);
		meetings.setRoomId(meet.getRoomId());
		meetings.setEmpid(meet.getEmpid());
		meetings.setEndTime(meet.getEndTime());
		meetings.setMeetingDesc(meet.getMeetingDesc());
		meetings.setRequestId(meet.getRequestId());
		meetings.setApprove(approve);
		meetings.setStartTime(meet.getStartTime());
		meetingsRepo.save(meetings);
		return ResponseEntity.notFound().build();

	}	
	
	//TRAINING
	
	public List<Training> retrieveAllTrainings() {
		return (List<Training>) trainingRepo.findAll();
	}
	
	public Training createTraining(Training training, long empid, long roomId) {
		Employee emp = empRepo.findByEmpid(empid);
		TrainingRoom room = trainingRoomRepo.findByRoomId(roomId);
		training.setEmpid(emp);
		training.setRoomId(room);
		return trainingRepo.save(training);
	}
	
	public Optional<Training> retrieveTraining(long requestId) {
		Optional<Training> training = trainingRepo.findById(requestId);

		return training;
	}
	
	
	public Training updateTraining(Training training, Long requestId) {
		Training train = trainingRepo.findByRequestId(requestId);
		training.setApprove(train.getApprove());
		training.setEmpid(train.getEmpid());
		training.setRoomId(train.getRoomId());
		training.setRequestId(train.getRequestId());	
		return trainingRepo.save(training);
	}
	
	public void deleteTraining(long requestId) {
		trainingRepo.deleteById(requestId);
	}
	
	public ResponseEntity<Object> approveTraining(Training training, Long requestId, String approve) {
		Training train = trainingRepo.findByRequestId(requestId);
		training.setRoomId(train.getRoomId());
		training.setEmpid(train.getEmpid());
		training.setEndDate(train.getEndDate());
		training.setTrainingDesc(train.getTrainingDesc());
		training.setRequestId(train.getRequestId());
		training.setApprove(approve);
		training.setStartDate(train.getStartDate());
		trainingRepo.save(training);
		return ResponseEntity.notFound().build();

	}
}
