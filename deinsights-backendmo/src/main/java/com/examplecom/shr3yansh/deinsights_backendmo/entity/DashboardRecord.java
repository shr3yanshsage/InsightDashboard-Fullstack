package com.examplecom.shr3yansh.deinsights_backendmo.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "dashboard_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Account number is required")
    private String accountNumber;

    @Min(value = 1, message = "Age must be greater than 0")
    private int age;

    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Product type is required")
    private String productType;

    @NotBlank(message = "State is required")
    private String states;

    @NotBlank(message = "Company size is required")
    private String sizeOfCompany;

    @Min(value = 0, message = "API calls cannot be negative")
    private int numberOfApiCalls;

}
