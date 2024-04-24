package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.AuditRecords;

@Repository
public interface AuditDao extends JpaRepository<AuditRecords, String>{

}
