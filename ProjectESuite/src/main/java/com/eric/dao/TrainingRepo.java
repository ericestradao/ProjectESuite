package com.eric.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eric.model.Training;

@Repository
public interface TrainingRepo extends CrudRepository<Training, Long>{

}
