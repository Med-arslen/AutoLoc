package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;
@Tag(name = "Contrat", description = "API pour gérer les contrats")
@RestController
@RequestMapping("/api/contrats")
@RequiredArgsConstructor
public class ContratController {

    private final IContratService contratService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contrat add(@RequestBody Contrat contrat) {
        return contratService.add(contrat);
    }

    @PutMapping
    public Contrat update(@RequestBody Contrat contrat) {
        return contratService.update(contrat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        contratService.delete(id);
    }

    @GetMapping("/{id}")
    public Contrat getById(@PathVariable Long id) {
        return contratService.getById(id);
    }

    @GetMapping
    public List<Contrat> getAll() {
        return contratService.getAll();
    }
}