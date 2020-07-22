package pak.datajpa.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pak.datajpa.entity.MyEntity;

import java.util.List;

public interface MyService {

    void save(MyEntity app);

    Iterable<MyEntity> findAll();

    MyEntity findById(long id) throws Exception;

    List<MyEntity> findByName(String name) throws Exception;

    List<MyEntity> searchByOwner(String owner);

    List<MyEntity> searchByDescription(String description);

}
