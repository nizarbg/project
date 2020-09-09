package com.location.service;

import java.util.List;


import com.location.dao.ReservationDao;
import com.location.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ReservationServiceImpl implements ReservationService {

    ReservationDao reservationDao;

    @Autowired
    public void setReservationDao(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    public List listAllReservation() {
        return reservationDao.listAllReservation();
    }

    public void addReservation(Reservation reservation) {
        reservationDao.addReservation(reservation);
    }

    public void updateReservation(Reservation reservation) {
        reservationDao.updateReservation(reservation);
    }

    public void delete(Reservation reservation) {
        reservationDao.delete(reservation);
    }

    public Reservation findReservationById(Reservation reservation) {
        return reservationDao.findReservationById(reservation);
    }

}