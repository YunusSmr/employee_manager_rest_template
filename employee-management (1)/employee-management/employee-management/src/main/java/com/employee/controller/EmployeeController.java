package com.employee.controller;

import com.employee.dto.EmployeeDto;
import com.employee.mapper.ModelMapperConfig;
import com.employee.request.RequestEmployee;
import com.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private ModelMapperConfig modelMapper = new ModelMapperConfig();


    @GetMapping("/all")
    public List<EmployeeDto> findAllEmployee() {
        if (!employeeService.findAllEmployee().isEmpty()) {
            List<EmployeeDto> returnList = employeeService.findAllEmployee().stream()
                    .map(user -> modelMapper.modelMapper().map(employeeService.findAllEmployee(), EmployeeDto.class)).collect(Collectors.toList());
            return returnList;

        } else {

            try {
                throw new Exception("there are no any Employee");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    }

    @GetMapping("/{id}")
    public EmployeeDto findEmployeeById(@PathVariable("id") Long id) {

        EmployeeDto employeeById = modelMapper.modelMapper().map(employeeService.findById(id), EmployeeDto.class);

        return employeeById;

    }


    @PostMapping(value = "/add")
    public EmployeeDto addEmployee(@RequestBody @Valid @NotNull RequestEmployee request) {

        EmployeeDto dto = modelMapper.modelMapper().map(employeeService.saveEmployee(request), EmployeeDto.class);
        return dto;
    }

    @PutMapping(value = "/update")
    public EmployeeDto updateEmployee(@RequestBody @Valid RequestEmployee employee) {
        EmployeeDto dto = modelMapper.modelMapper().map(employeeService.saveEmployee(employee), EmployeeDto.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
    }
}