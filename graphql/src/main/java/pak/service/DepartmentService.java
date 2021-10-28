package pak.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pak.entity.Department;
import pak.exception.EntityNotFoundException;
import pak.repository.DepartmentRepo;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentService {

    private final DepartmentRepo departmentRepo;

    public Department getDepartment(UUID id) {
        Optional<Department> departmentOptional = departmentRepo.findById(id);
        if (departmentOptional.isPresent()) {
            return departmentOptional.get();
        } else {
            throw new EntityNotFoundException("person not found", id);
        }
    }

    public Iterable<Department> getDepartments() {
        return departmentRepo.findAll();
    }

    public long getDepartmentCount() {
        return departmentRepo.count();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Department addDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Department updateDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteDepartment(UUID id) {
        departmentRepo.deleteById(id);
    }

}
