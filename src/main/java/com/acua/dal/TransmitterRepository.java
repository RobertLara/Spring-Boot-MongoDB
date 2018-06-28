package com.acua.dal;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.acua.model.Transmitter;

@Repository
public interface TransmitterRepository extends MongoRepository<Transmitter, String> {
	
	public List<Transmitter> findBy_class(String _class);
	
}
