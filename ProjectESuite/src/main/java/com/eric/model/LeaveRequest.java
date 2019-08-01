package com.eric.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "leaverequest")
public class LeaveRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long leaveId;
	
    private String leaveType;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    private String reason;
    
    private String approve;
    
    private boolean status = false;
    
    @OneToOne
    private Employee empid;

	public LeaveRequest() {}

	public LeaveRequest(Long leaveId, String leaveType, LocalDate startDate, LocalDate endDate, String reason,
			String approve, boolean status, Employee empid) {
		super();
		this.leaveId = leaveId;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = status;
		this.approve = approve;
		this.empid = empid;
	}

	public Long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Employee getEmpid() {
		return empid;
	}

	public void setEmpid(Employee empid) {
		this.empid = empid;
	}
	
}
