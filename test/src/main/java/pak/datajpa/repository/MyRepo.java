package pak.datajpa.repository;

import org.springframework.data.repository.CrudRepository;
import pak.datajpa.entity.MyEntity;

public interface MyRepo extends CrudRepository<MyEntity, Long> {
}
