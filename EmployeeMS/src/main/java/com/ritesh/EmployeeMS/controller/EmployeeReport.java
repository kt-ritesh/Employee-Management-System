package com.ritesh.EmployeeMS.controller;

import com.ritesh.EmployeeMS.model.Report;
import com.ritesh.EmployeeMS.repository.IEmployeeRepo;
import com.ritesh.EmployeeMS.service.EmployeeService;
import com.ritesh.EmployeeMS.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeReport {
    @Autowired
    ReportService reportService;

    @GetMapping("get/performance/{empId}")
    public String getPerformance(@PathVariable Long empId){
        return reportService.getPerformance(empId);
    }

    @GetMapping("get/emp/report")
    List<Report> getEmpReport(@RequestParam Long empId){
        return reportService.getEmpReport(empId);
    }

    @GetMapping("get/attendance/count")
    public String getAttendanceReport(@RequestParam Long empId){
        return reportService.getAttendanceReport(empId);
    }
}
