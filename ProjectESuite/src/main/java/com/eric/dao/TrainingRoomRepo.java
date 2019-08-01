package com.eric.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eric.model.TrainingRoom;

@Repository
public interface TrainingRoomRepo extends CrudRepository<TrainingRoom, Long>{

	TrainingRoom findByRoomId(Long roomId);

}
