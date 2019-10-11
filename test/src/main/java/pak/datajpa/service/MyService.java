package pak.datajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pak.datajpa.entity.MyEntity;
import pak.datajpa.repository.MyRepo;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MyService {

    @Autowired
    MyRepo repo;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void save(MyEntity app) {
        repo.save(app);
        //int i = 10/0;
    }

    public Iterable<MyEntity> findAll() {
        return repo.findAll();
    }

}
