package pak.controllers;

import org.springframework.web.bind.annotation.*;
import pak.exception.AppException;
import pak.exception.ErrorCodeType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/mc")
public class MyController {

    @GetMapping(path = "/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping(path = "/error")
    public void error() throws AppException {
        throw new AppException(ErrorCodeType.ENTITY_NOT_FOUND);
    }

    @GetMapping(path = "/{id}/{id2}/cust")
    public Long getUser(@PathVariable Long id, @PathVariable Long id2, @RequestParam Long custId) {
        return id + id2 + custId;
    }

    @GetMapping(path = "/targets-0.2.jar")
    public void downloadJar(HttpServletResponse response) throws IOException {
        Path path = Paths.get("C:\\Users\\nosakvarelidze\\Downloads\\", "targets-0.2.jar");
        Files.copy(path, response.getOutputStream());
        response.getOutputStream().flush();
    }

}
