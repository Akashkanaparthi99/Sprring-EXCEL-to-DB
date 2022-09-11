package com.employee.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author AkashKanaparthi
 * @Date - 27-05-2022
 * @Project - Buddy_Assignments
 * @Name Employee
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private Integer employeeId;

    private String firstName;

    private String lastName;

    private String emailId;

    private long mobile;

    private String city;

    private String state;

    private String role;

    private String department;


}
