package com.example.employeeManagementApplication_FrontEnd.Service.Impl;

import com.example.employeeManagementApplication_FrontEnd.Dto.EmployeeDto;
import com.example.employeeManagementApplication_FrontEnd.Entity.Employee;
import com.example.employeeManagementApplication_FrontEnd.Exception.EmployeeMailAlreadyExistsException;
import com.example.employeeManagementApplication_FrontEnd.Exception.ResourceNotFoundException;
import com.example.employeeManagementApplication_FrontEnd.Model.EmployeeModel;
//import com.example.employeeManagementApplication_FrontEnd.Service.ApiClient;
import com.example.employeeManagementApplication_FrontEnd.Repository.EmployeeRepository;
import com.example.employeeManagementApplication_FrontEnd.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;
   // private ApiClient apiClient;

    @Override
    public EmployeeDto createEmployee(EmployeeModel employeeModel) {

        EmployeeDto employeeDto = modelMapper.map(employeeModel,EmployeeDto.class);
         Optional<Employee> existingemp = employeeRepository.findByEmployeeMail(employeeModel.getEmployeeMail());
         if(existingemp.isPresent()){
             throw new EmployeeMailAlreadyExistsException(employeeModel.getEmployeeMail());
         }
         Employee SavedEmp =  employeeRepository.save(modelMapper.map(employeeDto, Employee.class));
        return modelMapper.map(SavedEmp,EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmploee(long empID, EmployeeModel employeeModel) {
      EmployeeDto empdto =   modelMapper.map(employeeModel,EmployeeDto.class);
      Optional<Employee> Optionalemp = employeeRepository.findByEmployeeId(empID);
      if(Optionalemp.isEmpty()){
          throw new ResourceNotFoundException(empID);
      }
      Optionalemp.get().setEmployeeMail(employeeModel.getEmployeeMail());
      Optionalemp.get().setEmployeeContact(employeeModel.getEmployeeContact());
      Optionalemp.get().setEmployeeName(employeeModel.getEmployeeName());
      Optionalemp.get().setEmployeeDOB(employeeModel.getEmployeeDOB());
      Optionalemp.get().setEmployeeAddress(employeeModel.getEmployeeAddress());
      Optionalemp.get().setEmploymentType(employeeModel.getEmploymentType());
      Employee updatedEmp = employeeRepository.save(Optionalemp.get());
      return modelMapper.map(updatedEmp,EmployeeDto.class);
    }


    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList =  employeeList.stream().map(
                empDto->modelMapper.map(empDto,EmployeeDto.class)).collect(Collectors.toList()
        );
        return employeeDtoList;
    }

    @Override
    public void deleteEmployee(long empId) {
        employeeRepository.deleteById(empId);
       return;
    }

    @Override
    public EmployeeDto findEmployeeByID(long empID) {
       Optional<Employee> emp =  employeeRepository.findByEmployeeId(empID);
       if(emp.isEmpty()){
           throw new ResourceNotFoundException(empID);
       }
        return modelMapper.map(emp,EmployeeDto.class);
    }

}
