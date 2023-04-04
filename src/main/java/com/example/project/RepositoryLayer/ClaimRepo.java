package com.example.project.RepositoryLayer;

import com.example.project.ModelLayer.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClaimRepo  extends JpaRepository<Claim,Integer> {
}
