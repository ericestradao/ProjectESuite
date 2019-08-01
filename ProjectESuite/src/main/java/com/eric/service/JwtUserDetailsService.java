package com.eric.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eric.dao.DeptRepo;
import com.eric.dao.EmployeeRepo;
import com.eric.dao.UserDao;
import com.eric.model.DAOUser;
import com.eric.model.Department;
import com.eric.model.Employee;
import com.eric.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private DeptRepo deptRepo;
	
	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//DAOUser user = userDao.findByUsername(username);
		Employee user = empRepo.findByEmailid(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmailid(), user.getPassword(),
				new ArrayList<>());
	}
	
	public Employee save(UserDTO user, String deptname) {
		Employee newUser = new Employee();
		Department department = deptRepo.findBydeptname(deptname);
		newUser.setEmailid(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setF_name(user.getF_name());
		newUser.setL_name(user.getL_name());
		newUser.setContacno(user.getContacno());
		newUser.setDept_id(department);
		return empRepo.save(newUser);
	}

}