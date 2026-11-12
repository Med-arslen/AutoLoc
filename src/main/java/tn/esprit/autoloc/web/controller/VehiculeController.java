package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;
@Tag(name = "Véhicule", description = "API pour gérer les véhicules")
@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicule add(@RequestBody Vehicule vehicule) {
        return vehiculeService.add(vehicule);
    }

    @PutMapping
    public Vehicule update(@RequestBody Vehicule vehicule) {
        return vehiculeService.update(vehicule);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        vehiculeService.delete(id);
    }

    @GetMapping("/{id}")
    public Vehicule getById(@PathVariable Long id) {
        return vehiculeService.getById(id);
    }

    @GetMapping
    public List<Vehicule> getAll() {
        return vehiculeService.getAll();
    }
}