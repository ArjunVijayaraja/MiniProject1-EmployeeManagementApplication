package com.example.employeeManagementApplication_FrontEnd.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private long employeeId;
    private String employeeName;
    private String employeeMail;
    private Date employeeDOB;
    private String employeeGender;
    private String employeeContact;
    private String employeeAddress;
    private String employmentType;
}
