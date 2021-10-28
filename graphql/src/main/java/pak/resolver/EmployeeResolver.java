package pak.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;
import pak.entity.Employee;

@Component
public class EmployeeResolver implements GraphQLResolver<Employee> {

    public String getAnotherLazyField(Employee employee) {
        return employee.getFirstName() + ", " + employee.getLastName();
    }

}
