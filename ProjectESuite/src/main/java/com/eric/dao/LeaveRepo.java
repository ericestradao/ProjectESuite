package com.eric.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eric.model.LeaveRequest;

@Repository
public interface LeaveRepo extends CrudRepository<LeaveRequest, Long>{

}
