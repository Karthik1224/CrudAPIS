package com.example.demo.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class AuditRecords{
	
	@Id
	private String uuid;
	private String requestPayload;
	private String responsePayload;
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getRequestPayload() {
		return requestPayload;
	}
	public void setRequestPayload(String requestPayload) {
		this.requestPayload = requestPayload;
	}
	public String getResponsePayload() {
		return responsePayload;
	}
	public void setResponsePayload(String responsePayload) {
		this.responsePayload = responsePayload;
	}
   
}
