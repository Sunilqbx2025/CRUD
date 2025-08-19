package com.example.ExpertsPro_CRUD_Task.Controller;

import com.example.ExpertsPro_CRUD_Task.Entity.Employee;
import com.example.ExpertsPro_CRUD_Task.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public Employee registerEmployee(@Valid @RequestBody Employee employee){
        return employeeService.registerEmployee(employee);
    }

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getEmployeeById/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(id,employee);
        return ResponseEntity.ok(updateEmployee);
    }
}
