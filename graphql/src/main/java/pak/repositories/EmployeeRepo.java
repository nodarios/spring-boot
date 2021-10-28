package pak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pak.entities.Employee;

import java.util.UUID;

public interface EmployeeRepo extends JpaRepository<Employee, UUID>, JpaSpecificationExecutor<Employee> {
}
