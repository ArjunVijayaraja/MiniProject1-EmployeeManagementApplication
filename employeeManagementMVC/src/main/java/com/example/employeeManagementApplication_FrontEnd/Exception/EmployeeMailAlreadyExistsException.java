package com.example.employeeManagementApplication_FrontEnd.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST) //Providing this .BAD_REQUEST will display status code as 400.
public class EmployeeMailAlreadyExistsException extends RuntimeException{
    public EmployeeMailAlreadyExistsException(String empMail) {
        super(String.format("Employee Already Exists with provide email: '%s'",empMail));
    }
}
