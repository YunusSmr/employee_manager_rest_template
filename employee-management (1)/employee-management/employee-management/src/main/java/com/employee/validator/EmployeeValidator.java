package com.employee.validator;

import com.employee.request.RequestEmployee;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EmployeeValidator {

    public static void validateEmployee(RequestEmployee request) throws Exception {
        if (request == null)
            throw new Exception("E_REQ_NULL");
    }


}
