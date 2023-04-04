package com.example.project.ServiceLayer;
import com.example.project.DataTransferLayer.PolicyRequestDto;
import com.example.project.DataTransferLayer.PolicyUpdateDto;
import com.example.project.ModelLayer.Client;
import com.example.project.ModelLayer.Insurance_Policy;
import com.example.project.RepositoryLayer.ClaimRepo;
import com.example.project.RepositoryLayer.ClientRepo;
import com.example.project.RepositoryLayer.InsurancePolicyRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InsurancePolicySer {
    private final ClaimRepo claimRepository;
    private final ClientRepo clientRepository;
    private final InsurancePolicyRepo insurancePolicyRepository;

    public InsurancePolicySer(ClaimRepo claimRepository, ClientRepo  clientRepository, InsurancePolicyRepo insurancePolicyRepository) {
        this.claimRepository = claimRepository;
        this.clientRepository = clientRepository;
        this.insurancePolicyRepository = insurancePolicyRepository;
    }

    public List<Insurance_Policy> getAllPolicies() {
        return insurancePolicyRepository.findAll();
    }

    public Optional<Insurance_Policy> getPolicyById(Integer id) {
        return insurancePolicyRepository.findById(id);
    }

    public Insurance_Policy createPolicy(PolicyRequestDto policy) {
        Client client = clientRepository.findById(policy.getClientId()).get();

        Insurance_Policy insurancePolicy = Insurance_Policy.builder()
                .policyType(policy.getPolicyType())
                .policyNumber(policy.getPolicyNumber())
                .premium(policy.getPremium())
                .startDate(policy.getStartDate())
                .endDate(policy.getEndDate())
                .coverageAmount(policy.getCoverageAmount())
                .build();

        List<Insurance_Policy> insurancePolicies = client.getInsurancePolicies();
        insurancePolicies.add(insurancePolicy);
        client.setInsurancePolicies(insurancePolicies);
        clientRepository.save(client);

        insurancePolicyRepository.save(insurancePolicy);
        return  insurancePolicy;
    }

    public Insurance_Policy updatePolicy(Integer id, PolicyUpdateDto policyUpdateDto) {
        Insurance_Policy insurancePolicy = insurancePolicyRepository.findById(id).get();

        insurancePolicy.setPolicyNumber(policyUpdateDto.getPolicyNumber());
        insurancePolicy.setPolicyType(policyUpdateDto.getPolicyType());
        insurancePolicy.setCoverageAmount(policyUpdateDto.getCoverageAmount());
        insurancePolicy.setStartDate(policyUpdateDto.getStartDate());
        insurancePolicy.setEndDate(policyUpdateDto.getEndDate());
        insurancePolicy.setPremium(policyUpdateDto.getPremium());

        Client client = clientRepository.findById(insurancePolicy.getClient().getId()).get();
        List<Insurance_Policy> insurancePolicies =client.getInsurancePolicies();
        insurancePolicies.add(insurancePolicy);
        client.setInsurancePolicies(insurancePolicies);
        clientRepository.save(client);
        insurancePolicyRepository.save(insurancePolicy);
        return insurancePolicy;
    }

    public void deletePolicy(Integer id) {
        insurancePolicyRepository.deleteById(id);
    }
}
