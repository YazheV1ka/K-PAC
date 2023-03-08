package service;

import entity.Set;

import java.util.List;

public interface SetService {
    List<Set> findAll();
    Set getById(int id);
    List<Set> findAttachedKPacs(int id);

    void create(Set set);
    void delete(int id);
}
