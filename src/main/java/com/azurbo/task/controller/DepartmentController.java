package com.azurbo.task.controller;

import com.azurbo.task.service.EmployeeService;
import com.azurbo.task.exception.ResourceNotFoundException;
import com.azurbo.task.model.Department;
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
public class DepartmentController {

    @Autowired
    private EmployeeService service;

    //Get all departments
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
    }

    //Create department
    @PostMapping("/departments")
    public Department createDepartment(@Valid @RequestBody Department entity) {
        return service.createDepartment(entity);
    }

    //Get department by id
    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        Department department = service.getDepartmentById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found for this id: " + id));
        return ResponseEntity.ok().body(department);
    }

    //Update department
    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable(value = "id") long id, @Valid @RequestBody Department department){
        department.setId(id);
        service.updateDepartment(department);
        return ResponseEntity.ok().body(department);
    }

    //Delete department
    @DeleteMapping("/departments/{id}")
    public Map<String, Boolean> deleteDepartmentById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        service.getDepartmentById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found for this id: " + id));
        service.deleteDepartmentById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}