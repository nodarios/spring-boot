package pak.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pak.dtos.GreetingDto;
import pak.exception.AppException;
import pak.validators.ValidatorWrapper;

import javax.validation.Valid;

@RestController
@RequestMapping("/validation")
public class MyControllerValidation {

    @PostMapping(path = "/validation")
    public ResponseEntity<GreetingDto> validate(@RequestBody @Valid GreetingDto greetingDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(greetingDto);
    }

    @PostMapping(path = "/validation2")
    public ResponseEntity<GreetingDto> validate2(@RequestBody GreetingDto greetingDto) throws AppException {
        ValidatorWrapper.validate(greetingDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(greetingDto);
    }

}
