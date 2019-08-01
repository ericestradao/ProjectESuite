package com.eric.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.eric.model.Department;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface DeptRepo extends CrudRepository<Department, String>{
	Department findBydeptname (String deptname);
}
