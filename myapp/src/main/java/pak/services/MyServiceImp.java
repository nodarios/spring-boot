package pak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pak.entities.MyEntity;
import pak.repositories.MyRepo;

import java.util.List;
import java.util.Optional;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MyServiceImp implements MyService {

    @Autowired
    MyRepo repo;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public MyEntity save(MyEntity app) {
        return repo.save(app);
        //int i = 10/0;
    }

    @Transactional(readOnly = true)
    public Iterable<MyEntity> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public MyEntity findById(long id) throws Exception {
        Optional<MyEntity> opt = repo.findById(id);

        if (opt.isPresent())
            return opt.get();
        else
            throw new Exception("MyEntity Not Found");
    }

    @Override
    @Transactional(readOnly = true)
    public List<MyEntity> findByName(String name) throws Exception {
        Optional<List<MyEntity>> opt = repo.findByName(name);

        if (opt.isPresent())
            return opt.get();
        else
            throw new Exception("MyEntity Not Found");
    }

    @Override
    @Transactional(readOnly = true)
    public List<MyEntity> searchByOwner(String owner) {
        return repo.searchByOwner(owner);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MyEntity> searchByDescription(String description) {
        return repo.searchByDescription(description);
    }


}
