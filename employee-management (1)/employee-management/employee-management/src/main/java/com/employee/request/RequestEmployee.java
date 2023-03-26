package com.employee.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestEmployee {

    private String name;
    @NotNull
    private String tckn;
    private String gender;
    private Date dateOfBirth;
    @Size(max = 100)
    private String address;
    private BigInteger salary;


}
