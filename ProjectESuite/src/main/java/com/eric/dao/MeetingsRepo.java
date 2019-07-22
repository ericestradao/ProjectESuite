package com.eric.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eric.model.Meetings;

@Repository
public interface MeetingsRepo extends CrudRepository<Meetings, Long>{

}
