package com.eric.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eric.model.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    Employee findByEmpid(Long empId);

}
