package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;
import java.util.List;

public interface IEquipementService {
    Equipement add(Equipement equipement);
    Equipement update(Equipement equipement);
    void delete(Long id);
    Equipement getById(Long id);
    List<Equipement> getAll();
}