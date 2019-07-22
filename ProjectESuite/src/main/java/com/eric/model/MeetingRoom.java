package com.eric.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meetingroom")
public class MeetingRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roomId;
	
    private String meetingRoomName;
    
    private int capacity;
    
    private int floor;
    
    @ElementCollection(targetClass=HashMap.class)
    Map<LocalDate,Set<LocalTime>> reserved = new HashMap<>();
    
    public MeetingRoom() {}

	public MeetingRoom(Long roomId, String meetingRoomName, int capacity, int floor,
			Map<LocalDate, Set<LocalTime>> reserved) {
		super();
		this.roomId = roomId;
		this.meetingRoomName = meetingRoomName;
		this.capacity = capacity;
		this.floor = floor;
		this.reserved = reserved;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getMeetingRoomName() {
		return meetingRoomName;
	}

	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public Map<LocalDate, Set<LocalTime>> getReserved() {
		return reserved;
	}

	public void setReserved(Map<LocalDate, Set<LocalTime>> reserved) {
		this.reserved = reserved;
	}
    
}
