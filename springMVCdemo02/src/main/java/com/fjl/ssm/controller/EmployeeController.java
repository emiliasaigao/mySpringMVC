package com.fjl.ssm.controller;

import com.fjl.ssm.pojo.Employee;
import com.fjl.ssm.service.EmployeeService;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public String getEmployeeList(Model model){
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("employeeList",employeeList);
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "employee_list";
    }

    @GetMapping("employee/page/{pageNum}")
    public String getEmployeePage(Model model,@PathVariable Integer pageNum){
        PageInfo<Employee> employeePage = employeeService.getEmployeePage(pageNum);
        model.addAttribute("employeePage",employeePage);
        return "employee_list";
    }

    @GetMapping("/employee/{id}")
    public String getEmployeeById(Model model,@PathVariable Integer id){
        Employee employee = employeeService.getEemployeeById(id);
        model.addAttribute("employee",employee);
        return "edit_employee";
    }


    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable Integer id){
        employeeService.deletEmployeeById(id);
        return "redirect:/employee/page/1";
    }

    @GetMapping("/toAdd")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "edit_employee";
    }

    @PutMapping("/employee")
    public String editEmployee(Employee employee){
        employeeService.updateOrAddEmployeeInfo(employee);
        return "redirect:/employee/page/1";
    }
}
