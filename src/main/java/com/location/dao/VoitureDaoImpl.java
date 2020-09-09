package com.location.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.location.model.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;



@Repository
public class VoitureDaoImpl  implements VoitureDao{

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List listAllVoiture() {
        List list = new ArrayList();

        String sql = "SELECT * From Utilisateur WHERE date_supp=NULL";

        list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new VoitureMapper());

        return list;
    }

    private SqlParameterSource getSqlParameterByModel(Voiture V){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if(V != null){
            parameterSource.addValue("id", V.getId());
            parameterSource.addValue("id_modele", V.getId_Modele());
            parameterSource.addValue("id_image", V.getId_Image());
            parameterSource.addValue("matricule", V.getmatricule());
            parameterSource.addValue("kilometrage", V.getkilometrage());
            parameterSource.addValue("couleur", V.getcouleur());
            parameterSource.addValue("prixAchat", V.getprixAchat());
            parameterSource.addValue("etat", V.getetat());
            parameterSource.addValue("dateAjout", V.getdateAjout());
            parameterSource.addValue("dateMiseajour", V.getdateMiseajour());
            parameterSource.addValue("dateSupp", V.getdateSupp());

        }
        return parameterSource;
    }

    private static final class VoitureMapper implements RowMapper{

        public Voiture mapRow(ResultSet rs, int rowNum) throws SQLException {
            Voiture u = new Voiture();
            u.setId(rs.getInt("id"));
            u.setId_Modele(rs.getInt("id_modele"));
            u.setId_Image(rs.getInt("id_image"));
            u.setmatricule(rs.getString("matricule"));
            u.setkilometrage(rs.getInt("kilometrage"));
            u.setcouleur(rs.getString("couleur"));
            u.setprixAchat(rs.getFloat("prixAchat"));
            u.setetat(rs.getString("etat"));
            u.setdateAjout(rs.getDate("dateAjout"));
            u.setdateMiseajour(rs.getDate("dateMiseajour"));
            u.setdateSupp(rs.getDate("dateSupp"));




            return u;
        }

    }

    public void addVoiture(Voiture V) {
        String sql = "INSERT INTO Voiture (id_modele, id_image, matricule, kilometrage, couleur, prixAchat, etat, dateAjout, dateMiseajour, dateSupp) VALUES (:id_modele, :id_image, :matricule, :kilometrage, :couleur, :prixAchat, :etat, NOW, NULL, NULL) ";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(V));
    }

    public void updateVoiture(Voiture V) {
        String sql = "UPDATE Voiture SET (id_modele=:id_modele, id_image=:id_image, matricule=:matricule, kilometrage=:kilometrage, couleur=:couleur, prixAchat=:prixAchat, etat=:etat, dateMiseajour=NOW() WHERE id =:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(V));
    }

    public void delete(Voiture V) {
        String sql = "UPDATE Voiture SET date_supp=NOW() WHERE id=:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(V));
    }

    public Voiture findVoitureById(Voiture V) {
        String sql = "SELECT * FROM Utilisateur WHERE id =:id";

        return (Voiture) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(V), new VoitureMapper());
    }

}
