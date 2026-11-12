package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance add(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance update(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void delete(Long id) {
        maintenanceRepository.deleteById(id);
    }

    @Override
    public Maintenance getById(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Maintenance non trouvée"));
    }

    @Override
    public List<Maintenance> getAll() {
        return maintenanceRepository.findAll();
    }
}