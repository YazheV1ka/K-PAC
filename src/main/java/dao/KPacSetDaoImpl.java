package dao;

import entity.KPacSet;
import mapper.KPacSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class KPacSetDaoImpl implements KPacSetDao {
    public JdbcTemplate jdbcTemplate;

    @Autowired
    public KPacSetDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<KPacSet> findAll() {
        String sql = "SELECT * FROM kpacssets";
        return jdbcTemplate.query(sql,new KPacSetMapper());
    }
}
