package pak.datajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pak.datajpa.entity.MyEntity;
import pak.datajpa.repository.MyRepo;

import java.util.List;
import java.util.Optional;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MyServiceImp implements MyService {

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

    public MyEntity findById(long id) throws Exception {
        Optional<MyEntity> opt = repo.findById(id);

        if (opt.isPresent())
            return opt.get();
        else
            throw new Exception("MyEntity Not Found");
    }

    @Override
    public List<MyEntity> findByName(String name) throws Exception {
        Optional<List<MyEntity>> opt = repo.findByName(name);

        if (opt.isPresent())
            return opt.get();
        else
            throw new Exception("MyEntity Not Found");
    }

    @Override
    public List<MyEntity> searchByOwner(String owner) {
        return repo.searchByOwner(owner);
    }

    @Override
    public List<MyEntity> searchByDescription(String description) {
        return repo.searchByDescription(description);
    }


}
