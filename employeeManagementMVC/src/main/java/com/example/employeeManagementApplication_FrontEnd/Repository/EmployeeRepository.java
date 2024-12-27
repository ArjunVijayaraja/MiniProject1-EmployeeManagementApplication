package com.example.employeeManagementApplication_FrontEnd.Repository;

import com.example.employeeManagementApplication_FrontEnd.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

   Optional<Employee> findByEmployeeMail(String EmpMail);
   Optional<Employee> findByEmployeeId(long empID);

}
