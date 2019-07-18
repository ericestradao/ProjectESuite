package com.eric.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eric.model.Department;

@Repository
public interface DeptRepo extends CrudRepository<Department, String>{
	Department findBydeptName (String deptname);
}
