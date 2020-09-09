package com.location.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.location.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;



@Repository
public class UtilisateurDaoImpl  implements UtilisateurDao{

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List listAllUtilisateur() {
        List list = new ArrayList();

        String sql = "SELECT * From Utilisateur WHERE date_supp=NULL";

        list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UtilisateurMapper());

        return list;
    }

    private SqlParameterSource getSqlParameterByModel(Utilisateur u){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if(u != null){
            parameterSource.addValue("id", u.getId());
            parameterSource.addValue("id_Image", u.getId_Image());
            parameterSource.addValue("numCin", u.getnumCin());
            parameterSource.addValue("dateCin", u.getdateCin());
            parameterSource.addValue("nom", u.getnom());
            parameterSource.addValue("prenom", u.getprenom());
            parameterSource.addValue("motdepasse", u.getmotDePasse());
            parameterSource.addValue("numTel", u.getnumTel());
            parameterSource.addValue("email", u.getemail());
            parameterSource.addValue("adresse", u.getadresse());
            parameterSource.addValue("numPermis", u.getnumPermis());
            parameterSource.addValue("datePermis", u.getdatePermis());
            parameterSource.addValue("dateAjout", u.getdateAjout());
            parameterSource.addValue("dateMiseajour", u.getdateMiseajour());
            parameterSource.addValue("dateSupp", u.getdateSupp());

        }
        return parameterSource;
    }

    private static final class UtilisateurMapper implements RowMapper{

        public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
            Utilisateur u = new Utilisateur();
            u.setId(rs.getInt("id"));
            u.setId_Image(rs.getInt("id_image"));
            u.setnumCin(rs.getInt("numCin"));
            u.setdateCin(rs.getDate("dateCin"));
            u.setnom(rs.getString("nom"));
            u.setprenom(rs.getString("prenom"));
            u.setmotDePasse(rs.getString("motdepasse"));
            u.setnumTel(rs.getInt("numTel"));
            u.setemail(rs.getString("email"));
            u.setadresse(rs.getString("adresse"));
            u.setnumPermis(rs.getInt("num_Permis"));
            u.setdatePermis(rs.getDate("datePermis"));
            u.setdateAjout(rs.getDate("dateAjout"));
            u.setdateMiseajour(rs.getDate("dateMiseajour"));
            u.setdateSupp(rs.getDate("dateSupp"));




            return u;
        }

    }

    public void addUtilisateur(Utilisateur u) {
        String sql = "INSERT INTO Utilisateur (id_image, numCin, dateCin, nom, prenom, motdepasse, numTel, email, adresse, num_Permis, datePermis, dateAjout, dateMiseajour, dateSupp) VALUES (:id_image, :numCin, :dateCin, :nom, :prenom, :motdepasse, :numTel, :email, :adresse, :num_Permis, :datePermis, NOW(), NULL, NULL)";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(u));
    }

    public void updateUtilisateur(Utilisateur u) {
        String sql = "UPDATE Utilisateur SET (id_image=:id_image, numCin=:numCin, dateCin=:dateCin, nom=:nom, prenom=:prenom, motdepasse=:motdepasse, numTel=:numTel, email=:email, adresse=:adresse, num_Permis=:num_Permis, datePermis=:datePermis, dateMiseajour=NOW() WHERE id =:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(u));
    }

    public void delete(Utilisateur u) {
        String sql = "UPDATE Utilisateur SET date_supp=NOW() WHERE id=:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(u));
    }

    public Utilisateur findUtilisateurById(Utilisateur u) {
        String sql = "SELECT * FROM Utilisateur WHERE id =:id";

        return (Utilisateur) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(u), new UtilisateurMapper());
    }

}
