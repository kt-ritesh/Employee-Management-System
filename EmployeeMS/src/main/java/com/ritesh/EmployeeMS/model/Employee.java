package com.ritesh.EmployeeMS.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String empName;
    @Email
    @Column(unique = true)
    private String empEmail;
    private String empAddress;
    @Enumerated(EnumType.STRING)
    private Designation empDesignation;
    @Column(nullable = false)
    private Double empSalary;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate joiningDate;
}
