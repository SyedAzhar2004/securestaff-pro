package com.syedspring.springboot.Thymeleafdemo.controller;

import com.syedspring.springboot.Thymeleafdemo.entity.Employee;
import com.syedspring.springboot.Thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        // get the employees from the db
        List<Employee> theEmployees=employeeService.findAll();
        // add that to the spring model

        theModel.addAttribute("employees",theEmployees);

        return "/employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        Employee theEmployee=new Employee();

        theModel.addAttribute("employee",theEmployee);

        return "employees/employee-form";
    }

    // Used for both adding and updating an employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model theModel){

        Employee theEmployee=employeeService.findById(id);

        theModel.addAttribute("employee",theEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForDelete")
    public String showFormForDelete(@RequestParam("employeeId") int id){

        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }


}
