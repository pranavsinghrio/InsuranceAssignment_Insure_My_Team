package com.example.project.ModelLayer;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name ="client")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String contactInformation;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Insurance_Policy> insurancePolicies = new ArrayList<>();

}