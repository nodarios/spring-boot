package pak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pak.entities.MyEntity;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface MyRepo extends JpaRepository<MyEntity, Long> {

    //@Query(value = "SELECT f FROM MyEntity f WHERE LOWER(f.name) = LOWER(:name)")
    //@Query(value = "SELECT * FROM MY_ENTITY WHERE APP_NAME = :name", nativeQuery = true)
    Optional<MyEntity> findByName(@Param("name") String name);

    //@Query(name = "MyEntity.searchByOwner")
    List<MyEntity> searchByOwner(@Param("owner") String owner);

    //@Query(name = "MyEntity.searchByDescription", nativeQuery = true)
    List<MyEntity> searchByDescription(@Param("description") String description);

    //@Query(value = "SELECT SYSDATE FROM DUAL", nativeQuery = true)
    //@Query(value = "SELECT SYSDATE()", nativeQuery = true)
    @Query(value = "SELECT CURRENT_TIMESTAMP", nativeQuery = true)
    Instant getDatabaseTime();

}
