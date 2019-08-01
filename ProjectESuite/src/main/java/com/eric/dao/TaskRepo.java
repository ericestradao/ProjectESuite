package com.eric.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eric.model.Employee;
import com.eric.model.LeaveRequest;
import com.eric.model.Tasks;

@Repository
public interface TaskRepo extends CrudRepository<Tasks, Long> {
	Tasks findBytaskId(Long taskId);
	List<Tasks> findByAssignedTo(Employee assignedTo);
}
