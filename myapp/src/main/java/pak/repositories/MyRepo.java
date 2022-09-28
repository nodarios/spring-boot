package pak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pak.entities.MyEntity;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface MyRepo extends JpaRepository<MyEntity, Long> {

    //@Query(value = "select e from MyEntity e where lower(e.name) = lower(:name)")
    //@Query(value = "select * from my_entity e where e.name = :name", nativeQuery = true)
    Optional<MyEntity> findByName(@Param("name") String name);

    //@Query(name = "my-entity.search-by-info")
    //@Query(name = "my-entity.search-by-info2", nativeQuery = true)
    List<MyEntity> searchByInfo(@Param("info") String info);

    //@Query(value = "SELECT SYSDATE FROM DUAL", nativeQuery = true)
    //@Query(value = "SELECT SYSDATE()", nativeQuery = true)
    @Query(value = "SELECT CURRENT_TIMESTAMP", nativeQuery = true)
    Instant getDatabaseTime();

}
