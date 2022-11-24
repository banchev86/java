

package com.example.invoice.dao.references;

import com.example.invoice.models.Reference;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ReferencesDaoImpl implements IreferencesDoa {
    private final NamedParameterJdbcOperations namedParameter;

    @Autowired
    public ReferencesDaoImpl(NamedParameterJdbcOperations namedParameter) {
        this.namedParameter = namedParameter;
    }

    public List<Reference> allReferences() {

        String sql = "SELECT ext_ref, individ FROM references";

        SqlParameterSource parameters = new MapSqlParameterSource();

        return this.namedParameter.query(sql, parameters, (rs, RowNum) -> {
            Reference rf = new Reference();
            rf.setIndividId(rs.getLong("individ"));
            rf.setRef(rs.getLong("ext_ref"));
            return rf;
        });
    }

    public void addReference(Reference reference) {

        String sql = "INSERT INTO references VALUES(:ext_ref,:individ)";

        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("ext_ref", reference.getRef())
                .addValue("individ", reference.getIndividId());

        this.namedParameter.update(sql, parameters);
    }

    public Optional<Reference> getReference(long id) {

        String sql = "SELECT * FROM references WHERE ext_ref=:id";

        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", id);

        try {
            return this.namedParameter.queryForObject(sql, parameters, (rs, RowNum) -> {
                Reference rf = new Reference();
                rf.setIndividId(rs.getLong("individ"));
                rf.setRef(rs.getLong("ext_ref"));
                return Optional.of(rf);
            });
        } catch (EmptyResultDataAccessException var6) {
            return Optional.empty();
        }
    }

    public void deleteReference(long id) {
        String sql = "DELETE FROM references WHERE ext_ref=:id";
        SqlParameterSource parameters = (new MapSqlParameterSource()).addValue("id", id);
        this.namedParameter.update(sql, parameters);
    }

    public void updateReference(Reference reference) {

        String sql = "UPDATE references SET individ=:individ WHERE ext_ref=:id";

        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("individ", reference.getIndividId())
                .addValue("id", reference.getRef());

        this.namedParameter.update(sql, parameters);
    }

    public boolean isValidRefId(long id) {

        String sql = "SELECT COUNT(1) FROM references WHERE ext_ref=:id";

        SqlParameterSource parameters = new MapSqlParameterSource().addValue("id", id);

        Integer validDebtor = this.namedParameter.queryForObject(sql, parameters, Integer.class);

        if (validDebtor == null) {
            return false;
        } else {
            return validDebtor > 0;
        }
    }


}
