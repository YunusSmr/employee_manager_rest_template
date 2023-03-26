package com.employee.exception;

import com.employee.request.RequestEmployee;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@NoArgsConstructor
public class EmployeeExceptionHandler extends ExceptionResponse {

    @ExceptionHandler(Exception.class)
    public @ResponseBody ExceptionResponse handleException(RequestEmployee employee) {
        ExceptionResponse error = new ExceptionResponse();
        Logger logger = LoggerFactory.getLogger(error.toString());
        error.setErrorMessage(employee.getName() + "couldn't added");
        return error;
    }
}

