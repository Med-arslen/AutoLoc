package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;
import java.util.List;

public interface IReservationService {
    Reservation add(Reservation reservation);
    Reservation update(Reservation reservation);
    void delete(Long id);
    Reservation getById(Long id);
    List<Reservation> getAll();
}