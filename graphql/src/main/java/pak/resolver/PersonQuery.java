package pak.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pak.entity.Person;
import pak.service.PersonService;

import java.util.Date;

@Component
public class PersonQuery implements GraphQLQueryResolver {

    private PersonService personService;

    @Autowired
    public PersonQuery(PersonService personService) {
        this.personService = personService;
    }

    public Iterable<Person> findPersons() {
        return personService.findPersons();
    }

    public Person findPerson(Long id) {
        return personService.findPerson(id);
    }

    public long countPersons() {
        return personService.countPersons();
    }

    public String getDate() {
        return new Date().toString();
    }

}
