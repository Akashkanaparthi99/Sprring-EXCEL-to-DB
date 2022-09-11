package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.IEmployeeService;
import com.employee.utility.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author AkashKanaparthi
 * @Date - 27-05-2022
 * @Project - Buddy_Assignments
 * @name - EmployeeController
 */
@RestController
@RequestMapping("/employee-api")
public class EmployeeController {
    private IEmployeeService employeeService;
    @Autowired
    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * post method take's the file and adds to the database
     * @param file
     * @return response entity message
     */
    @PostMapping("/employees")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file){
        if (ExcelHelper.checkExcelFormat(file)){

            employeeService.save(file);

            return ResponseEntity.ok(Map.of("message","File has successfully uploaded and data is saved to database"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file only..!");
    }

    /**
     * get method gets all the employees in the database
     * @return list of employees
     */
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}
