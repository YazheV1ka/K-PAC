package service;

import dao.KPacDao;
import entity.KPac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KPacServiceImpl implements KPacService {
    @Autowired
    public KPacDao kPacDao;

    public List<KPac> findAll() {
        return kPacDao.findAll();
    }

    public KPac getById(int id) {
        return kPacDao.getById(id);
    }

    public void create(KPac kPac) {
        kPacDao.create(kPac);
    }

    public void delete(int id) {
        kPacDao.delete(id);
    }
}
