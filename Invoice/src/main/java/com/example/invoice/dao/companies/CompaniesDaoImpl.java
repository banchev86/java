//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.dao.companies;

import com.example.invoice.models.Company;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class CompaniesDaoImpl implements IcompaniesDoa {
    private final NamedParameterJdbcOperations namedParameter;

    @Autowired
    public CompaniesDaoImpl(NamedParameterJdbcOperations namedParameter) {
        this.namedParameter = namedParameter;
    }

    public List<Company> allCompanies() {

        String sql = "SELECT companyid,name FROM companies";

        SqlParameterSource parameters = new MapSqlParameterSource();

        return this.namedParameter.query(sql, parameters, (rs, RowNum) -> {
            Company cm = new Company();
            cm.setCompanyId(rs.getLong("companyid"));
            cm.setName(rs.getString("name"));
            return cm;
        });
    }

    public void addCompany(Company company) {

        String sql = "INSERT INTO companies(name) VALUES(:name)";

        SqlParameterSource parameters = (new MapSqlParameterSource()).addValue("name", company.getName());
        this.namedParameter.update(sql, parameters);
    }

    public Optional<Company> getCompany(long id) {

        String sql = "SELECT companyid,name from companies where companyId=:id";

        SqlParameterSource parameters = (new MapSqlParameterSource()).addValue("id", id);

        try {
            return this.namedParameter.queryForObject(sql, parameters, (rs, RowNum) -> {
                Company cm = new Company();
                cm.setCompanyId(rs.getLong("companyid"));
                cm.setName(rs.getString("name"));
                return Optional.of(cm);
            });
        } catch (EmptyResultDataAccessException var6) {
            return Optional.empty();
        }
    }

    public void deleteCompany(long id) {

        String sql = "DELETE FROM companies WHERE companyid=:id";

        SqlParameterSource parameters = (new MapSqlParameterSource()).addValue("id", id);
        this.namedParameter.update(sql, parameters);
    }

    public void updateCompany(Company company) {

        String sql = "UPDATE companies SET name=:name WHERE companyid=:id";

        SqlParameterSource parameters = (new MapSqlParameterSource()).addValue("id", company.getCompanyId()).addValue("name", company.getName());
        this.namedParameter.update(sql, parameters);
    }

    public boolean isValidCompanyId(long id) {

        String sql = "SELECT COUNT(1) FROM companies WHERE companyid=:id";

        SqlParameterSource parameters = (new MapSqlParameterSource()).addValue("id", id);
        Integer validDebtor = this.namedParameter.queryForObject(sql, parameters, Integer.class);
        if (validDebtor == null) {
            return false;
        } else {
            return validDebtor > 0;
        }
    }


}
