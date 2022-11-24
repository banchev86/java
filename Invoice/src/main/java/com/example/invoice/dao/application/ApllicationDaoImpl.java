//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.dao.application;

import com.example.invoice.commons.TableColumns;
import com.example.invoice.models.Application;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ApllicationDaoImpl implements IapplicationDao {
    private final NamedParameterJdbcOperations namedParameter;

    @Autowired
    public ApllicationDaoImpl(NamedParameterJdbcOperations namedParameter) {
        this.namedParameter = namedParameter;
    }

    public List<Application> personsByComp(long companyId) {

        String sql = "SELECT c.name,i2.name,i2.type,r.ext_ref,i.amount,i.issue_date FROM individual i2 " +
                     "INNER JOIN references r ON i2.indivId = r.indivId " +
                     "INNER JOIN invoices i ON i2.indivId = i.indivId " +
                     "INNER JOIN companies c ON c.companyId = i2.companyId " +
                     "WHERE c.companyid=:companyId";


        SqlParameterSource parameters = (new MapSqlParameterSource())
                .addValue("companyId", companyId);

        return this.namedParameter.query(sql, parameters, (rs, RowNum) -> {
            Application ap = new Application();
            ap.setCompanyName(rs.getString(1));
            ap.setIndividName(rs.getString(2));
            ap.setIndividType(rs.getString(3));
            ap.setReferenceRef(rs.getLong(4));
            ap.setAmount(rs.getBigDecimal(5));
            ap.setIssueDate(rs.getString(6));
            return ap;
        });
    }

    public List<Application> searchByPerson(long individId) {

        String sql = "SELECT c.name, i2.name, i2.type, r.ext_ref, i.amount, i.issue_date FROM individual i2 " +
                     "INNER JOIN references r ON i2.indivId = r.indivId " +
                     "INNER JOIN invoices i ON i2.indivId = i.indivId " +
                     "INNER JOIN companies c ON c.companyId = i2.companyId " +
                     "WHERE i2.individ=:individId";

        SqlParameterSource parameters = (new MapSqlParameterSource())
                .addValue("individId", individId);

        return this.namedParameter.query(sql, parameters, (rs, RowNum) -> {
            Application ap = new Application();
            ap.setCompanyName(rs.getString(1));
            ap.setIndividName(rs.getString(2));
            ap.setIndividType(rs.getString(3));
            ap.setReferenceRef(rs.getLong(4));
            ap.setAmount(rs.getBigDecimal(5));
            ap.setIssueDate(rs.getString(6));
            return ap;
        });
    }

    public List<Application> orderBy(long companyId, String param) {

        String sql = "SELECT c.name, i2.name AS names, i2.type AS types, r.ext_ref AS ref, " +
                "i.amount AS amount, i.issue_date AS dates FROM individual i2 " +
                "INNER JOIN references r ON i2.indivId = r.indivId " +
                "INNER JOIN invoices i ON i2.indivId = i.indivId " +
                "INNER JOIN companies c ON c.companyId = i2.companyId " +
                "WHERE c.companyid=:companyId " +
                "ORDER BY " + param;

        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("companyId", companyId);

        return this.namedParameter.query(sql, parameters, (rs, RowNum) -> {
            Application ap = new Application();
            ap.setCompanyName(rs.getString(1));
            ap.setIndividName(rs.getString(2));
            ap.setIndividType(rs.getString(3));
            ap.setReferenceRef(rs.getLong(4));
            ap.setAmount(rs.getBigDecimal(5));
            ap.setIssueDate(rs.getString(6));
            return ap;
        });
    }

    public List<Application> searchBy(long companyId, String param, String val) {

        String sql = "SELECT c.name, i2.name ,i2.type, " +
                     "r.ext_ref, i.amount,i.issue_date FROM individual i2 " +
                     "INNER JOIN references r ON i2.indivId = r.indivId " +
                     "INNER JOIN invoices i ON i2.indivId = i.indivId " +
                     "INNER JOIN companies c ON c.companyId = i2.companyId " +
                     "where c.companyid=:companyId   AND " +
                      TableColumns.getColumns1().get(param) + " = " + val;

        SqlParameterSource parameters = (new MapSqlParameterSource())
                .addValue("companyId", companyId);

        return this.namedParameter.query(sql, parameters, (rs, RowNum) -> {
            Application ap = new Application();
            ap.setCompanyName(rs.getString(1));
            ap.setIndividName(rs.getString(2));
            ap.setIndividType(rs.getString(3));
            ap.setReferenceRef(rs.getLong(4));
            ap.setAmount(rs.getBigDecimal(5));
            ap.setIssueDate(rs.getString(6));
            return ap;
        });
    }
}
