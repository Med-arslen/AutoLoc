package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;
@Tag(name = "Équipement", description = "API pour gérer les équipements")
@RestController
@RequestMapping("/api/equipements")
@RequiredArgsConstructor
public class EquipementController {

    private final IEquipementService equipementService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipement add(@RequestBody Equipement equipement) {
        return equipementService.add(equipement);
    }

    @PutMapping
    public Equipement update(@RequestBody Equipement equipement) {
        return equipementService.update(equipement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        equipementService.delete(id);
    }

    @GetMapping("/{id}")
    public Equipement getById(@PathVariable Long id) {
        return equipementService.getById(id);
    }

    @GetMapping
    public List<Equipement> getAll() {
        return equipementService.getAll();
    }
}