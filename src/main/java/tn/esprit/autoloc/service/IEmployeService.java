package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;
import java.util.List;

public interface IEmployeService {
    Employe add(Employe employe);
    Employe update(Employe employe);
    void delete(Long id);
    Employe getById(Long id);
    List<Employe> getAll();
}