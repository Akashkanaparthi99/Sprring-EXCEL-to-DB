package com.employee.service;

import com.employee.model.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author AkashKanaparthi
 * @Date - 27-05-2022
 * @Project - Buddy_Assignments
 * @name - IEmployeeService
 */
public interface IEmployeeService {

    void save(MultipartFile file);
    List<Employee> getAllEmployees();
}
