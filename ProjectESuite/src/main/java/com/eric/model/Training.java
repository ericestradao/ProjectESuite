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
	
    private Long trainingRoomId;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    private String roomDesc;
    
    @OneToOne()
    @JoinColumn(name="empid")
    private Employee empid;
    
    public Training() {}

	public Training(Long requestId, Long trainingRoomId, LocalDate startDate, LocalDate endDate, String roomDesc,
			Employee empid) {
		super();
		this.requestId = requestId;
		this.trainingRoomId = trainingRoomId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.roomDesc = roomDesc;
		this.empid = empid;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Long getTrainingRoomId() {
		return trainingRoomId;
	}

	public void setTrainingRoomId(Long trainingRoomId) {
		this.trainingRoomId = trainingRoomId;
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

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public Employee getEmpid() {
		return empid;
	}

	public void setEmpid(Employee empid) {
		this.empid = empid;
	}
    
}
