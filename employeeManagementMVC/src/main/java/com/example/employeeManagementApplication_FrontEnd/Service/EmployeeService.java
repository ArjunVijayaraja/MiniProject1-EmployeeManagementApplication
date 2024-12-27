package com.example.employeeManagementApplication_FrontEnd.Service;

import com.example.employeeManagementApplication_FrontEnd.Dto.EmployeeDto;
import com.example.employeeManagementApplication_FrontEnd.Model.EmployeeModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeModel employeeModel);
    EmployeeDto updateEmploee(long empID, EmployeeModel employeeModel);
    List<EmployeeDto> getAllEmployees();
    void deleteEmployee(long empId);
    EmployeeDto findEmployeeByID(long empID);



}
