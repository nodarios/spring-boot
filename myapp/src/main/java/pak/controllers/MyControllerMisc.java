package pak.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pak.enums.ErrorType;
import pak.exception.AppException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/misc")
public class MyControllerMisc {

    @GetMapping(path = "/")
    public String getString() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping(path = "/error")
    public void getError() {
        throw new AppException(ErrorType.BAD_REQUEST);
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
