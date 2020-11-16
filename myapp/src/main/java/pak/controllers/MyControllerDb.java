package pak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pak.entity.MyEntity;
import pak.service.MyService;

import java.util.List;

@RestController
@RequestMapping("/mcdb")
public class MyControllerDb {

    @Autowired
    private MyService svc;

    @RequestMapping(path = "/entity/add", method = RequestMethod.POST/*method = RequestMethod.PUT*/)
    public MyEntity addEntity(@RequestBody MyEntity myEntity) throws Exception {
        return svc.save(myEntity);
    }

    @RequestMapping(path = "/entity/addWithName", method = RequestMethod.GET)
    public MyEntity addEntity(@RequestParam(name = "name", defaultValue = "default_name") String name) {
        return svc.save(new MyEntity(name, "default_owner", "default_desc"));
    }

    @RequestMapping(path = "/entity", method = RequestMethod.GET)
    public Iterable<MyEntity> getEntities() {
        return svc.findAll();
    }

    @RequestMapping(path = "/entity/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<MyEntity> getEntityById(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(svc.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @RequestMapping(path = "/entity/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<MyEntity>> getEntityByName(@PathVariable("name") String name) {
        try {
            return new ResponseEntity<>(svc.findByName(name), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @RequestMapping(path = "/entity/owner/{owner}", method = RequestMethod.GET)
    public List<MyEntity> getEntityByOwner(@PathVariable("owner") String owner) {
        return svc.searchByOwner(owner);
    }

    @RequestMapping(path = "/entity/description/{description}", method = RequestMethod.GET)
    public List<MyEntity> getEntityByDescription(@PathVariable("description") String description) {
        return svc.searchByDescription(description);
    }

}
