package com.example.project.ControllerLayer;
import com.example.project.ModelLayer.Client;
import com.example.project.ServiceLayer.ClientSer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/clients")
public class ClientCont {
    private final ClientSer clientService;

    public ClientCont(ClientSer clientService) {
        this.clientService = clientService;
    }

    // 1. GET Fetch all clients........................
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // 2. GET  Fetch a specific client by ID.....................
    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }

    // 3. POST  Create a new client................
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    // 4. PUT  Update a client's information...............
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Integer id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    // 5.  Delete a client...............
    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Integer id) {
        return clientService.deleteClient(id);
    }
}
