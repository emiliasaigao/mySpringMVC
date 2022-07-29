package com.fjl.ssm.service;

import com.fjl.ssm.pojo.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    void deletEmployeeById(Integer id);
    void updateOrAddEmployeeInfo(Employee employee);

    Employee getEemployeeById(Integer id);

    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
