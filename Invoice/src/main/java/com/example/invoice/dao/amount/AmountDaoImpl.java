//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.dao.amount;

import com.example.invoice.models.Amount;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class AmountDaoImpl implements IamountDao {
    private final NamedParameterJdbcOperations namedParameter;

    @Autowired
    public AmountDaoImpl(NamedParameterJdbcOperations namedParameter) {
        this.namedParameter = namedParameter;
    }

    public Optional<Amount> getAllAmountByCompanyId(long id) {

        String sql = "SELECT c.companyid,c.name,SUM(i.amount),SYSTIMESTAMP FROM invoices i " +
                     "INNER JOIN individual i2 ON i.indivId=i2.indivId " +
                     "INNER JOIN companies c ON i2.companyId=c.companyId " +
                     "WHERE  c.companyid=:id GROUP BY c.companyId, c.name";

        SqlParameterSource parameters = (new MapSqlParameterSource()).addValue("id", id);

        try {
            return this.namedParameter.queryForObject(sql, parameters, (rs, RowNum) -> {
                Amount am = new Amount();
                am.setCompanyId(rs.getLong(1));
                am.setName(rs.getString(2));
                am.setAmount(rs.getString(3));
                am.setDate(rs.getDate(4).toString());
                return Optional.of(am);
            });
        } catch (EmptyResultDataAccessException var6) {
            return Optional.empty();
        }
    }
}
