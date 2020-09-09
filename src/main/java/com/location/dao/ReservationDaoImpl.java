package com.location.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.location.model.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;




@Repository
public class ReservationDaoImpl  implements ReservationDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List listAllReservation() {
        List list = new ArrayList();

        String sql = "SELECT * From Reservation WHERE date_supp=NULL";

        list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new ReservationMapper());

        return list;
    }


    private SqlParameterSource getSqlParameterByModel(Reservation res) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if (res != null) {
            parameterSource.addValue("id", res.getId());
            parameterSource.addValue("id_client", res.getId_Client());
            parameterSource.addValue("id_voiture", res.getId_Voiture());
            parameterSource.addValue("id_employe", res.getId_Employe());
            parameterSource.addValue("date_debut", res.getdateDebut());
            parameterSource.addValue("lieuPrise", res.getlieuPrise());
            parameterSource.addValue("date_Fin", res.getdateFin());
            parameterSource.addValue("lieuRetour", res.getlieuRetour());
            parameterSource.addValue("description", res.getdescription());
            parameterSource.addValue("date_ajout", res.getdateAjout());
            parameterSource.addValue("date_miseajour", res.getdateMiseajour());
            parameterSource.addValue("date_supp", res.getdateSupp());


        }
        return parameterSource;
    }

    private static final class ReservationMapper implements RowMapper {

        public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
            Reservation res = new Reservation();
            res.setId(rs.getInt("id"));
            res.setId_Client(rs.getInt("id_Client"));
            res.setId_Voiture(rs.getInt("id_voiture"));
            res.setId_Employe(rs.getInt("id_employe"));
            res.setdateDebut(rs.getDate("date_debut"));
            res.setlieuPrise(rs.getString("lieuPrise"));
            res.setdateFin(rs.getDate("dateFin"));
            res.setlieuRetour(rs.getString("lieuRetour"));
            res.setdescription(rs.getString("description"));
            res.setdateAjout(rs.getDate("date_ajout"));
            res.setdateMiseajour(rs.getDate("date_miseajour"));
            res.setdateSupp(rs.getDate("date_supp"));


            return res;
        }

    }

    public void addReservation(Reservation res) {
        String sql = "INSERT INTO Reservation(  id_client, id_voiture, id_employe, date_debut, lieuPrise, dateFin, lieuRetour, description, date_ajout, date_miseajour, date_supp) VALUES ( :id_client, :id_voiture, :id_employe, :date_debut, :lieuPrise, :dateFin, :lieuRetour, :description, NOW(), NULL, NULL";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(res));
    }

    public void updateReservation(Reservation res) {
        String sql = "UPDATE Reservation SET  id_client=:id_client, id_voiture=:id_voiture, id_employe=:id_employe, date_debut=;date_debut, lieuPrise=:lieuPrise, dateFin=:dateFin, lieuRetour=:lieuRetour, description=:description, date_miseajour=NOW() WHERE id =:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(res));
    }

    public void delete(Reservation res) {
        String sql = "UPDATE Reservation SET date_supp=NOW() WHERE id=:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(res));
    }

    public Reservation findReservationById(Reservation res) {
        String sql = "SELECT * FROM Reservation WHERE id =:id";

        return (Reservation) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(res), new ReservationMapper());
    }

}