package com.example.employeeManagementApplication_FrontEnd.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeMailAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handleEmployeeMailAlreadyExistsException(EmployeeMailAlreadyExistsException ex,
                                                                                 WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false),
                "EMPLOYEE_MAIL_ALREADY_EXISTS...!"
        );
        return new ResponseEntity<ErrorDetails>( errorDetails, HttpStatus.BAD_REQUEST);


    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                            WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false),
                "EMPLOYEE DOSE NOT EXIST WITH PROVIDED ID ...!"
        );
        return new ResponseEntity<ErrorDetails>( errorDetails, HttpStatus.BAD_REQUEST);


    }
}
