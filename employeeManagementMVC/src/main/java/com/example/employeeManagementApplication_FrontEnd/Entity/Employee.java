package com.example.employeeManagementApplication_FrontEnd.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    @Column(nullable = false)
    private String employeeName;
    @Column(nullable = false)
    private String employeeMail;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE) // Ensures only the date is stored and retrieved
    private Date employeeDOB;
    @Column(nullable = false)
    private String employeeGender;
    @Column(nullable = false)
    private String employeeContact;
    @Column(nullable = false)
    private String employeeAddress;
    @Column(nullable = false)
    private String employmentType;



}
