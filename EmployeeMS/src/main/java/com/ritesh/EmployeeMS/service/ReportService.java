package com.ritesh.EmployeeMS.service;

import com.ritesh.EmployeeMS.model.Employee;
import com.ritesh.EmployeeMS.model.Report;
import com.ritesh.EmployeeMS.repository.IEmployeeRepo;
import com.ritesh.EmployeeMS.repository.IReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    IReportRepo iReportRepo;

    @Autowired
    IEmployeeRepo iEmployeeRepo;
    public String markAttendance(Long empId) {
        Employee existingEmp = iEmployeeRepo.findById(empId).orElse(null);
        if(existingEmp==null) return "Invalid Employee...!";

        Report report = new Report();
        report.setPresent(true);
        report.setDate(LocalDate.now());
        report.setEmployee(iEmployeeRepo.getReferenceById(empId));
        iReportRepo.save(report);

        return "Attendance marked...!";
    }

    public String giveRatingOutOf5(Long empId, Double rating) {
        if(rating>5||rating<1) return "Enter rating between 1 to 5.";
        Employee existingEmp = iEmployeeRepo.findById(empId).orElse(null);

        Report report = new Report();
        report.setRating(rating);
        report.setDate(LocalDate.now());
        report.setEmployee(iEmployeeRepo.getReferenceById(empId));
        iReportRepo.save(report);

        return "Your rating is to added Thank You!";
    }

    public String getPerformance(Long empId) {
        Employee existingEmp = iEmployeeRepo.findById(empId).orElse(null);
        if(existingEmp==null) {
            return "Invalid employee id.";
        }

        List<Report> empReport = iReportRepo.findAllByEmployee(existingEmp);

        double rating = 0.0;
        double count = 0.0;
        for (Report report : empReport) {
            Double existingRating = report.getRating();
            if(existingRating==null) continue;;
                rating += existingRating;
                count++;
        }
        return "The rating of "+existingEmp.getEmpName()+" is "+rating/count+" out of 5.";
    }

    public List<Report> getEmpReport(Long empId) {
        Employee existingEmp = iEmployeeRepo.findById(empId).orElse(null);
        return iReportRepo.findAllByEmployee(existingEmp);
    }

    public String getAttendanceReport(Long empId) {
        Employee existingEmp = iEmployeeRepo.findById(empId).orElse(null);
        if(existingEmp==null) {
            return "Invalid employee id.";
        }

        List<Report> empReport = iReportRepo.findAllByEmployee(existingEmp);
        int presentCount = 0;
        int total = 0;
        for (Report report : empReport){
            total++;
            if(report.isPresent()) presentCount++;
        }
        int absent = total-presentCount-(total/7);
        return "You are present "+presentCount+" days in "+total+" days and you absent "+absent+" excluding weekend.";
    }
}
