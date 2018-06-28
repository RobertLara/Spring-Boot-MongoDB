package com.acua.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "transmitters")
public class Transmitter {

	@Id
	@ApiModelProperty(notes = "Identifier of Transmitter")
	private String transmitterId;
	
	@ApiModelProperty(notes = "Alias of Transmitter")
	private String alias;
	
	@ApiModelProperty(notes = "Insert date")
	private Date creationDate = new Date();
    
	@DBRef
    @Field("sim")
    private Sim sim;
    
    @DBRef
    @Field("modem")
    private Modem modem;
    
    @Field("_class")
    private String _class;

	public String getTransmitterId() {
		return transmitterId;
	}

	public void setTransmitterId(String transmitterId) {
		this.transmitterId = transmitterId;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Sim getSim() {
		return sim;
	}

	public Modem getModem() {
		return modem;
	}

	public void setSim(Sim sim) {
		this.sim = sim;
	}

	public void setModem(Modem modem) {
		this.modem = modem;
	}

	public String get_class() {
		return _class;
	}

	public void set_class(String _class) {
		this._class = _class;
	}
}
