package pak.service;

import pak.entity.Person;

public interface PersonService {

    Iterable<Person> findPersons();
    Person findPerson(Long id);
    long countPersons();

    Person savePerson(Person person);
    void deletePerson(Long id);

}
