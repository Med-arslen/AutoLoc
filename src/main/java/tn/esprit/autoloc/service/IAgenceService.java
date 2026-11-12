package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;
import java.util.List;

public interface IAgenceService {
    Agence add(Agence agence);
    Agence update(Agence agence);
    void delete(Long id);
    Agence getById(Long id);
    List<Agence> getAll();
}