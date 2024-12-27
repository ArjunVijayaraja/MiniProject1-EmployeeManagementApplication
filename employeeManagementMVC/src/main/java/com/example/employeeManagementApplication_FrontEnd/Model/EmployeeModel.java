package com.example.employeeManagementApplication_FrontEnd.Model;

//import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    private long employeeId;
    @NotBlank(message = "Employee Name should not be empty")
    private String employeeName;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email should not be empty")
    private String employeeMail;
    @NotNull(message = "DOB should not be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeDOB;
    @NotBlank(message = "Gender should not be empty")
    private String employeeGender;
    @NotBlank(message = "Contact should not be empty")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    private String employeeContact;
    @NotBlank(message = "Address should not be empty")
    private String employeeAddress;
    @NotBlank(message = "Select an Employment Type")
    private String employmentType;

}

