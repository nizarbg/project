package com.location.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.location.model.Piece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;





@Repository
public class PieceDaoImpl  implements PieceDao{

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List listAllPiece() {
        List list = new ArrayList();

        String sql = "SELECT * From Piece WHERE date_supp=NULL";

        list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new PieceMapper());

        return list;
    }


    private SqlParameterSource getSqlParameterByModel(Piece p){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if(p != null){
            parameterSource.addValue("id", p.getId());
            parameterSource.addValue("id_voiture", p.getId_Voiture());
            parameterSource.addValue("id_employe", p.getId_Employe());
            parameterSource.addValue("reference", p.getreference());
            parameterSource.addValue("nom", p.getnom());
            parameterSource.addValue("marque", p.getmarque());
            parameterSource.addValue("prix", p.getprix());
            parameterSource.addValue("date_achat", p.getdateAchat());
            parameterSource.addValue("date_ajout", p.getdateAjout());
            parameterSource.addValue("date_miseajour", p.getdateMiseajour());
            parameterSource.addValue("date_supp", p.getdateSupp());




        }
        return parameterSource;
    }

    private static final class PieceMapper implements RowMapper{

        public Piece mapRow(ResultSet rs, int rowNum) throws SQLException {
            Piece p = new Piece();
            p.setId(rs.getInt("id"));
            p.setId_Voiture(rs.getInt("id_voiture"));
            p.setId_Employe(rs.getInt("id_employe"));
            p.setreference(rs.getString("reference"));
            p.setnom(rs.getString("nom"));
            p.setmarque(rs.getString("marque"));
            p.setprix(rs.getFloat("float"));
            p.setdateAchat(rs.getDate("date_achat"));
            p.setdateAjout(rs.getDate("date_ajout"));
            p.setdateMiseajour(rs.getDate("date_miseajour"));
            p.setdateSupp(rs.getDate("date_supp"));





            return p;
        }

    }

    public void addPiece(Piece p) {
        String sql = "INSERT INTO Piece( id_voiture, id_employe, reference, nom, marque, float, date_achat, date_ajout, date_miseajour, date_supp) VALUES( :id_voiture, :id_employe, :reference, :nom, :marque, :float, :date_achat, NOW(), NULL, NULL)";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(p));
    }

    public void updatePiece(Piece p) {
        String sql = "UPDATE Piece SET  id_voiture=:id_voiture, id_employe=:id_employe, reference=:reference, nom=:nom, marque=:marque, float=:float, date_achat=:date_achat, date_miseajour=NOW(), WHERE id =:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(p));
    }

    public void delete(Piece p) {
        String sql = "UPDATE Piece SET date_supp=NOW() WHERE id=:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(p));
    }

    public Piece findPieceById(Piece p) {
        String sql = "SELECT * FROM Piece WHERE id =:id";

        return (Piece) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(p), new PieceMapper());
    }

}