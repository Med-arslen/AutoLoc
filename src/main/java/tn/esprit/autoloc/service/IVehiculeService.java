package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;
import java.util.List;

public interface IVehiculeService {
    Vehicule add(Vehicule vehicule);
    Vehicule update(Vehicule vehicule);
    void delete(Long id);
    Vehicule getById(Long id);
    List<Vehicule> getAll();
}