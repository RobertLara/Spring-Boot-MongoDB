package com.acua.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.acua.model.Transmitter;

@Repository
public class TransmitterDALImpl implements TransmitterDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Transmitter> getAllTransmitters() {
		return mongoTemplate.findAll(Transmitter.class);
	}

	@Override
	public Transmitter getTransmitterById(String transmitterId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("transmitterId").is(transmitterId));
		return mongoTemplate.findOne(query, Transmitter.class);
	}

	@Override
	public Transmitter addNewTransmitter(Transmitter transmitter) {
		mongoTemplate.save(transmitter);
		// Now, user object will contain the ID as well
		return transmitter;
	}
}
