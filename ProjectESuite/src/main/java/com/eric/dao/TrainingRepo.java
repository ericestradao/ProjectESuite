package com.eric.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eric.model.Employee;
import com.eric.model.LeaveRequest;
import com.eric.model.Meetings;
import com.eric.model.Training;

@Repository
public interface TrainingRepo extends CrudRepository<Training, Long>{
	List<Training> findByEmpid(Employee empid);
	Training findByRequestId(Long requestId);
}
