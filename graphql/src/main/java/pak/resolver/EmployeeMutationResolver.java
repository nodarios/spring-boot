package pak.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pak.entity.Employee;
import pak.service.EmployeeService;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeeMutationResolver implements GraphQLMutationResolver {

    private final EmployeeService employeeService;

    public Employee addEmployee(Employee employee) {
        return employeeService.addEmployee(employee);
    }

    public boolean deleteEmployee(UUID id) {
        employeeService.deleteEmployee(id);
        return true;
    }

}
