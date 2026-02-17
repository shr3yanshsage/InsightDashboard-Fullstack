package com.examplecom.shr3yansh.deinsights_backendmo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardDTO {

    private String accountNumber;
    private int age;
    private String companyName;
    private String productType;
    private String states;
    private String sizeOfCompany;
    private int numberOfApiCalls;
}
