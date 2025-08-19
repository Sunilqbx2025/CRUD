package com.example.ExpertsPro_CRUD_Task.Repository;

import com.example.ExpertsPro_CRUD_Task.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
