package com.employee.model;

import com.employee.request.RequestEmployee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "mt_employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private long id;
    @Size(min = 1, max = 30, message = "First name cannot be longer than 60 characters")
    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "tckn")
    private String tckn;
    @Column(name = "salary")
    private BigInteger salary;
    @Column(name = "gender")
    private String gender;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "adress")
    private String address;

    public Employee(RequestEmployee request) {
        this.name = request.getName();
        this.gender = request.getGender();

    }


}
