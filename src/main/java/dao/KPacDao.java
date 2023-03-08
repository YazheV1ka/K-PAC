package dao;

import entity.KPac;

import java.util.List;

public interface KPacDao {
    List<KPac> findAll();
    KPac getById(int id);

    void create(KPac kPac);
    void delete(int id);
}
