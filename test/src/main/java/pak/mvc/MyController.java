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
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/mc")
public class MyController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/{id}/{id2}/cust", method = RequestMethod.GET)
    public Long getUser(@PathVariable Long id, @PathVariable Long id2) {
        return id + id2;
    }

    @RequestMapping("/targets-0.2.jar")
    public void downloadJar(HttpServletResponse response) throws IOException {
        Path path = Paths.get("C:\\Users\\nosakvarelidze\\Downloads\\", "targets-0.2.jar");
        Files.copy(path, response.getOutputStream());
        response.getOutputStream().flush();
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name, Greeting greeting) {
        //return new Greeting(counter.incrementAndGet(), String.format(template, name));
        greeting.setId(counter.incrementAndGet());
        greeting.setContent(String.format(template, name));
        return greeting;
    }

    @Autowired
    private MyService svc;

    @RequestMapping("/entity")
    public Iterable<MyEntity> getEntity() {
        return svc.findAll();
    }

    @RequestMapping("/entity/{id}")
    public ResponseEntity<MyEntity> getEntity(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<MyEntity>(svc.find(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @RequestMapping("/entity/add")
    public String setEntity(@RequestParam(value = "name", defaultValue = "default_name") String name) {
        svc.save(new MyEntity(name, "default_owner", "default_desc"));
        return "added " + name;
    }

}
