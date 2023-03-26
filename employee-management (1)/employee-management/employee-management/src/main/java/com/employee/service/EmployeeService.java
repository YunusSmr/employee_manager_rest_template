package com.employee.service;

import com.employee.model.Employee;
import com.employee.request.RequestEmployee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployee();

    Employee findById(Long id);


    /*
     change the return type
     exception handling
     learn the shortcuts
     the rules of names
    */
    Employee saveEmployee(RequestEmployee request);

    Employee updateEmployee(RequestEmployee employee);

    void deleteEmployee(Long id);

}
