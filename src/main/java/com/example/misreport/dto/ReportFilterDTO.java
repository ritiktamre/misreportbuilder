package com.example.misreport.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ReportFilterDTO {

    private Long departmentId;
    private String role;
    private LocalDate startDate;
    private LocalDate endDate;
}