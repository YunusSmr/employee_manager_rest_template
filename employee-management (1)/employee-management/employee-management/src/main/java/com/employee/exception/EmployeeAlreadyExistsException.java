package com.employee.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAlreadyExistsException extends RuntimeException {
    private String message;


}
