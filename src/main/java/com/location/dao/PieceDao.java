package com.location.dao;

import com.location.model.Piece;

import java.util.List;

public interface PieceDao {
    public List listAllPiece();

    public void addPiece(Piece p);

    public void updatePiece(Piece p);

    public void delete(Piece p);

    public Piece findPieceById(Piece p);
}
