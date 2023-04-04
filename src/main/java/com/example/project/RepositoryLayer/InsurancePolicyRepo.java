package com.example.project.RepositoryLayer;

import com.example.project.ModelLayer.Insurance_Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurancePolicyRepo extends JpaRepository<Insurance_Policy,Integer> {
}
