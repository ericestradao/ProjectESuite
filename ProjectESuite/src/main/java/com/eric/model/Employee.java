package com.eric.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "employee")
public class Employee {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long empid;

private String f_name;

private String l_name;

@Email
private String emailid;

private Integer contacno;

@OneToOne
private Department dept_id;

public Employee() {}

public Employee(Long empid, String f_name, String l_name, @Email String emailid, Integer contacno, Department dept_id) {
	super();
	this.empid = empid;
	this.f_name = f_name;
	this.l_name = l_name;
	this.emailid = emailid;
	this.contacno = contacno;
	this.dept_id = dept_id;
}

public Long getEmpid() {
	return empid;
}

public void setEmpid(Long empid) {
	this.empid = empid;
}

public String getF_name() {
	return f_name;
}

public void setF_name(String f_name) {
	this.f_name = f_name;
}

public String getL_name() {
	return l_name;
}

public void setL_name(String l_name) {
	this.l_name = l_name;
}

public String getEmailid() {
	return emailid;
}

public void setEmailid(String emailid) {
	this.emailid = emailid;
}

public Integer getContacno() {
	return contacno;
}

public void setContacno(Integer contacno) {
	this.contacno = contacno;
}

public Department getDept_id() {
	return dept_id;
}

public void setDept_id(Department dept_id) {
	this.dept_id = dept_id;
} 


}

