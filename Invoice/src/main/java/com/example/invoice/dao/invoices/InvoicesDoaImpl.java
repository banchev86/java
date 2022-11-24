

package com.example.invoice.dao.invoices;

import com.example.invoice.models.Invoice;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class InvoicesDoaImpl implements IinvoicesDoa {
    private final NamedParameterJdbcOperations namedParameter;

    @Autowired
    public InvoicesDoaImpl(NamedParameterJdbcOperations namedParameter) {
        this.namedParameter = namedParameter;
    }

    public List<Invoice> allInvoices() {

        String sql = "SELECT invoiceid, individ, amount, issue_date FROM invoices";

        SqlParameterSource parameters = new MapSqlParameterSource();

        return this.namedParameter.query(sql, parameters, (rs, RowNum) -> {
            Invoice in = new Invoice();
            in.setInvoiceId(rs.getLong("invoiceid"));
            in.setIndividId(rs.getLong("individ"));
            in.setAmount(rs.getBigDecimal("amount"));
            in.setDate(rs.getString("issue_date"));
            return in;
        });
    }

    public void addInvoice(Invoice invoice) {

        String sql = "INSERT INTO invoices(individ, amount, issue_date) " +
                     "VALUES(:individ,:amount,TO_DATE(:date,'YYYY-MM-DD HH24:MI:SS'))";

        SqlParameterSource parameters = (new MapSqlParameterSource())
                .addValue("individ", invoice.getIndividId())
                .addValue("amount", invoice.getAmount())
                .addValue("date", invoice.getDate());

        this.namedParameter.update(sql, parameters);
    }

    public Optional<Invoice> getInvoice(long id) {

        String sql = "SELECT invoiceid, individ, amount, issue_date FROM invoices " +
                     "WHERE invoiceid=:id";

        SqlParameterSource parameters = (new MapSqlParameterSource()).addValue("id", id);

        try {
            return this.namedParameter.queryForObject(sql, parameters, (rs, RowNum) -> {
                Invoice in = new Invoice();
                in.setInvoiceId(rs.getLong("invoiceid"));
                in.setIndividId(rs.getLong("individ"));
                in.setAmount(rs.getBigDecimal("amount"));
                in.setDate(rs.getString("issue_date"));
                return Optional.of(in);
            });
        } catch (EmptyResultDataAccessException var6) {
            return Optional.empty();
        }
    }

    public void deleteInvoice(long id) {

        String sql = "DELETE FROM invoices WHERE invoiceid=:id";

        SqlParameterSource parameters = (new MapSqlParameterSource())
                .addValue("id", id);

        this.namedParameter.update(sql, parameters);
    }

    public void updateInvoice(Invoice invoice) {

        String sql = "UPDATE invoices SET individ=:individ,amount=:amount," +
                     "issue_date=TO_DATE(:date,'YYYY-MM-DD HH24:MI:SS') " +
                     "WHERE invoiceid=:id";

        SqlParameterSource parameters = (new MapSqlParameterSource())
                .addValue("id", invoice.getInvoiceId())
                .addValue("individ", invoice.getIndividId())
                .addValue("amount", invoice.getAmount())
                .addValue("date",invoice.getDate());

        this.namedParameter.update(sql, parameters);
    }

    public boolean isValidInvoiceId(long id) {
        String sql = "SELECT COUNT(1) FROM invoices WHERE invoiceid=:id";

        SqlParameterSource parameters = (new MapSqlParameterSource()).addValue("id", id);

        Integer validDebtor = this.namedParameter.queryForObject(sql, parameters, Integer.class);

        if (validDebtor == null) {
            return false;
        } else {
            return validDebtor > 0;
        }
    }
}
