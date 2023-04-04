package com.example.project.ControllerLayer;
import com.example.project.DataTransferLayer.PolicyRequestDto;
import com.example.project.DataTransferLayer.PolicyUpdateDto;
import com.example.project.ModelLayer.Insurance_Policy;
import com.example.project.ServiceLayer.InsurancePolicySer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/policies")
public class InsurancePolicyCont {

    private final InsurancePolicySer insuranceService;

    public InsurancePolicyCont(InsurancePolicySer insuranceService) {
        this.insuranceService = insuranceService;
    }

    // 1. GET all insurance policies..............
    @GetMapping
    public List<Insurance_Policy> getAllPolicies() {
        return insuranceService.getAllPolicies();
    }

    // 2. GET  Fetch a specific insurance policy by ID...................
    @GetMapping("/{id}")
    public Optional<Insurance_Policy> getPolicyById(@PathVariable Integer id) {
        return insuranceService.getPolicyById(id);
    }

    // 3. POST  Create a new insurance policy....................
    @PostMapping
    public Insurance_Policy createPolicy(@RequestBody PolicyRequestDto policyDto) {
        return insuranceService.createPolicy(policyDto);
    }

    // 4. PUT  Update an insurance policy.........................
    @PutMapping("/{id}")
    public Insurance_Policy updatePolicy(@PathVariable Integer id, @RequestBody PolicyUpdateDto policy) {
        return insuranceService.updatePolicy(id, policy);
    }

    // 5. DELETE  Delete an insurance policy................
    @DeleteMapping("/{id}")
    public void deletePolicy(@PathVariable Integer id) {
        insuranceService.deletePolicy(id);
    }
}
