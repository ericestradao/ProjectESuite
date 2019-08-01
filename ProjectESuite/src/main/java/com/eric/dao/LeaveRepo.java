package com.eric.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eric.model.Employee;
import com.eric.model.LeaveRequest;

@Repository
public interface LeaveRepo extends CrudRepository<LeaveRequest, Long>{
	//  List<LeaveRequest> findByLeaveType(String leaveType);
	  List<LeaveRequest> findByEmpid(Employee empid);
	  LeaveRequest findByLeaveId(Long leaveId);

}
