package com.example.project.ModelLayer;

import com.example.project.EnumLayer.ClaimStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name ="claim")
@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String claimNumber;

    private String description;
    private LocalDate claimDate;

    @Enumerated(EnumType.STRING)
    private ClaimStatus claimStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id")
    private Insurance_Policy insurancePolicy;
}