package com.example.project.ModelLayer;


import com.example.project.EnumLayer.PolicyType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name ="policy")
@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Insurance_Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String policyNumber;

    @Enumerated(EnumType.STRING)
    private PolicyType policyType;

    private BigDecimal coverageAmount;
    private BigDecimal premium;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private  Client client;

    @OneToMany(mappedBy = "insurancePolicy", cascade = CascadeType.ALL)
    private List<Claim> claimList =new ArrayList<>();
}
