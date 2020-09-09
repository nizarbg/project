package com.location.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.location.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;





@Repository
public class ImageDaoImpl  implements ImageDao{

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List listAllImage() {
        List list = new ArrayList();

        String sql = "SELECT * From Image WHERE date_supp=NULL";

        list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new ImageMapper());

        return list;
    }


    private SqlParameterSource getSqlParameterByModel(Image img){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if(img != null){
            parameterSource.addValue("id", img.getId());
            parameterSource.addValue("type_image", img.gettype_image());
            parameterSource.addValue("photo", img.getphoto());
            parameterSource.addValue("date_ajout", img.getdate_Ajout());
            parameterSource.addValue("date_miseajour", img.getdate_miseajour());
            parameterSource.addValue("date_supp", img.getdate_supp());




        }
        return parameterSource;
    }

    private static final class ImageMapper implements RowMapper{

        public Image mapRow(ResultSet rs, int rowNum) throws SQLException {
            Image img = new Image();
            img.setId(rs.getInt("id"));
            img.setphoto(rs.getString("photo"));
            img.settype_image(rs.getString("type_image"));
            img.setdate_Ajout(rs.getDate("date_ajout"));
            img.setdate_miseajour(rs.getDate("date_miseajour"));
            img.setdate_supp(rs.getDate("date_supp"));




            return img;
        }

    }

    public void addImage(Image img) {
        String sql = "INSERT INTO Image( photo, type_image, date_ajout, date_miseajour, date_supp) VALUES( :photo, :type_image, NOW(), NULL, NULL)";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(img));
    }

    public void updateImage(Image img) {
        String sql = "UPDATE Image SET photo=:photo  type_image=:type_image, date_miseajour=NOW() WHERE id =:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(img));
    }

    public void delete(Image img) {
        String sql = "UPDATE Image SET date_supp=NOW() WHERE id=:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(img));
    }

    public Image findImageById(Image img) {
        String sql = "SELECT * FROM Image WHERE id =:id";

        return (Image) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(img), new ImageMapper());
    }

}