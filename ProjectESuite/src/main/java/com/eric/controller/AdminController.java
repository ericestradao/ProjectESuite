package com.eric.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.event.PublicInvocationEvent;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eric.dao.DeptRepo;
import com.eric.dao.EmployeeRepo;
import com.eric.model.Department;
import com.eric.model.Employee;
import com.eric.model.LeaveRequest;
import com.eric.model.MeetingRoom;
import com.eric.model.Meetings;
import com.eric.model.Tasks;
import com.eric.model.Training;
import com.eric.model.TrainingRoom;
import com.eric.service.AdminService;
import com.eric.service.EmployeeMailSenderRepo;
import com.mysql.cj.protocol.a.SimplePacketSender;
import com.sun.mail.handlers.message_rfc822;

@CrossOrigin(origins="http://localhost:4200")
//@RequestMapping(value = "/Admin**")
@RequestMapping({"/Admin**"})
@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private EmployeeMailSenderRepo employeeMailSenderRepo;
	
	//MAIL
	@RequestMapping(path = "/testing/{to}/{subject}/{text}")
	public String sendEmail(@PathVariable("to") String setTo, @PathVariable("subject") String setSubject, @PathVariable("text") String setText)  {
	        return employeeMailSenderRepo.sendingMail(setTo,setSubject,setText); 

	}
	
	//EMPLOYEES
	
	@GetMapping("/employees")
	public List<Employee> retrieveAllEmployees() {
		return adminService.retrieveAllEmployees();
	}

	@RequestMapping(path = "/employee/{emaild}")
	public Employee retrieveEmployee(@PathVariable("emaild") String emaild) {
		return adminService.retrieveEmployee(emaild);
	}

	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable long id) {
		adminService.deleteEmployee(id);
	}
	
	@PostMapping("/newEmployee/{deptname}")
	public Employee create(@RequestBody Employee emp, @PathVariable String deptname) {
		return adminService.create(emp, deptname);

	}

	@PutMapping("/updateEmployee/{id}")
	public Employee update(@RequestBody Employee emp, @PathVariable Long id) {
		return adminService.update(emp, id);
	}
	
	//DEPARTMENTS

	@GetMapping("/departments")
	public List<Department> retrieveAllDepartments() {
		return adminService.retrieveAllDepartments();
	}

	@RequestMapping(path = "/department/{deptname}")
	public Department retrieveDepartment(@PathVariable("deptname") String deptname) {
		return adminService.retrieveDepartment(deptname);
	}

	@PostMapping("/newDepartment")
	public Department createDepartment(@RequestBody Department dept) {
		//employeeMailSenderRepo.sendingMail("ericmohawk182@gmail.com", "testing", "hello there"); 
		return adminService.createDepartment(dept);

	}

	@PutMapping("/updateDepartment/{deptname}")
	public Department update(@RequestBody Department dept, @PathVariable String deptname) {
		return adminService.update(dept, deptname);
	}
	
	//MEETING ROOMS
	
	@GetMapping("/meetingRooms")
	public List<MeetingRoom> retrieveAllMeetingRooms() {
		return adminService.retrieveAllMeetingRooms();
	}
	
	@RequestMapping(path = "/meetingRoom/{roomId}")
	public Optional<MeetingRoom> retrieveMeetingRoom(@PathVariable("roomId") long roomId) {
		return adminService.retrieveMeetingRoom(roomId);
	}
	
	@PostMapping("/newMeetingRoom")
	public MeetingRoom createMeetingRoom(@RequestBody MeetingRoom mRoom) {
		return adminService.createMeetingRoom(mRoom);
	}
	
	@PutMapping("/updateMeetingRoom/{roomId}")
	public MeetingRoom updateMeetingRoom(@RequestBody MeetingRoom meetingRoom, @PathVariable long roomId) {
		return adminService.updateMeetingRoom(meetingRoom, roomId);
	}

	//TRAINING ROOMS
	
	@GetMapping("/trainingRooms")
	public List<TrainingRoom> retrieveAllTrainingRooms() {
		return adminService.retrieveAllTrainingRooms();
	}
	
	@RequestMapping(path = "/trainingRoom/{roomId}")
	public Optional<TrainingRoom> retrieveTrainingRoom(@PathVariable("roomId") long roomId) {
		return adminService.retrieveTrainingRoom(roomId);
	}
	
	@PostMapping("/newTrainingRoom")
	public TrainingRoom createMeetingRoom(@RequestBody TrainingRoom tRoom) {
		return adminService.createTrainingRoom(tRoom);
	}
	
	@PutMapping("/updateTrainingRoom/{roomId}")
	public TrainingRoom updateTrainingRoom(@RequestBody TrainingRoom trainingRoom, @PathVariable long roomId) {
		return adminService.updateTrainingRoom(trainingRoom, roomId);
	}
	
	//TASKS

	@GetMapping("/tasks")
	public List<Tasks> retrieveAllTasks() {
		return adminService.retrieveAllTasks();
	}
	
	@RequestMapping(path = "/task/{taskId}")
	public Optional<Tasks> retrieveTask(@PathVariable("taskId") long taskId) {
		return adminService.retrieveTask(taskId);
	}
	
	@PostMapping("/newTask/{assignedBy}/{assignedTo}")
	public Tasks createTask(@RequestBody Tasks tasks, @PathVariable long assignedBy, @PathVariable long assignedTo) {
		System.out.println(assignedBy+assignedTo);
		return adminService.createTask(tasks, assignedBy, assignedTo);
	}
	
	@PutMapping("/updateTask/{taskId}")
	public Tasks updateTask(@RequestBody Tasks tasks, @PathVariable long taskId) {
		return adminService.updateTask(tasks, taskId);
	}
	
	@DeleteMapping("/task/{taskId}")
	public void deleteTask(@PathVariable long taskId) {
		adminService.deleteTask(taskId);
	}
	
	//LEAVE REQUEST

	@GetMapping("/leaveRequests")
	public List<LeaveRequest> retrieveAllRequests() {
		return adminService.retrieveAllRequests();
	}
	
//	@RequestMapping(path = "/leaveRequest/{empid}")
//	public List<LeaveRequest> retrieveRequest(@PathVariable("empid") Employee empid) {
//		return adminService.retrieveRequest(empid);
//	}
//	
	@PostMapping("/newRequest/{empid}")
	public LeaveRequest createRequest(@RequestBody LeaveRequest leaveRequest, @PathVariable long empid) {
		return adminService.createRequest(leaveRequest, empid);
	}
	
	@PutMapping("/updateRequest/{leaveId}")
	public LeaveRequest updateRequest(@RequestBody LeaveRequest leaveRequest, @PathVariable long empid) {
		return adminService.updateRequest(leaveRequest, empid);
	}
	
	@DeleteMapping("/leaveRequest/{leaveId}")
	public void deleteRequest(@PathVariable long leaveId) {
		adminService.deleteRequest(leaveId);
	}
	
	@PutMapping("/approveRequest/{leaveId}/{approve}")
	public ResponseEntity<Object> approveRequest(LeaveRequest leaveRequest, @PathVariable Long leaveId, @PathVariable String approve) {
		return adminService.approveRequest(leaveRequest, leaveId, approve);
	}
	
	//MEETINGS
	
	@GetMapping("/meetings")
	public List<Meetings> retrieveAllMeetings() {
		return adminService.retrieveAllMeetings();
	}
	
	@RequestMapping(path = "/meeting/{requestId}")
	public Optional<Meetings> retrieveMeeting(@PathVariable("requestId") long requestId) {
		return adminService.retrieveMeeting(requestId);
	}
	
	@PostMapping("/newMeeting/{empid}/{roomId}")
	public Meetings createMeeting(@RequestBody Meetings meetings, @PathVariable long empid, @PathVariable long roomId) {
		return adminService.createMeeting(meetings, empid, roomId);
	}
	
	@PutMapping("/updateMeeting/{requestId}")
	public Meetings updateMeeting(@RequestBody Meetings meetings, @PathVariable long requestId) {
		return adminService.updateMeeting(meetings, requestId);
	}
	
	@DeleteMapping("/meeting/{requestId}")
	public void deleteMeeting(@PathVariable long requestId) {
		adminService.deleteMeeting(requestId);
	}
	
	@PutMapping("/approveMeeting/{requestId}/{approve}")
	public ResponseEntity<Object> approveMeeting(Meetings meetings, @PathVariable Long requestId, @PathVariable String approve) {
		return adminService.approveMeeting(meetings, requestId, approve);
	}
	
	//TRAINING
	
	@GetMapping("/trainings")
	public List<Training> retrieveAllTrainings() {
		return adminService.retrieveAllTrainings();
	}
	
	@RequestMapping(path = "/training/{requestId}")
	public Optional<Training> retrieveTraining(@PathVariable("requestId") long requestId) {
		return adminService.retrieveTraining(requestId);
	}
	
	@PostMapping("/newTraining/{empid}/{roomId}")
	public Training createTraining(@RequestBody Training training, @PathVariable long empid, @PathVariable long roomId) {
		return adminService.createTraining(training, empid, roomId);
	}
	
	@PutMapping("/updateTraining/{requestId}")
	public Training updateTraining(@RequestBody Training training, @PathVariable long requestId) {
		return adminService.updateTraining(training, requestId);
	}
	
	@DeleteMapping("/training/{requestId}")
	public void deleteTraining(@PathVariable long requestId) {
		adminService.deleteTraining(requestId);
	}
	
	@PutMapping("/approveTraining/{requestId}/{approve}")
	public ResponseEntity<Object> approveTraining(Training training, @PathVariable Long requestId, @PathVariable String approve) {
		return adminService.approveTraining(training, requestId, approve);
	}
}
