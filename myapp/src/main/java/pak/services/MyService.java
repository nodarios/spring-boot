package pak.services;

import pak.entities.MyEntity;
import pak.exception.AppException;

import java.util.List;

public interface MyService {

    MyEntity save(MyEntity app);

    void deleteById(Long id);

    Iterable<MyEntity> findAll();

    MyEntity findById(long id) throws AppException;

    List<MyEntity> findByName(String name) throws Exception;

    List<MyEntity> searchByOwner(String owner);

    List<MyEntity> searchByDescription(String description);

}
