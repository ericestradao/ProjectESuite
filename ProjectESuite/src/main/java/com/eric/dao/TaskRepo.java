package com.eric.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eric.model.Tasks;

@Repository
public interface TaskRepo extends CrudRepository<Tasks, Long> {
	Tasks findBytaskId(Long taskId);

}
