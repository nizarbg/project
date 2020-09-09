package com.location.dao;

import com.location.model.Reservation;

import java.util.List;

public interface ReservationDao {
    public List listAllReservation();

    public void addReservation(Reservation reserv);

    public void updateReservation(Reservation reserv);

    public void delete(Reservation reserv);

    public Reservation findReservationById(Reservation reserv);
}
