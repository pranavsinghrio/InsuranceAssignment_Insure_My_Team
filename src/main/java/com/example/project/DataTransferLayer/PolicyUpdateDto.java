package com.example.project.DataTransferLayer;

import com.example.project.EnumLayer.PolicyType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
public class PolicyUpdateDto {

    private String policyNumber;
    private PolicyType policyType;
    private BigDecimal coverageAmount;
    private BigDecimal premium;
    private LocalDate startDate;
    private LocalDate endDate;
}