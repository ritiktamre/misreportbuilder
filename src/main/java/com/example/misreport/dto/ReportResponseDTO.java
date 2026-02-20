package com.example.misreport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponseDTO {

    private String employeeName;

    private Long totalAttendance;

    private Double totalSales;

    private Double averagePerformance;
}