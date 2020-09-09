package com.location.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.location.model.Entretient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class EntretientDaoImpl  implements EntretientDao{

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List listAllEntretient() {
        List list = new ArrayList();

        String sql = "SELECT * From Entretient WHERE date_supp=NULL";

        list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new EntretientMapper());

        return list;
    }

    private SqlParameterSource getSqlParameterByModel(Entretient ent){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if(ent != null){
            parameterSource.addValue("id", ent.getId());
            parameterSource.addValue("id_voiture", ent.getId_Voiture());
            parameterSource.addValue("id_employe", ent.getId_Employe());
            parameterSource.addValue("nom", ent.getnom());
            parameterSource.addValue("type_entretient", ent.gettype_entretient());
            parameterSource.addValue("dateentre", ent.getdateEntre());
            parameterSource.addValue("datesortie", ent.getdateSortie());
            parameterSource.addValue("dateajout", ent.getdateAjout());
            parameterSource.addValue("dateMiseajour", ent.getdateMiseajour());
            parameterSource.addValue("dateSupp", ent.getdateSupp());

        }
        return parameterSource;
    }

    private static final class EntretientMapper implements RowMapper{

        public Entretient mapRow(ResultSet rs, int rowNum) throws SQLException {
            Entretient ent= new Entretient();
            ent.setId(rs.getInt("id"));
            ent.setId_Voiture(rs.getInt("id_voiture"));
            ent.setId_Employe(rs.getInt("id_employe"));
            ent.setnom(rs.getString("nom"));
            ent.settype_entretient(rs.getString("type_entretient"));
            ent.setdateEntre(rs.getDate("dateentre"));
            ent.setdateSortie(rs.getDate("datesortie"));
            ent.setdateAjout(rs.getDate("dateAjout"));
            ent.setdateMiseajour(rs.getDate("dateMiseajour"));
            ent.setdateSupp(rs.getDate("dateSupp"));




            return ent;
        }

    }

    public void addEntretient(Entretient ent) {
        String sql = "INSERT INTO Entretient(id_voiture, id_employe, nom, type_entretient,dateentree, datesortie, dateAjout, dateMiseajour, dateSupp) VALUES(:id_voiture, :id_employe, :nom, :type_entretient, :dateentree, :datesortie, NOW(), NULL, NULL)";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(ent));
    }

    public void updateEntretient(Entretient ent) {
        String sql = "UPDATE Entretient SET id_voiture=:id_voiture, id_employe=:id_employe, nom=:nom, type_entretient=:type_entretient,dateentree=:dateentree, datesortie=:datesortie, dateMiseajour=NOW, WHERE id =:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(ent));
    }

    public void delete(Entretient ent) {
        String sql = "UPDATE  Entretient SET date_supp=NOW() WHERE id=:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(ent));
    }

    public Entretient findEntretientById(Entretient ent) {
        String sql = "SELECT * FROM Entretient WHERE id =:id";

        return (Entretient) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(ent), new EntretientMapper());
    }

}
