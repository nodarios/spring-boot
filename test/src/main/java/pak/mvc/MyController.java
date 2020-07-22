package pak.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pak.datajpa.entity.MyEntity;
import pak.datajpa.service.MyService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/mc")
public class MyController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(path = "/{id}/{id2}/cust", method = RequestMethod.GET)
    public Long getUser(@PathVariable Long id, @PathVariable Long id2) {
        return id + id2;
    }

    @RequestMapping(path = "/targets-0.2.jar", method = RequestMethod.GET)
    public void downloadJar(HttpServletResponse response) throws IOException {
        Path path = Paths.get("C:\\Users\\nosakvarelidze\\Downloads\\", "targets-0.2.jar");
        Files.copy(path, response.getOutputStream());
        response.getOutputStream().flush();
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(name = "suffix", defaultValue = "World") String suffix/*, Greeting greeting*/) {
        return new Greeting(counter.incrementAndGet(), String.format(template, suffix));
        //greeting.setId(counter.incrementAndGet());
        //greeting.setContent(String.format(template, suffix));
        //return greeting;
    }

    @Autowired
    private MyService svc;

    @RequestMapping(path = "/entity/add", method = RequestMethod.GET)
    public String addEntity(@RequestParam(name = "name", defaultValue = "default_name") String name) {
        svc.save(new MyEntity(name, "default_owner", "default_desc"));
        return "added " + name;
    }

    @RequestMapping(path = "/entity", method = RequestMethod.GET)
    public Iterable<MyEntity> getEntities() {
        return svc.findAll();
    }

    @RequestMapping(path = "/entity/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<MyEntity> getEntityById(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<MyEntity>(svc.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @RequestMapping(path = "/entity/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<MyEntity>> getEntityByName(@PathVariable("name") String name) {
        try {
            return new ResponseEntity<List<MyEntity>>(svc.findByName(name), HttpStatus.OK);
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
