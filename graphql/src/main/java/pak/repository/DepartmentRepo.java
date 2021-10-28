package pak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pak.entity.Department;

import java.util.UUID;

public interface DepartmentRepo extends JpaRepository<Department, UUID> {
}
