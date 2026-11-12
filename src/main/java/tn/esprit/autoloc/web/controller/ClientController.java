package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;
@Tag(name = "Client", description = "API pour gérer les clients")
@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client add(@RequestBody Client client) {
        return clientService.add(client);
    }

    @PutMapping
    public Client update(@RequestBody Client client) {
        return clientService.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id) {
        return clientService.getById(id);
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAll();
    }
}