package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import java.util.List;

public interface IClientService {
    Client add(Client client);
    Client update(Client client);
    void delete(Long id);
    Client getById(Long id);
    List<Client> getAll();
}