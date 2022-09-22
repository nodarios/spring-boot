package pak.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pak.annotation.MyAnnotation;
import pak.dtos.GreetingDto;
import pak.dtos.GreetingPojo;
import pak.enums.Country;
import pak.mappers.GreetingMapper;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
@RequiredArgsConstructor
public class MyControllerGreeting {

    private final GreetingMapper greetingMapper;

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    @MyAnnotation
    public GreetingDto greeting(@RequestParam(name = "suffix", defaultValue = "World") String suffix, GreetingPojo greetingPojo) {
        greetingPojo.setId(counter.incrementAndGet());
        greetingPojo.setContent(String.format(TEMPLATE, suffix));
        greetingPojo.setCountry(Country.GEO);

        return greetingMapper.mapPojoToDto(greetingPojo);
    }

}
