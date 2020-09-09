package com.location.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.dao.PieceDao;
import com.location.model.Piece;

@Service
public class PieceServiceImpl implements PieceService {

    PieceDao pieceDao;

    @Autowired
    public void setPieceDao(PieceDao pieceDao) {
        this.pieceDao = pieceDao;
    }

    public List listAllPiece() {
        return pieceDao.listAllPiece();
    }

    public void addPiece(Piece piece) {
        pieceDao.addPiece(piece);
    }

    public void updatePiece(Piece piece) {
        pieceDao.updatePiece(piece);
    }

    public void delete(Piece piece) {
        pieceDao.delete(piece);
    }

    public Piece findPieceById(Piece piece) {
        return pieceDao.findPieceById(piece);
    }

}