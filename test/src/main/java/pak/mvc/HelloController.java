package pak.mvc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/{user}/cust", method = RequestMethod.GET)
    public Long getUser(@PathVariable Long user) {
        return user;
    }

    @RequestMapping("/targets-0.2.jar")
    public void downloadPDFResource(HttpServletResponse response) throws IOException {
        Path path = Paths.get("C:\\Users\\nosakvarelidze\\Downloads\\", "targets-0.2.jar");
        Files.copy(path, response.getOutputStream());
        response.getOutputStream().flush();
    }

}
