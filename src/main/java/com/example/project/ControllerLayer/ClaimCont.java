package com.example.project.ControllerLayer;
import com.example.project.DataTransferLayer.ClaimDto;
import com.example.project.DataTransferLayer.ClaimUpdateDto;
import com.example.project.ModelLayer.Claim;
import com.example.project.RepositoryLayer.ClaimRepo;
import com.example.project.ServiceLayer.ClaimSer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "/api/claims")
public class ClaimCont {
    private final ClaimSer claimService;
    private final ClaimRepo claimRepository;

    public ClaimCont(ClaimSer claimService, ClaimRepo claimRepository) {
        this.claimService = claimService;
        this.claimRepository = claimRepository;
    }

    // 1. GET  Fetch all claims.................
    @GetMapping
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    // 2. GET  Fetch a specific claim by ID.......................
    @GetMapping("/{id}")
    public Optional<Claim> getClaimById(@PathVariable Integer id) {
        return claimService.findById(id);
    }

    // 3. POST  Create a new claim.................
    @PostMapping
    public Claim createClaim(@RequestBody ClaimDto claimDto) {
        return claimService.createClaim(claimDto);
    }

    // 4.  Update a claim information......................
    @PutMapping("/{id}")
    public String updateClaim(@PathVariable Integer id, @RequestBody ClaimUpdateDto updatedClaim) {
        claimService.updateClaim(id, updatedClaim);
        return "Claim Upadated";
    }

    // 5. : Delete a claim....................
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClaim(@PathVariable Integer id) {
        return claimService.deleteClaim(id);
    }
}
