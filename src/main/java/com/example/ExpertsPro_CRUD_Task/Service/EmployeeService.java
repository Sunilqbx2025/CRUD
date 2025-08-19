package com.example.ExpertsPro_CRUD_Task.Service;


import com.example.ExpertsPro_CRUD_Task.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee registerEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Long id, Employee employee);
}
