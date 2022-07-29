package com.fjl.ssm.service.impl;

import com.fjl.ssm.mapper.EmployeeMapper;
import com.fjl.ssm.pojo.Employee;
import com.fjl.ssm.pojo.EmployeeExample;
import com.fjl.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {

        List<Employee> employees = employeeMapper.selectByExample(null);
        return employees;
    }

    @Override
    public void deletEmployeeById(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateOrAddEmployeeInfo(Employee employee) {
        Employee employeeById = getEemployeeById(employee.getEmpId());
        if (employeeById!=null){
            employeeMapper.updateByPrimaryKey(employee);
        }else {
            employeeMapper.insert(employee);
        }
    }

    @Override
    public Employee getEemployeeById(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        PageHelper.startPage(pageNum,4);
        List<Employee> employeeList = getAllEmployee();
        PageInfo<Employee> employeePageInfo = new PageInfo<>(employeeList, 5);
        return employeePageInfo;
    }


}
