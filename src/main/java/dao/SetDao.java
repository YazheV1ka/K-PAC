package dao;

import entity.Set;

import java.util.List;

public interface SetDao {
    List<Set> findAll();
    List<Set> findAttachedKPacs(int id);
    Set getById(int id);

    void create(Set set);
    void delete(int id);

}
