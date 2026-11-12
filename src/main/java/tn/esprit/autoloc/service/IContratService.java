package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;
import java.util.List;

public interface IContratService {
    Contrat add(Contrat contrat);
    Contrat update(Contrat contrat);
    void delete(Long id);
    Contrat getById(Long id);
    List<Contrat> getAll();
}