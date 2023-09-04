package com.ritesh.EmployeeMS.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reportId;

    private boolean isPresent;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate date;

    private Double rating;

    @ManyToOne
    private Employee employee;
}
