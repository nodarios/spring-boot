package pak.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import pak.entity.Department;
import pak.entity.Employee;
import pak.service.EmployeeService;

import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeeQueryResolver implements GraphQLQueryResolver {

    private final EmployeeService employeeService;

    public Employee getEmployee(UUID id) {
        return employeeService.getEmployee(id);
    }

    public Iterable<Employee> getEmployees(DataFetchingEnvironment environment) {
        boolean isDepartmentSelected = environment.getSelectionSet().contains("department");
        if (isDepartmentSelected) {
            Specification<Employee> employeeWithDepartment = (root, query, criteriaBuilder) -> {
                // left join fetch: fetches the related entities in a single query
                Fetch<Employee, Department> fetch = root.fetch("department", JoinType.LEFT);
                Join<Employee, Department> join = (Join<Employee, Department>) fetch;
                return join.getOn();
            };
            return employeeService.getEmployees(employeeWithDepartment);
        } else {
            return employeeService.getEmployees();
        }
    }

}
