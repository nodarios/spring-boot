package pak.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pak.dto.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/mcg")
public class MyControllerGreeting {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(name = "suffix", defaultValue = "World") String suffix/*, Greeting greeting*/) {
        return new Greeting(counter.incrementAndGet(), String.format(template, suffix));
        //greeting.setId(counter.incrementAndGet());
        //greeting.setContent(String.format(template, suffix));
        //return greeting;
    }

}
