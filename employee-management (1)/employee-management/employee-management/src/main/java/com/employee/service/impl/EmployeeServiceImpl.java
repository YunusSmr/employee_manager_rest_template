package com.employee.service.impl;

import com.employee.exception.EmployeeAlreadyExistsException;
import com.employee.mapper.ModelMapperConfig;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.request.RequestEmployee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    private ModelMapperConfig modelMapper = new ModelMapperConfig();


    public EmployeeServiceImpl() {
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee saveEmployee(RequestEmployee request) {

        Employee Person = employeeRepository.findByTckn(request.getTckn());
        if (Person == null) {
            Employee savePerson = modelMapper.modelMapper().map(request, Employee.class);
            return employeeRepository.save(savePerson);
        } else {
            System.out.println("Employee is already exist");
            throw new EmployeeAlreadyExistsException("Something went wrong");

        }

    }

    @Override
    public Employee updateEmployee(RequestEmployee request) {
        Employee savePerson = modelMapper.modelMapper().map(request, Employee.class);
        return savePerson;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


}
