package mapper;

import entity.KPacSet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KPacSetMapper implements RowMapper<KPacSet> {
    @Override
    public KPacSet mapRow(ResultSet rs, int rowNum) throws SQLException {
        KPacSet kPacSet = new KPacSet();
        kPacSet.setId(rs.getInt("id"));
        kPacSet.setKPacId(rs.getInt("kpac_id"));
        kPacSet.setSetId(rs.getInt("set_id"));
        return kPacSet;
    }
}
