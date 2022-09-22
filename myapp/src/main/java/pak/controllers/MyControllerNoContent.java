package pak.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/no-content")
//@ResponseStatus(HttpStatus.NO_CONTENT)
public class MyControllerNoContent {

    @GetMapping
    public ResponseEntity<Void> getNoContent() {
        return ResponseEntity.noContent().build();
    }

}
