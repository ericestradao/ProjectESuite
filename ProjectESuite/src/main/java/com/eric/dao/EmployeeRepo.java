package com.eric.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.eric.model.Employee;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    Employee findByEmpid(Long empId);
    Employee findByEmailid(String emailid);
    //List<Employee> findByEmpid(Long empid);

}
