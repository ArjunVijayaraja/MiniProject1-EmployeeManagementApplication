package com.example.employeeManagementApplication_FrontEnd.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(long ID){
        super(String.format("Employee dose not exist with the ID: '%s'",ID));
    }
}
