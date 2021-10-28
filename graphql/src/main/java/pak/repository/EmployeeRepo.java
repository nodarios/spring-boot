package pak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pak.entity.Employee;

import java.util.UUID;

public interface EmployeeRepo extends JpaRepository<Employee, UUID>, JpaSpecificationExecutor<Employee> {
}
