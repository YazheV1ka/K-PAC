package mapper;

import entity.KPac;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KPacMapper implements RowMapper<KPac> {
    @Override
    public KPac mapRow(ResultSet rs, int rowNum) throws SQLException {
        KPac kPac = new KPac();
        kPac.setId(rs.getInt("id"));
        kPac.setTitle(rs.getString("title"));
        kPac.setDescription(rs.getString("description"));
        kPac.setCreationDate(rs.getString("creationDate"));
        return kPac;
    }
}
