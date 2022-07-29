package com.fjl.mvc.controller;

import com.fjl.mvc.dao.EmployeeDAO;
import com.fjl.mvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;


    @GetMapping("/employee")
    public String getAllEmployee(Model model){
        Collection<Employee> employeeList = employeeDAO.getAll();
        model.addAttribute("employeeList",employeeList);
        return "employee_list";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeDAO.delete(id);
        return "redirect:/employee";
    }

    @GetMapping("/toAdd")
    public String toAdd(){
        return "add_employee";
    }

    @PutMapping("/employee")
    public String addOrUpdateEmployee(Employee employee){
        employeeDAO.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String toUpdate(@PathVariable Integer id,Model model){
        Employee employee = employeeDAO.get(id);
        model.addAttribute("employee",employee);
        return "update_employee";
    }

}
