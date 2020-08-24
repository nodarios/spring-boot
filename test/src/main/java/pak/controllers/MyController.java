package pak.controllers;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/mc")
public class MyController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(path = "/{id}/{id2}/cust", method = RequestMethod.GET)
    public Long getUser(@PathVariable Long id, @PathVariable Long id2, @RequestParam(name = "custId", defaultValue = "100") Long custId) {
        return id + id2 + custId;
    }

    @RequestMapping(path = "/targets-0.2.jar", method = RequestMethod.GET)
    public void downloadJar(HttpServletResponse response) throws IOException {
        Path path = Paths.get("C:\\Users\\nosakvarelidze\\Downloads\\", "targets-0.2.jar");
        Files.copy(path, response.getOutputStream());
        response.getOutputStream().flush();
    }

}
