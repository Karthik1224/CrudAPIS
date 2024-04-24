package com.example.demo.service;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AuditDao;
import com.example.demo.modal.AuditRecords;

import ch.qos.logback.classic.Logger;

@Service
public class AuditService {
   
	private static final Logger log = (Logger) LoggerFactory.getLogger(AuditService.class);
	
	@Autowired
	private AuditDao auditDao;
	
	public void createAuditRecords(String uuid,String requestPayload)
	{
		log.info("Inside auditService");
		AuditRecords auditRecords = new AuditRecords();
		auditRecords.setUuid(uuid);
		auditRecords.setRequestPayload(requestPayload);
		auditDao.save(auditRecords);
	}
	
	public void updateAuditRecords(String uuid,String responsePayload)
	{
		Optional<AuditRecords> optionalAuditRecords = auditDao.findById(uuid);
		if(optionalAuditRecords == null || !optionalAuditRecords.isEmpty())
		{
			return;
		}
		AuditRecords auditRecords = optionalAuditRecords.get();
		auditRecords.setResponsePayload(responsePayload);
		auditDao.save(auditRecords);
	}
}
