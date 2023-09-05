package com.ritesh.EmployeeMS.service;

import com.ritesh.EmployeeMS.model.Employee;
import com.ritesh.EmployeeMS.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepo iEmployeeRepo;

    public String addEmployee(Employee employee) {
        employee.setJoiningDate(LocalDate.now());
        iEmployeeRepo.save(employee);
        return "New Employee added...!";
    }

    public String rmEmployee(Long empId) {
        iEmployeeRepo.deleteById(empId);
        return "A employee removed...!";
    }

    public Employee getEmpInfo(Long empId) {
        return iEmployeeRepo.findById(empId).orElseGet(null);
    }

    public String giveSalaryHike(Long empId, Double increasePercent) {
        Employee existingEmp = iEmployeeRepo.getReferenceById(empId);
        Double salary = existingEmp.getEmpSalary();
        Double increasedSalary = salary*(increasePercent/100);

        existingEmp.setEmpSalary(salary+increasedSalary);

        iEmployeeRepo.save(existingEmp);

        return "Salary has been increased by "+increasePercent+"%.";
    }

    public String promotion(String promotedDesignation, Long empId) {
        Employee existingEmp = iEmployeeRepo.getReferenceById(empId);
        String prevDesi = existingEmp.getEmpDesignation();
        existingEmp.setEmpDesignation(promotedDesignation);
        iEmployeeRepo.save(existingEmp);

        return "Congratulations you have been promoted to "+promotedDesignation+" from "+prevDesi;
    }


    public String updatePersonalDetails(Employee employee) {
        Employee existingEmp = iEmployeeRepo.getReferenceById(employee.getEmpId());
        if(employee.getEmpName()!=null) existingEmp.setEmpName(employee.getEmpName());
        if(employee.getEmpAddress()!=null) existingEmp.setEmpAddress(employee.getEmpAddress());
        if(employee.getEmpEmail()!=null) existingEmp.setEmpEmail(existingEmp.getEmpEmail());

        iEmployeeRepo.save(existingEmp);
        return "Personal information updated...!";
    }


}
