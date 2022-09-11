package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.IEmployeeRepository;
import com.employee.utility.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author AkashKanaparthi
 * @Date - 27-05-2022
 * @Project - Buddy_Assignments
 * @name - EmployeeServiceImpl
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService{

    private IEmployeeRepository employeeRepository;
    @Autowired
    public void setEmployeeRepository(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * save's all the file to database from the Excel file
     * @param file
     */
    @Override
    public void save(MultipartFile file) {

        try {
            List<Employee> employees = ExcelHelper.convertExcelToList(file.getInputStream());
            employeeRepository.saveAll(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * To get all the employees from database
     * @return list of employees
     */
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
