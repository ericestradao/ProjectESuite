package com.eric.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "meetings")
public class Meetings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestId;
	
    private Long MeetingRoomId;
    
    private Timestamp startTime;
    
    private Timestamp endTime;
    
    private String meetingDesc;
    
    @OneToOne
    @JoinColumn(name="empid")
    private Employee empid;
    
	public Meetings() {}

	public Meetings(Long requestId, Long meetingRoomId, Timestamp startTime, Timestamp endTime, String meetingDesc,
			Employee empid) {
		super();
		this.requestId = requestId;
		MeetingRoomId = meetingRoomId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.meetingDesc = meetingDesc;
		this.empid = empid;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Long getMeetingRoomId() {
		return MeetingRoomId;
	}

	public void setMeetingRoomId(Long meetingRoomId) {
		MeetingRoomId = meetingRoomId;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getMeetingDesc() {
		return meetingDesc;
	}

	public void setMeetingDesc(String meetingDesc) {
		this.meetingDesc = meetingDesc;
	}

	public Employee getEmpid() {
		return empid;
	}

	public void setEmpid(Employee empid) {
		this.empid = empid;
	}
	
	
}
