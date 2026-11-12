package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;
@Tag(name = "Employe", description = "API pour gérer les employés")
@RestController
@RequestMapping("/api/employes")
@RequiredArgsConstructor
public class EmployeController {

    private final IEmployeService employeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employe add(@RequestBody Employe employe) {
        return employeService.add(employe);
    }

    @PutMapping
    public Employe update(@RequestBody Employe employe) {
        return employeService.update(employe);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        employeService.delete(id);
    }

    @GetMapping("/{id}")
    public Employe getById(@PathVariable Long id) {
        return employeService.getById(id);
    }

    @GetMapping
    public List<Employe> getAll() {
        return employeService.getAll();
    }
}