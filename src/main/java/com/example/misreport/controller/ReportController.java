package com.example.misreport.controller;

import com.example.misreport.dto.ReportResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.misreport.dto.ReportFilterDTO;
import com.example.misreport.service.ReportService;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping
    public List<ReportResponseDTO> generateReport(@RequestBody ReportFilterDTO filter) {
        return reportService.generateReport(filter);
    }
}