package com.example.ExpertsPro_CRUD_Task.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "employee_details")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_Id;
    private String employee_Name;
    private String department;

    @NotNull
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[#?!])[A-Za-z0-9#?!]{8,}$\n"
    )
    @Column(unique = true)
    private String emailId;

    @NotNull
    @Pattern(
            regexp ="^[6-9]\\d{9}$"
    )
    @Column(unique = true, length = 10)
    private String mobileNo;
    private String address;
    private String userName;
    private String password;
}
