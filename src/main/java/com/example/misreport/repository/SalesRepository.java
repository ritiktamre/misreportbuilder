package com.example.misreport.repository;

import com.example.misreport.entity.SalesRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<SalesRecord, Long> {}