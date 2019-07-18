package com.eric.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dept_id;
	
	private String deptName;
	
	public Department() {}
	
	public Department(Long dept_id, String deptname) {
		super();
		this.dept_id = dept_id;
		this.deptName = deptname;
	}

	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}

	public String getDeptname() {
		return deptName;
	}

	public void setDeptname(String deptname) {
		this.deptName = deptname;
	}

}
