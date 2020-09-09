package com.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.location.model.Reservation;

import com.location.service.ReservationService;

@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @RequestMapping(value="/user/reservation/", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<List<Reservation>> listAlLReservation(){
        List<Reservation> list = reservationService.listAllReservation();

        if(list.size() == 0){
            return new ResponseEntity<List<Reservation>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Reservation>>(list, HttpStatus.OK);
    }

    @RequestMapping(value="/add/reservation/", method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<Void> add(@RequestBody Reservation reservation){
        reservationService.addReservation(reservation);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/reservation/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Reservation reservation){
        reservation.setId(id);
        reservationService.updateReservation(reservation);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/reservation/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Reservation reservation){
        reservation.setId(id);
        reservationService.delete(reservation);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}