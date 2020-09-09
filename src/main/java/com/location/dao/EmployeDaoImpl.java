package com.location.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.location.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;





@Repository
public class EmployeDaoImpl  implements EmployeDao{

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List listAllEmploye() {
        List list = new ArrayList();

        String sql = "SELECT * From Employe, Utilisateur WHERE Employe.id=Utilisateur.id AND Utilisateur.date_supp=NULL";

        list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new EmployeMapper());

        return list;
    }


    private SqlParameterSource getSqlParameterByModel(Employe emp){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if(emp != null){
            parameterSource.addValue("id", emp.getId());
            parameterSource.addValue("role", emp.getrole());
            parameterSource.addValue("date_embauch", emp.getdateEmbauch());
            parameterSource.addValue("salaire", emp.getsalaire());



        }
        return parameterSource;
    }

    private static final class EmployeMapper implements RowMapper{

        public Employe mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employe emp = new Employe();
            emp.setId(rs.getInt("id"));
            emp.setrole(rs.getString("role"));
            emp.setdateEmbauch(rs.getDate("date_embauch"));
            emp.setsalaire(rs.getFloat("salaire"));




            return emp;
        }

    }

    public void addEmploye(Employe emp) {
        String sql = "INSERT INTO Employe( id,role, date_embauch, salaire) VALUES( :id, :role, :date_embauch, :salaire)";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(emp));
    }

    public void updateEmploye(Employe emp) {
        String sql = "UPDATE Employe, Utilisateur SET  role=:role, date_embauch=:date_embauch, salaire=:salaire, date_miseajour=NOW() WHERE Utilisateur.id=Employe.id AND Employe.id =:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(emp));
    }

    public void delete(Employe emp) {
        String sql = "UPDATE Employe,Utilisateur SET Utilisateur.date_supp=NOW() WHERE Employe.id=Utilisateur.id id=:id";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(emp));
    }

    public Employe findEmployeById(Employe emp) {
        String sql = "SELECT * FROM Employe WHERE id =:id";

        return (Employe) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(emp), new EmployeMapper());
    }

}