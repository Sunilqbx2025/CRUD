package com.example.ExpertsPro_CRUD_Task.ServiceImpl;


import com.example.ExpertsPro_CRUD_Task.Entity.Employee;
import com.example.ExpertsPro_CRUD_Task.Repository.EmployeeRepository;
import com.example.ExpertsPro_CRUD_Task.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee registerEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

//    public Employee updateEmployee(Long id, Employee employee){
//        Employee exsistingEmployee = employeeRepository.findById(id)
//                .orElseThrow(()->new RuntimeException("Employee Not found"));
//        exsistingEmployee.setEmployee_Name(employee.getEmployee_Name());
//        exsistingEmployee.setAddress(employee.getAddress());
//        exsistingEmployee.setDepartment(employee.getDepartment());
//        exsistingEmployee.setEmailId(employee.getEmailId());
//        return employeeRepository.save(exsistingEmployee);
//    }

    public Employee updateEmployee(Long id, Employee employee){
        Employee exsitingEmployee = employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not Found"));
        if(employee != null){
            if(employee.getEmployee_Name()!=null){
                exsitingEmployee.setEmployee_Name(employee.getEmployee_Name());
            }
            if(employee.getAddress()!=null){
                exsitingEmployee.setAddress(employee.getAddress());
            }
            return employeeRepository.save(exsitingEmployee);
        }
        return exsitingEmployee;
    }
}
