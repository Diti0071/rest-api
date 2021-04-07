package com.azurbo.task.repository;

import com.azurbo.task.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ardit on 4/1/2021
 * @project demo
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
