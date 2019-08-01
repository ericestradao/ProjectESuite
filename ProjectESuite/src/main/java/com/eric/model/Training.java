package com.eric.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "training")
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestId;
	
	@OneToOne()
    private TrainingRoom roomId;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    private String trainingDesc;
    
    private String approve;

	@OneToOne()
    @JoinColumn(name="empid")
    private Employee empid;
    
    public Training() {}

	public Training(Long requestId, TrainingRoom roomId, LocalDate startDate, LocalDate endDate, String trainingDesc,
			String approve, Employee empid) {
		super();
		this.requestId = requestId;
		this.roomId = roomId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainingDesc = trainingDesc;
		this.approve = approve;
		this.empid = empid;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public TrainingRoom getRoomId() {
		return roomId;
	}

	public void setRoomId(TrainingRoom roomId) {
		this.roomId = roomId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getTrainingDesc() {
		return trainingDesc;
	}

	public void setTrainingDesc(String trainingDesc) {
		this.trainingDesc = trainingDesc;
	}
	
	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public Employee getEmpid() {
		return empid;
	}

	public void setEmpid(Employee empid) {
		this.empid = empid;
	}
    
}
