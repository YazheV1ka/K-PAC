package service;

import dao.SetDao;
import entity.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetServiceImpl implements SetService {
    @Autowired
    public SetDao setDao;

    public List<Set> findAll() {
        return setDao.findAll();
    }

    public Set getById(int id) {
        return setDao.getById(id);
    }

    public List<Set> findAttachedKPacs(int id) {
        return setDao.findAttachedKPacs(id);
    }

    public void create(Set set) {
        setDao.create(set);
    }

    public void delete(int id) {
        setDao.delete(id);
    }
}
