//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.dao.individual;

import com.example.invoice.models.Individual;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class IndividualDaoImpl implements IindividualDoa {
    private final NamedParameterJdbcOperations namedParameter;

    @Autowired
    public IndividualDaoImpl(NamedParameterJdbcOperations namedParameter) {
        this.namedParameter = namedParameter;
    }

    public List<Individual> allIndividuals() {

        String sql = "SELECT individ,name,type,companyid FROM individual";

        SqlParameterSource parameters = new MapSqlParameterSource();

        return this.namedParameter.query(sql, parameters, (rs, RowNum) -> {
            Individual in = new Individual();
            in.setIndividId(rs.getLong("individ"));
            in.setName(rs.getString("name"));
            in.setType(rs.getString("type"));
            in.setCompanyId(rs.getLong("companyid"));
            return in;
        });
    }

    public void addIndividual(Individual individual) {

        String sql = "INSERT INTO individual(name,type,companyid) " +
                     "VALUES(:name,:type,:companyid)";

        SqlParameterSource parameters = (new MapSqlParameterSource()).addValue("name", individual.getName()).addValue("type", individual.getType()).addValue("companyid", individual.getCompanyId());
        this.namedParameter.update(sql, parameters);
    }

    public Optional<Individual> getIndividual(long id) {

        String sql = "SELECT individ,name,type,companyid FROM individual " +
                     "WHERE individ=:id";

        SqlParameterSource parameters = (new MapSqlParameterSource())
                .addValue("id", id);

        try {
            return this.namedParameter.queryForObject(sql, parameters, (rs, RowNum) -> {
                Individual in = new Individual();
                in.setIndividId(rs.getLong("individ"));
                in.setName(rs.getString("name"));
                in.setType(rs.getString("type"));
                in.setCompanyId(rs.getLong("companyid"));
                return Optional.of(in);
            });
        } catch (EmptyResultDataAccessException var6) {
            return Optional.empty();
        }
    }

    public void deleteIndividual(long id) {

        String sql = "DELETE FROM individual WHERE individ=:id";

        SqlParameterSource parameters = (new MapSqlParameterSource()).addValue("id", id);
        this.namedParameter.update(sql, parameters);
    }

    public void updateIndividual(Individual individual) {

        String sql = "UPDATE individual SET name=:name,type=:type,companyid=:companyid " +
                     "WHERE individ=:individ";

        SqlParameterSource parameters = (new MapSqlParameterSource()).addValue("individ", individual.getIndividId()).addValue("name", individual.getName()).addValue("type", individual.getType()).addValue("companyid", individual.getCompanyId());
        this.namedParameter.update(sql, parameters);
    }

    public boolean isValidIndividId(long id) {

        String sql = "SELECT COUNT(1) FROM individual WHERE individ=:id";

        SqlParameterSource parameters = (new MapSqlParameterSource()).addValue("id", id);

        Integer validDebtor = this.namedParameter.queryForObject(sql, parameters, Integer.class);
        if (validDebtor == null) {
            return false;
        } else {
            return validDebtor > 0;
        }
    }
}
