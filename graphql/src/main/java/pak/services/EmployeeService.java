package pak.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pak.entities.Employee;
import pak.exception.EntityNotFoundException;
import pak.repositories.EmployeeRepo;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public Employee getEmployee(UUID id) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        } else {
            throw new EntityNotFoundException("employee not found", id);
        }
    }

    public Iterable<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    public Iterable<Employee> getEmployees(Specification<Employee> specification) {
        return employeeRepo.findAll(specification);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteEmployee(UUID id) {
        employeeRepo.deleteById(id);
    }

}
