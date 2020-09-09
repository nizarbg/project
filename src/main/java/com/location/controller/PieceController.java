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
import com.location.model.Piece;

import com.location.service.PieceService;

@RestController
public class PieceController {

    @Autowired
    PieceService pieceService;

    @RequestMapping(value="/user/piece/", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<List<Piece>> listAllPiece(){
        List<Piece> list = pieceService.listAllPiece();

        if(list.size() == 0){
            return new ResponseEntity<List<Piece>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Piece>>(list, HttpStatus.OK);
    }

    @RequestMapping(value="/add/piece/", method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<Void> add(@RequestBody Piece piece){
        pieceService.addPiece(piece);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/piece/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Piece piece){
        piece.setId(id);
        pieceService.updatePiece(piece);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/piece/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Piece piece){
        piece.setId(id);
        pieceService.delete(piece);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}