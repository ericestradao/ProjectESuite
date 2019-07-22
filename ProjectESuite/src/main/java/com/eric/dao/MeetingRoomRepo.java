package com.eric.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eric.model.MeetingRoom;

@Repository
public interface MeetingRoomRepo extends CrudRepository<MeetingRoom, Long>{
	MeetingRoom findByroomId(Long roomId);

}
