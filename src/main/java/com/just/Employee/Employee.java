package com.just.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Employee {
    ///data feilds
    private long id;
    private String name,position;
    private BigDecimal salary;

}
