package pak.mvc;

import io.swagger.annotations.Api;
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
