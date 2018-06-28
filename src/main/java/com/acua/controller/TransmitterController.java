package com.acua.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acua.dal.TransmitterRepository;
import com.acua.model.Transmitter;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value = "/transmitter")
public class TransmitterController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final TransmitterRepository transmitterRepository;

	public TransmitterController(TransmitterRepository transmitterRepository) {
		this.transmitterRepository = transmitterRepository;
	}

	@ApiOperation(value = "Create a new transmitter")
	@ApiResponses(value = {
            @ApiResponse(code = 201, message = "Create successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    }
	)
	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	public ResponseEntity<Transmitter> addNewTransmitters(@RequestBody Transmitter transmitter) {
		logger.info("Saving transmitter.");
		return ResponseEntity.status(HttpStatus.OK).body(transmitterRepository.save(transmitter));
	}
	
	@ApiOperation(value = "Get all transmitters")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
	)
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Transmitter>> getAllTransmitters() {
		logger.info("Getting all transmitters.");
		List<Transmitter> result = transmitterRepository.findBy_class(Transmitter.class.getSimpleName().toLowerCase());
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@ApiOperation(value = "Get transmitter by id")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
	)
	@RequestMapping(value = "/{transmitterId}", method = RequestMethod.GET)
	public ResponseEntity<Transmitter> getTransmitter(@PathVariable String transmitterId) {
		logger.info("Getting transmitter with ID: {}.", transmitterId);
		Optional<Transmitter> optionalTransmitter = transmitterRepository.findById(transmitterId);
		if (optionalTransmitter.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optionalTransmitter.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@ApiOperation(value = "Remove transmitter by id")
	@ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
	)
	@RequestMapping(value = "/delete/{transmitterId}", method = RequestMethod.DELETE)
	public BodyBuilder deleteTransmitter(@PathVariable String transmitterId) {
		logger.info("Remove transmitter with ID: {}.", transmitterId);
		Optional<Transmitter> optionalTransmitter = transmitterRepository.findById(transmitterId);
		if (optionalTransmitter.isPresent()) {
			transmitterRepository.delete(optionalTransmitter.get());
			return ResponseEntity.status(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND);
	}
}