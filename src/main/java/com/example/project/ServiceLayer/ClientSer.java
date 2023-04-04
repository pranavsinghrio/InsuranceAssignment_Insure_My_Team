package com.example.project.ServiceLayer;
import com.example.project.ModelLayer.Client;
import com.example.project.RepositoryLayer.ClaimRepo;
import com.example.project.RepositoryLayer.ClientRepo;
import com.example.project.RepositoryLayer.InsurancePolicyRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientSer {
    private final ClaimRepo claimRepository;
    private final ClientRepo clientRepository;
    private final InsurancePolicyRepo insurancePolicyRepository;

    public ClientSer (ClaimRepo claimRepository, ClientRepo clientRepository, InsurancePolicyRepo insurancePolicyRepository) {
        this.claimRepository = claimRepository;
        this.clientRepository = clientRepository;
        this.insurancePolicyRepository = insurancePolicyRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Integer id) {

        try {
            return clientRepository.findById(id);
        }catch (Exception e)
        {
            throw new RuntimeException("Failed to find client by ID: " + id, e);
        }
    }

    public Client createClient(Client client) {

        Client newClient = Client.builder()
                .name(client.getName())
                .address(client.getAddress())
                .dateOfBirth(client.getDateOfBirth())
                .contactInformation(client.getContactInformation())
                .build();
        clientRepository.save(newClient);

        return newClient;
    }

    public Client updateClient(Integer id, Client clientDto) {

        Client client = clientRepository.findById(id).orElseThrow();

        client.setName(clientDto.getName());
        client.setAddress(client.getAddress());
        client.setContactInformation(client.getContactInformation());
        client.setDateOfBirth(clientDto.getDateOfBirth());
        clientRepository.save(client);

        return  client;
    }

    public String deleteClient(Integer id) {
        clientRepository.findById(id).orElseThrow();
        clientRepository.deleteById(id);

        return "Client successfully deleted";
    }
}
