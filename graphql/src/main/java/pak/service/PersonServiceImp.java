package pak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pak.entity.Person;
import pak.exception.EntityNotFoundException;
import pak.repository.PersonRepo;

import java.util.Optional;

@Service
public class PersonServiceImp implements PersonService {

    private PersonRepo personRepo;

    @Autowired
    public void setPersonRepo(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public Iterable<Person> findPersons() {
        return personRepo.findAll();
    }

    @Override
    public Person findPerson(Long id) {
        Optional<Person> personOpt = personRepo.findById(id);
        if (personOpt.isPresent()) {
            return personOpt.get();
        } else {
            throw new EntityNotFoundException("person not found", id);
        }
    }

    @Override
    public long countPersons() {
        return personRepo.count();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public Person savePerson(Person person) {
        return personRepo.save(person);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void deletePerson(Long id) {
        personRepo.deleteById(id);
    }

}
