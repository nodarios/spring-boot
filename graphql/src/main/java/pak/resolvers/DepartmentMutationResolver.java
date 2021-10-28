package pak.resolvers;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pak.entities.Department;
import pak.services.DepartmentService;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DepartmentMutationResolver implements GraphQLMutationResolver {

    private final DepartmentService departmentService;

    public Department addDepartment(String name) {
        Department department = Department
                .builder()
                .name(name)
                .build();
        return departmentService.addDepartment(department);
    }

    public Department updateDepartment(Department department) {
        return departmentService.updateDepartment(department);
    }

    public boolean deleteDepartment(UUID id) {
        departmentService.deleteDepartment(id);
        return true;
    }

}
