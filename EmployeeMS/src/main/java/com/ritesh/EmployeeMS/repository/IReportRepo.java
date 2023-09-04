package com.ritesh.EmployeeMS.repository;

import com.ritesh.EmployeeMS.model.Employee;
import com.ritesh.EmployeeMS.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReportRepo extends JpaRepository<Report, Long> {
    List<Report> findAllByEmployee(Employee existingEmp);
}
