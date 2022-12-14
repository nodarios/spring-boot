package pak.resolvers;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pak.entities.Department;
import pak.services.DepartmentService;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DepartmentQueryResolver implements GraphQLQueryResolver {

    private final DepartmentService departmentService;

    public Department getDepartment(UUID id) {
        return departmentService.getDepartment(id);
    }

    public Iterable<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    public long getDepartmentCount() {
        return departmentService.getDepartmentCount();
    }

}
