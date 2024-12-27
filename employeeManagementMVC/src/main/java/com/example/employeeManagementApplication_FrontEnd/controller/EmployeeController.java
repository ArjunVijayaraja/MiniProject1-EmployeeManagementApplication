package com.example.employeeManagementApplication_FrontEnd.controller;

//import com.example.employeeManagementApplication_FrontEnd.Dto.EmployeeDto;
import com.example.employeeManagementApplication_FrontEnd.Dto.EmployeeDto;
import com.example.employeeManagementApplication_FrontEnd.Exception.EmployeeMailAlreadyExistsException;
import com.example.employeeManagementApplication_FrontEnd.Service.EmployeeService;
import com.example.employeeManagementApplication_FrontEnd.Model.EmployeeModel;
import jakarta.validation.Path;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.bouncycastle.math.raw.Mod;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
//@RequestMapping("/Employee")
@AllArgsConstructor

public class EmployeeController {
    private EmployeeService employeeService;
    private ModelMapper modelMapper;

    @GetMapping({"/","/index"})
    public String displayIndexPage(Model model){
        EmployeeModel employeeModel = new EmployeeModel();
        model.addAttribute("employee_model", employeeModel);
        List<EmployeeDto> empsDto = employeeService.getAllEmployees();
        List<EmployeeModel> emps =  empsDto.stream().map(e->modelMapper.map(e,EmployeeModel.class)).collect(Collectors.toList());
        model.addAttribute("empss",emps);
        return "index";
    }

    @PostMapping("/index")
    public String createEmployee(@Valid @ModelAttribute("employee_model") EmployeeModel employeeModel,
        BindingResult result,Model model){

        List<EmployeeDto> empsDto = employeeService.getAllEmployees();
        List<EmployeeModel> emps = empsDto.stream().map(e -> modelMapper.map(e, EmployeeModel.class)).collect(Collectors.toList());
        if(result.hasErrors()){
            model.addAttribute("employee_model",employeeModel);
            model.addAttribute("empss",emps);
            return "/index";
        }
       try {
           EmployeeDto createdEmpDto = employeeService.createEmployee(employeeModel);
          model.addAttribute("empss", emps);
           return "redirect:/index?success";
       }catch (EmployeeMailAlreadyExistsException ex){
           model.addAttribute("error",ex.getMessage());
           model.addAttribute("empss", emps);
           return "/index";
       }catch (Exception ex){
           model.addAttribute("error","something went wrong..tyr again..!");
           model.addAttribute("empss", emps);
           return "/index";
       }

    }

//    @GetMapping("/index")
//    public String loadIndexPage(@ModelAttribute("employee_model") EmployeeModel employeeModel, Model model) {
//        model.addAttribute("employee_modal", new EmployeeModel());
//        List<EmployeeDto> empsDto = employeeService.getAllEmployees();
//        List<EmployeeModel> emps =  empsDto.stream().map(e->modelMapper.map(e,EmployeeModel.class)).collect(Collectors.toList());
//        model.addAttribute("empss",emps);
//        return "index";
//    }

    @PostMapping("/updateEMP/{id}")
    public String updateEmp(@ModelAttribute("employee_model") EmployeeModel employeeModel, Model model,
                            @PathVariable("id") long eid){
        EmployeeDto updatedEmpDto = employeeService.updateEmploee(eid, employeeModel);
        model.addAttribute("employee_model",modelMapper.map(updatedEmpDto,EmployeeModel.class));
        return "redirect:/index?updated";

    }


    @RequestMapping("/delEmp/{id}")
    public String deleteEmployee(@ModelAttribute("employee_model") EmployeeModel employeeModel, Model model, @PathVariable("id") long id){

        model.addAttribute("employee_modal", new EmployeeModel());
        employeeService.deleteEmployee(id);
       // List<EmployeeModel> emps =  employeeService.getAllEmployees();
        //model.addAttribute("empss",emps);
        return "redirect:/index";
    }

    @GetMapping("/getEMP/{id}")
    public String getEmployeeByID(Model model,
                                  @PathVariable("id") long EMPID){
        //model.addAttribute("employee_modal", employeeModel);
        EmployeeDto fountEmp =  employeeService.findEmployeeByID(EMPID);
        List<EmployeeDto> empsDto = employeeService.getAllEmployees();
        System.out.println(fountEmp);
        List<EmployeeModel> emps =  empsDto.stream().map(e->modelMapper.map(e,EmployeeModel.class)).collect(Collectors.toList());
        model.addAttribute("empss",emps);
        model.addAttribute("employee_modal",employeeService.findEmployeeByID(EMPID));
        return "viewPage" ;
    }


    @GetMapping("/getUpdatePage/{id}")
    public String getUpdatePage(Model model,
                                  @PathVariable("id") long EMPID){
        //model.addAttribute("employee_modal", employeeModel);
        EmployeeDto fountEmp =  employeeService.findEmployeeByID(EMPID);
        List<EmployeeDto> empsDto = employeeService.getAllEmployees();
        System.out.println(fountEmp);
        List<EmployeeModel> emps =  empsDto.stream().map(e->modelMapper.map(e,EmployeeModel.class)).collect(Collectors.toList());
        model.addAttribute("empss",emps);
        model.addAttribute("employee_modal",employeeService.findEmployeeByID(EMPID));
        return "UpdateEmployee";
    }
}
