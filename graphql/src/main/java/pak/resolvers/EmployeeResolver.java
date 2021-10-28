package pak.resolvers;

import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;
import pak.entities.Employee;

@Component
public class EmployeeResolver implements GraphQLResolver<Employee> {

    // mapper between entity and graphql dto
    public String getAnotherLazyField(Employee employee) {
        return employee.getFirstName() + ", " + employee.getLastName();
    }

}
