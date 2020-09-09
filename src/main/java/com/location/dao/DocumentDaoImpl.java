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

import com.location.model.Document;



@Repository
public class DocumentDaoImpl  implements DocumentDao{

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List listAllDocument() {
        List list = new ArrayList();

        String sql = "SELECT * From Document WHERE date_supp=NULL";

        list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new DocumentMapper());

        return list;
    }

    private SqlParameterSource getSqlParameterByModel(Document doc){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if(doc != null){
            parameterSource.addValue("id", doc.getId());
            parameterSource.addValue("id_voiture", doc.getId_Voiture());
            parameterSource.addValue("type_document", doc.gettype_document());
            parameterSource.addValue("Date_document", doc.getDate_document());
            parameterSource.addValue("dateAjout", doc.getdate_ajout());
            parameterSource.addValue("dateMiseajour", doc.getDate_miseajour());
            parameterSource.addValue("dateSupp", doc.getDate_supp());

        }
        return parameterSource;
    }

    private static final class DocumentMapper implements RowMapper{

        public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
            Document doc = new Document();
            doc.setId(rs.getInt("id"));
            doc.setId_Voiture(rs.getInt("id_voiture"));
            doc.settype_document(rs.getString("type_document"));
            doc.setDate_document(rs.getDate("Date_document"));
            doc.setdate_ajout(rs.getDate("dateAjout"));
            doc.setDate_miseajour(rs.getDate("dateMiseajour"));
            doc.setDate_supp(rs.getDate("dateSupp"));



            return doc;
        }

    }

    public void addDocument(Document doc) {
        String sql = "INSERT INTO Document(id_voiture, type_document, date_document, dateAjout, dateMiseajour, dateSupp) VALUES(:id_voiture, :type_document, :date_document, NOW(), NULL, NULL) ";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(doc));
    }

    public void updateDocument(Document doc) {
        String sql = "UPDATE Document SET id_voiture=:id_voiture, type_document=:type_document, date_document=:date_document, dateMiseajour=NOW(), WHERE id =:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(doc));
    }

    public void delete(Document doc) {
        String sql = "UPDATE Document SET date_supp=NOW() WHERE id=:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(doc));
    }

    public Document findDocumentById(Document doc) {
        String sql = "SELECT * FROM Document WHERE id =:id";

        return (Document) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(doc), new DocumentMapper());
    }

}
