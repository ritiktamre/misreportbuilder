package com.example.misreport.controller;

import com.example.misreport.dto.ReportFilterDTO;
import com.example.misreport.dto.ReportResponseDTO;
import com.example.misreport.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReportViewController {

    private final ReportService reportService;

    @Autowired
    public ReportViewController(ReportService reportService) {
        this.reportService = reportService;
    }

    // Show UI page
    @GetMapping("/report-ui")
    public String showReportPage(Model model) {
        model.addAttribute("filter", new ReportFilterDTO());
        return "report";  // loads report.html
    }

    // Handle form submission
    @PostMapping("/report-ui")
    public String generateReport(@ModelAttribute("filter") ReportFilterDTO filter,
                                 Model model) {

        List<ReportResponseDTO> reportResults =
                reportService.generateReport(filter);

        model.addAttribute("results", reportResults);

        return "report";  // reload same page with results
    }
}