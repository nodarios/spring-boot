package pak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pak.entities.Department;

import java.util.UUID;

public interface DepartmentRepo extends JpaRepository<Department, UUID> {
}
