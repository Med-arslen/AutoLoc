package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;
import java.util.List;

public interface IMaintenanceService {
    Maintenance add(Maintenance maintenance);
    Maintenance update(Maintenance maintenance);
    void delete(Long id);
    Maintenance getById(Long id);
    List<Maintenance> getAll();
}