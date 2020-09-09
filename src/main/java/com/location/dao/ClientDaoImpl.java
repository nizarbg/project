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

import com.location.model.Client;

    @Repository
    public class ClientDaoImpl  implements ClientDao{

        NamedParameterJdbcTemplate namedParameterJdbcTemplate;

        @Autowired
        public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
            this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        }

        public List listAllClients() {
            List list = new ArrayList();

            String sql = "SELECT * From Client,Utilisateur WHERE Utilisateur.id=Client.id AND Utilisateur.date_supp=NULL";

            list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new ClientMapper());

            return list;
        }

        private SqlParameterSource getSqlParameterByModel(Client cli){
            MapSqlParameterSource parameterSource = new MapSqlParameterSource();
            if(cli != null){
                parameterSource.addValue("id", cli.getId());
                parameterSource.addValue("nationalite", cli.getnationalite());
                parameterSource.addValue("profession", cli.getprofession());
                parameterSource.addValue("codepostal", cli.getcodepostal());
            }
            return parameterSource;
        }

        private static final class ClientMapper implements RowMapper{

            public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
                Client clien = new Client();
                clien.setId(rs.getInt("id"));
                clien.setcodepostal(rs.getInt("codepostal"));
                clien.setnationalite(rs.getString("nationalite"));
                clien.setprofession(rs.getString("profession"));

                return clien;
            }

        }

        public void addClient(Client cli) {
            String sql = "INSERT INTO Client(id, nationalite, profession, codepostal) VALUES(:id, :nationalite, :profession, :codepostal)";

            namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(cli));
        }

        public void updateClient(Client cli) {
            String sql = "UPDATE Client,Utilisateur SET nationalite=:nationalite, profession=:profession, codepostal=:codepostal date_miseajour=NOW() WHERE Utilisateur.id=Client.id AND Client.id =:id";

            namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(cli));
        }

        public void delete(Client cli) {
            String sql = "UPDATE Utilisateur SET date_supp=NOW() WHERE Utilisateur.id=Client.id AND Client.id=:id ";

            namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(cli));
        }

        public Client findclientById(Client cli) {
            String sql = "SELECT * FROM users WHERE id =:id";

            return (Client) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(cli), new ClientMapper());
        }

    }

