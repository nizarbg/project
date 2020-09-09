package com.location.service;

import com.location.model.Piece;

import java.util.List;

public interface PieceService {
    public List listAllPiece();

    public void addPiece(Piece p);

    public void updatePiece(Piece p);

    public void delete(Piece p);

    public Piece findPieceById(Piece p);
}
