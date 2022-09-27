package pak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pak.entities.MyEntity;
import pak.exception.AppException;
import pak.services.MyService;

import java.util.List;

@RestController
@RequestMapping("/db")
public class MyControllerDb {

    @Autowired
    private MyService myService;

    @PostMapping("/my-entities")
    public MyEntity addMyEntity(@RequestBody MyEntity myEntity) {
        return myService.save(myEntity);
    }

    @PutMapping("/my-entities")
    public MyEntity updateMyEntity(@RequestBody MyEntity myEntity) {
        return myService.save(myEntity);
    }

    @DeleteMapping("/my-entities/{id}")
    public void deleteMyEntity(@PathVariable Long id) {
        myService.deleteById(id);
    }

    @GetMapping("/my-entities")
    public Iterable<MyEntity> getMyEntities() {
        return myService.findAll();
    }

    @GetMapping("/my-entities/{id}")
    public MyEntity getMyEntity(@PathVariable Long id) throws AppException {
        return myService.findById(id);
    }

    // TODO refactor remaining methods

    @GetMapping(path = "/entity/name/{name}")
    public ResponseEntity<List<MyEntity>> getEntityByName(@PathVariable("name") String name) {
        try {
            return new ResponseEntity<>(myService.findByName(name), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping(path = "/entity/owner/{owner}")
    public List<MyEntity> getEntityByOwner(@PathVariable("owner") String owner) {
        return myService.searchByOwner(owner);
    }

    @GetMapping(path = "/entity/description/{description}")
    public List<MyEntity> getEntityByDescription(@PathVariable("description") String description) {
        return myService.searchByDescription(description);
    }

}
