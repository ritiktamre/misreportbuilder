package com.example.misreport.service.impl;

import com.example.misreport.dto.ReportResponseDTO;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.*;

import com.example.misreport.dto.ReportFilterDTO;
import com.example.misreport.service.ReportService;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final EntityManager entityManager;

    @Override
    public List<ReportResponseDTO> generateReport(ReportFilterDTO filter) {

        StringBuilder query = new StringBuilder("""
        SELECT e.name,
               COUNT(a.id),
               COALESCE(SUM(s.amount), 0),
               AVG(e.performanceScore)
        FROM Employee e
        LEFT JOIN Attendance a ON e.id = a.employee.id AND a.present = true
        LEFT JOIN SalesRecord s ON e.id = s.employee.id
        WHERE 1=1
    """);

        Map<String, Object> params = new HashMap<>();

        if (filter.getDepartmentId() != null) {
            query.append(" AND e.department.id = :deptId");
            params.put("deptId", filter.getDepartmentId());
        }

        if (filter.getRole() != null) {
            query.append(" AND e.role = :role");
            params.put("role", filter.getRole());
        }

        query.append(" GROUP BY e.name");

        Query q = entityManager.createQuery(query.toString());
        params.forEach(q::setParameter);

        List<Object[]> results = q.getResultList();

        List<ReportResponseDTO> response = new ArrayList<>();

        for (Object[] row : results) {
            response.add(new ReportResponseDTO(
                    (String) row[0],
                    (Long) row[1],
                    (Double) row[2],
                    (Double) row[3]
            ));
        }

        return response;
    }
}