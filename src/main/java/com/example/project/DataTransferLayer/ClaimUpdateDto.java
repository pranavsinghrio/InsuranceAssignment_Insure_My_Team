package com.example.project.DataTransferLayer;

import com.example.project.EnumLayer.ClaimStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class ClaimUpdateDto {
    private String claimNumber;
    private String description;
    private LocalDate claimDate;
    private ClaimStatus claimStatus;
}