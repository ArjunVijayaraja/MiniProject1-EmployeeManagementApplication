//package com.example.employeeManagementApplication_FrontEnd.Service;
//
//
//import com.example.employeeManagementApplication_FrontEnd.Dto.EmployeeDto;
//import com.example.employeeManagementApplication_FrontEnd.Model.EmployeeModel;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@FeignClient(name = "EMPLOYEEMANAGEMENTAPPLICATION", url = "http://localhost:8081")
//public interface ApiClient {
//
//    @GetMapping("/Employee/all")
//    List<EmployeeDto> getAllEmployee();
//
//    @PostMapping("/Employee/create")
//    EmployeeDto createEmployee(EmployeeDto employeeDto);
//
//    @PostMapping("/Employee/delete/{id}")
//    void deleteEmployee(@PathVariable("id") long ID);
//
//
//
//}
