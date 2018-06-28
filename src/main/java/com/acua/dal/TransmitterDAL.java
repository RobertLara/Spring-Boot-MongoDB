package com.acua.dal;

import java.util.List;

import com.acua.model.Transmitter;

public interface TransmitterDAL {

	List<Transmitter> getAllTransmitters();

	Transmitter getTransmitterById(String transmitterId);

	Transmitter addNewTransmitter(Transmitter transmitter);
}