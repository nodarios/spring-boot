package pak.service;

import pak.entity.MyEntity;

import java.util.List;

public interface MyService {

    MyEntity save(MyEntity app);

    Iterable<MyEntity> findAll();

    MyEntity findById(long id) throws Exception;

    List<MyEntity> findByName(String name) throws Exception;

    List<MyEntity> searchByOwner(String owner);

    List<MyEntity> searchByDescription(String description);

}
