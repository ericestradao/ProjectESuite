package com.eric.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eric.model.Employee;
import com.eric.model.LeaveRequest;
import com.eric.model.Meetings;

@Repository
public interface MeetingsRepo extends CrudRepository<Meetings, Long>{
	List<Meetings> findByEmpid(Employee empid);
	Meetings findByRequestId(Long requestId);
}
