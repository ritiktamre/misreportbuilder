package com.example.misreport.service;

import com.example.misreport.dto.ReportFilterDTO;
import com.example.misreport.dto.ReportResponseDTO;

import java.util.List;

public interface ReportService {
    List<ReportResponseDTO> generateReport(ReportFilterDTO filter);
}