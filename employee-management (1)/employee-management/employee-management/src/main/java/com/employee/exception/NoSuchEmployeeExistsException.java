package com.employee.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NoSuchEmployeeExistsException extends RuntimeException {
    private String message;

    public NoSuchEmployeeExistsException() {
    }

    public NoSuchEmployeeExistsException(String msg) {
        super(msg);
        this.message = msg;
    }

}
