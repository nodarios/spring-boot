package pak.repository;

import org.springframework.data.repository.CrudRepository;
import pak.entity.Student;

public interface StudentRepo extends CrudRepository<Student, Long> {
}
