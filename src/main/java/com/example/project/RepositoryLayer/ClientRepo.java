package com.example.project.RepositoryLayer;

import com.example.project.ModelLayer.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo  extends JpaRepository<Client,Integer> {
}
