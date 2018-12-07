package com.monkeylabs.restapi.dto;

public class MessageDTO {

	String message;
	String type;
	
	public MessageDTO() {
		
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
