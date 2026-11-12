package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;
@Tag(name = "Maintenance", description = "API pour gérer les maintenances")
@RestController
@RequestMapping("/api/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Maintenance add(@RequestBody Maintenance maintenance) {
        return maintenanceService.add(maintenance);
    }

    @PutMapping
    public Maintenance update(@RequestBody Maintenance maintenance) {
        return maintenanceService.update(maintenance);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        maintenanceService.delete(id);
    }

    @GetMapping("/{id}")
    public Maintenance getById(@PathVariable Long id) {
        return maintenanceService.getById(id);
    }

    @GetMapping
    public List<Maintenance> getAll() {
        return maintenanceService.getAll();
    }
}