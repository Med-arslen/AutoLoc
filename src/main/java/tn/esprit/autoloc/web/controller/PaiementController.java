package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;
@Tag(name = "Paiement", description = "API pour gérer les paiements")
@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final IPaiementService paiementService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paiement add(@RequestBody Paiement paiement) {
        return paiementService.add(paiement);
    }

    @PutMapping
    public Paiement update(@RequestBody Paiement paiement) {
        return paiementService.update(paiement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        paiementService.delete(id);
    }

    @GetMapping("/{id}")
    public Paiement getById(@PathVariable Long id) {
        return paiementService.getById(id);
    }

    @GetMapping
    public List<Paiement> getAll() {
        return paiementService.getAll();
    }
}