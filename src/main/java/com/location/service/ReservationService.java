package com.location.service;

import com.location.model.Reservation;

import java.util.List;

public interface ReservationService {
    public List listAllReservation();

    public void addReservation(Reservation reserv);

    public void updateReservation(Reservation reserv);

    public void delete(Reservation reserv);

    public Reservation findReservationById(Reservation reserv);
}
