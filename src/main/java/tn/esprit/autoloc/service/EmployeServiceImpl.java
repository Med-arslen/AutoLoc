package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final EmployeRepository employeRepository;

    @Override
    public Employe add(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe update(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public void delete(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Employe getById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employé non trouvé"));
    }

    @Override
    public List<Employe> getAll() {
        return employeRepository.findAll();
    }
}