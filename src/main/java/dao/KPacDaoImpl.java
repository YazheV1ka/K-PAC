package dao;

import entity.KPac;
import mapper.KPacMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class KPacDaoImpl implements KPacDao{
    public JdbcTemplate jdbcTemplate;

    @Autowired
    public KPacDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<KPac> findAll() {
        String sql = "SELECT * FROM kpacs";
        return jdbcTemplate.query(sql, new KPacMapper());
    }

    public KPac getById(int id) {
        String sql = "SELECT * FROM kpacs WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new KPacMapper(), id);
    }

    public void create(KPac kPac) {
        String sql = "INSERT INTO kpacs (id,title, description, creation_date) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, kPac.getTitle(), kPac.getDescription(), kPac.getCreationDate());
    }

    public void delete(int id) {
        String sql = "DELETE FROM kpacs WHERE id =?";
        jdbcTemplate.update(sql, id);
    }
}
