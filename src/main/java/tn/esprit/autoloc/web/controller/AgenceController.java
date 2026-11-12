package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;
@Tag(name = "Agence", description = "API pour gérer les agences")
@RestController
@RequestMapping("/api/agences")
@RequiredArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agence add(@RequestBody Agence agence) {
        return agenceService.add(agence);
    }

    @PutMapping
    public Agence update(@RequestBody Agence agence) {
        return agenceService.update(agence);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        agenceService.delete(id);
    }

    @GetMapping("/{id}")
    public Agence getById(@PathVariable Long id) {
        return agenceService.getById(id);
    }

    @GetMapping
    public List<Agence> getAll() {
        return agenceService.getAll();
    }
}