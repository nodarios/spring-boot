package pak.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pak.entity.Person;
import pak.service.PersonService;

@Component
public class PersonMutation implements GraphQLMutationResolver {

    private PersonService personService;

    @Autowired
    public PersonMutation(PersonService personService) {
        this.personService = personService;
    }

    public Person addPerson(String personId) {
        Person person = new Person(personId);
        return personService.savePerson(person);
    }

    public boolean deletePerson(Long id) {
        personService.deletePerson(id);
        return true;
    }

    public Person updatePerson(String personId, Long id) {
        Person person = personService.findPerson(id);
        person.setPersonId(personId);
        return personService.savePerson(person);
    }

}
