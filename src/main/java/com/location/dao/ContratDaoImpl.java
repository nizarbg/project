package com.location.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.location.model.Contrat;

@Repository
public class ContratDaoImpl  implements ContratDao{

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List listAllContrat() {
        List list = new ArrayList();

        String sql = "SELECT * From Contrat WHERE date_supp=NULL";

        list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new ContratMapper());

        return list;
    }

    private SqlParameterSource getSqlParameterByModel(Contrat cont){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if(cont != null){
            parameterSource.addValue("id", cont.getId());
            parameterSource.addValue("id_reservation", cont.getId_Reservation());
            parameterSource.addValue("numContrat", cont.getnumContrat());
            parameterSource.addValue("prixHt", cont.getprixHt());
            parameterSource.addValue("tva", cont.gettva());
            parameterSource.addValue("prixTT", cont.getprixTT());
            parameterSource.addValue("modePaiement", cont.getmodePaiement());
            parameterSource.addValue("acompte", cont.getacompte());
            parameterSource.addValue("caution", cont.getcaution());
            parameterSource.addValue("dureeRetard", cont.getdureeRetard());
            parameterSource.addValue("dateSignature", cont.getdateSignature());
            parameterSource.addValue("penaliteJour", cont.getpenaliteJour());
            parameterSource.addValue("getdateAjout", cont.getdateAjout());
            parameterSource.addValue("dateMiseajour", cont.getdateMiseajour());
            parameterSource.addValue("dateSupp", cont.getdateSupp());
        }
        return parameterSource;
    }

    private static final class ContratMapper implements RowMapper{

        public Contrat mapRow(ResultSet rs, int rowNum) throws SQLException {
            Contrat cont = new Contrat();
            cont.setId(rs.getInt("id"));
            cont.setId_Reservation(rs.getInt("id_reservation"));
            cont.setnumContrat(rs.getInt("numContrat"));
            cont.setprixHt(rs.getFloat("prixHt"));
            cont.settva(rs.getFloat("tva"));
            cont.setprixTT(rs.getFloat("prixTT"));
            cont.setmodePaiement(rs.getString("modePaiement"));
            cont.setacompte(rs.getFloat("acompte"));
            cont.setcaution(rs.getInt("caution"));
            cont.setdureeRetard(rs.getInt("dureeRetard"));
            cont.setdateSignature(rs.getDate("dateSignature"));
            cont.setpenaliteJour(rs.getFloat("penaliteJour"));
            cont.setdateAjout(rs.getDate("dateAjout"));
            cont.setdateMiseajour(rs.getDate("dateMiseajour"));
            cont.setdateSupp(rs.getDate("dateSupp"));


            return cont;
        }

    }

    public void addContrat(Contrat cont) {
        String sql = "INSERT INTO Contrat(id_reservation, numContrat, prixHt, tva, prixTT, modePaiement, acompte, caution, dureeRetard, dateSignature, penaliteJour, dateAjout, dateMiseajour, dateSupp) VALUES(:id_reservation, :numContrat, :prixHt, :tva, :prixTT, :modePaiement, :acompte, :caution, :dureeRetard, :dateSignature, :penaliteJour, NOW(), NULL, NULL)";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(cont));
    }

    public void updateContrat(Contrat cont) {
        String sql = "UPDATE Contrat SET id_reservation=:id_reservation, numContrat=:numContrat, prixHt=:prixHt, tva=:tva, prixTT=:prixHt, modePaiement=:modePaiement, acompte=:acompte, caution=:caution, dureeRetard=:dureeRetard, dateSignature=:dateSignature, penaliteJour=:penaliteJour, dateMiseajour=NOW(), WHERE id =:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(cont));
    }

    public void delete(Contrat cont) {
        String sql = "UPDATE CONTRAT SET date_supp=NOW() WHERE id=:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(cont));
    }

    public Contrat findContratById(Contrat cont) {
        String sql = "SELECT * FROM Contrat WHERE id =:id";

        return (Contrat) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(cont), new ContratMapper());
    }

}
