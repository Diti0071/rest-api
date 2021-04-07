package com.azurbo.task.service;

import com.azurbo.task.model.Department;
import com.azurbo.task.model.Employee;
import com.azurbo.task.repository.DepartmentRepository;
import com.azurbo.task.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Ardit on 4/6/2021
 * @project demo
 */

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long employeeId){
        return employeeRepository.findById(employeeId);
    }

    public Employee updateEmployee(Employee employeeDetails){
        employeeRepository.save(employeeDetails);
        return employeeDetails;
    }

    public void deleteEmployeeById(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }


    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> getDepartmentById(Long departmentId){
        return departmentRepository.findById(departmentId);
    }

    public void updateDepartment(Department departmentDetails){
        departmentRepository.save(departmentDetails);
    }

    public void deleteDepartmentById(Long departmentId){
        departmentRepository.deleteById(departmentId);
    }
}
