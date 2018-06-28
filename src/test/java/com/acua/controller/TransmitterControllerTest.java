package com.acua.controller;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acua.dal.TransmitterRepository;
import com.acua.model.Transmitter;

@RunWith(SpringJUnit4ClassRunner.class)
public class TransmitterControllerTest {
	
	@InjectMocks
	TransmitterController controller;
	
	@Mock
	TransmitterRepository repository;
	
	private static final String ID = "ID";
	
	@Test
	public void findByIdTest() {
		controller.getTransmitter(ID);
		verify(repository).findById(ID);
	}
	
	@Test
	public void getAllTransmitters() {
		controller.getAllTransmitters();
		verify(repository).findBy_class(Transmitter.class.getSimpleName().toLowerCase());
	}
	
	
	
	
	
	
	

}
