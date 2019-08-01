package com.eric.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Tasks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long taskId;
	
	private String taskName;
	
    private String taskDesc;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    @OneToOne
    private Employee assignedTo;
    
    @OneToOne
    private Employee assignedBy;
    
    @Column(name="completed")
    private boolean status=false;
    
    public Tasks() {}

	public Tasks(Long taskId, String taskName, String taskDesc, LocalDate startDate, LocalDate endDate, Employee assignedTo,
			Employee assignedBy, boolean status) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDesc = taskDesc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.assignedTo = assignedTo;
		this.assignedBy = assignedBy;
		this.status = status;
	}
	
    public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
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

	public Employee getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Employee assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Employee getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(Employee assignedBy) {
		this.assignedBy = assignedBy;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
     
}
