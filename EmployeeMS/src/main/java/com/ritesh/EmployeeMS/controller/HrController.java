package com.ritesh.EmployeeMS.controller;

import com.ritesh.EmployeeMS.model.Employee;
import com.ritesh.EmployeeMS.service.EmployeeService;
import com.ritesh.EmployeeMS.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HrController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ReportService reportService;

    @PostMapping("add/employee")
    public String addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("remove/employee")
    public String removeEmployee(@RequestParam Long empId){
        return employeeService.rmEmployee(empId);
    }

    @GetMapping("employee/details/{empId}")
    public Employee getEmpDetails(@PathVariable Long empId){
        return employeeService.getEmpInfo(empId);
    }

    @PutMapping("hike/salary")
    public String giveSalaryHike(@RequestParam Long empId, @RequestParam Double increasePercent){
        return employeeService.giveSalaryHike(empId, increasePercent);
    }

    @PutMapping("promotion")
    public String promotion(@RequestParam String PromotedDesignation, @RequestParam Long empId){
        return employeeService.promotion(PromotedDesignation, empId);
    }

    @PostMapping("give/rating/{empId}")
    public String giveRatingOutOf5(@PathVariable Long empId, @RequestParam Double rating){
        return reportService.giveRatingOutOf5(empId, rating);
    }
}
