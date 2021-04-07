package com.azurbo.task.controller;

import com.azurbo.task.service.EmployeeService;
import com.azurbo.task.exception.ResourceNotFoundException;
import com.azurbo.task.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ardit on 4/1/2021
 * @project demo
 */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    //Get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    //Create employee
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employeeDetails) {
        return service.createEmployee(employeeDetails);
    }

    //Get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") long employeeId) throws ResourceNotFoundException {
        Employee employee = service.getEmployeeById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    //Update employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") long employeeId, @Valid @RequestBody Employee employeeDetails){
        employeeDetails.setId(employeeId);
        Employee employee = service.updateEmployee(employeeDetails);
        return ResponseEntity.ok().body(employee);
    }

    //Delete employee
    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") long employeeId) throws ResourceNotFoundException {
        service.getEmployeeById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id: " + employeeId));
        service.deleteEmployeeById(employeeId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
