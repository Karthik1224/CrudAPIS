package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modals.RequestAudit;
import com.example.demo.repositories.RequestAuditRepo;

@Service
public class RequestAuditService {

	@Autowired
	private RequestAuditRepo auditRepo;
	public void addRequestAudit(RequestAudit requestAudit)
	{
		auditRepo.save(requestAudit);
	}
}
