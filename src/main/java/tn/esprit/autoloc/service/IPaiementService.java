package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;
import java.util.List;

public interface IPaiementService {
    Paiement add(Paiement paiement);
    Paiement update(Paiement paiement);
    void delete(Long id);
    Paiement getById(Long id);
    List<Paiement> getAll();
}