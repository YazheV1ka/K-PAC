package dao;

import entity.Set;
import mapper.SetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SetDaoImpl implements SetDao {
    public JdbcTemplate jdbcTemplate;

    @Autowired
    public SetDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Set> findAll() {
        String sql = "SELECT * FROM sets";
        return jdbcTemplate.query(sql, new SetMapper());
    }

    public List<Set> findAttachedKPacs(int id) {
        String sql = "SELECT kpac_id FROM kpacssets WHERE kpacssets.set_id = ?";
        return jdbcTemplate.query(sql, new SetMapper());
    }

    public Set getById(int id) {
        String sql = "SELECT * FROM sets WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new SetMapper(), id);
    }

    public void create(Set set) {
        String sql = "INSERT INTO sets (title) VALUES (?)";
        jdbcTemplate.update(sql, set.getTitle());
    }

    public void delete(int id) {
        String sql = "DELETE FROM sets WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
