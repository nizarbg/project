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

import com.location.model.Modele;


@Repository
public class ModeleDaoImpl  implements ModeleDao{

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List listAllModele() {
        List list = new ArrayList();

        String sql = "SELECT * From Modele";

        list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new ModeleMapper());

        return list;
    }

    private SqlParameterSource getSqlParameterByModel(Modele mod){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if(mod != null){
            parameterSource.addValue("id", mod.getId());
            parameterSource.addValue("id_Image", mod.getId_Image());
            parameterSource.addValue("nom", mod.getnom());
            parameterSource.addValue("marque", mod.getmarque());
            parameterSource.addValue("carburant", mod.getcarburant());
            parameterSource.addValue("puissance", mod.getpuissance());
            parameterSource.addValue("nbPortes", mod.getnbPortes());
            parameterSource.addValue("nbPlaces", mod.getnbPlaces());
            parameterSource.addValue("prixLocation", mod.getprixLocation());
            parameterSource.addValue("boite", mod.getboite());
            parameterSource.addValue("cylindre", mod.getcylindre());
            parameterSource.addValue("nbcylindres", mod.getnbcylindres());
            parameterSource.addValue("transmission", mod.gettransmission());
            parameterSource.addValue("dateSortie", mod.getdateSortie());

        }
        return parameterSource;
    }

    private static final class ModeleMapper implements RowMapper{

        public Modele mapRow(ResultSet rs, int rowNum) throws SQLException {
            Modele mod = new Modele();
            mod.setId(rs.getInt("id"));
            mod.setId_Image(rs.getInt("id_image"));
            mod.setnom(rs.getString("nom"));
            mod.setmarque(rs.getString("marque"));
            mod.setcarburant(rs.getString("carburant"));
            mod.setpuissance(rs.getFloat("puissance"));
            mod.setnbPortes(rs.getInt("nbportes"));
            mod.setnbPlaces(rs.getInt("nbplaces"));
            mod.setprixLocation(rs.getFloat("prixlocation"));
            mod.setboite(rs.getString("boite"));
            mod.setcylindre(rs.getFloat("cylindre"));
            mod.setnbcylindres(rs.getInt("nbcylindre"));
            mod.settransmission(rs.getString("transmission"));
            mod.setdateSortie(rs.getInt("dateSortie"));



            return mod;
        }

    }

    public void addModele(Modele mod) {
        String sql = "INSERT INTO Modele(id_image, nom, marque, carburant, puissance, nbportes, nbplaces, prixlocation, boite, cylidre, nbcylindre, transmission, dateajout) VALUES (:id_image, :nom, :marque, :carburant, :puissance, :nbportes, :nbplaces, :prixlocation, :boite, :cylidre, :nbcylindre, :transmission, :dateajout)";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(mod));
    }

    public void updateModele(Modele mod) {
        String sql = "UPDATE Modele SET (id_image=:id_image, nom=:nom, marque=:marque, carburant=:carburant, puissance=:puissance, nbportes=:nbportes, nbplaces=:nbplaces, prixlocation=:prixlocation, boite=:boite, cylidre=:cylindre, nbcylindre=:nbcylindre, transmission=:transmission, dateajout=:dateajout WHERE id =:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(mod));
    }

    public void delete(Modele mod) {
        String sql = "DELETE FROM Modele WHERE id=:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(mod));
    }

    public Modele findModeleById(Modele mod) {
        String sql = "SELECT * FROM Modele WHERE id =:id";

        return (Modele) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(mod), new ModeleMapper());
    }

}
