package com.employee.repository;

import com.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author AkashKanaparthi
 * @Date - 27-05-2022
 * @Project - Buddy_Assignments
 * @name - IEmployeeRepository
 */
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
