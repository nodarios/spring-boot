package pak.datajpa.service;

import pak.datajpa.entity.MyEntity;

public interface MyService {

    void save(MyEntity app);

    Iterable<MyEntity> findAll();

    MyEntity find(long id) throws Exception;

}
