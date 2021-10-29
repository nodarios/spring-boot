package pak.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pak.dtos.GreetingDto;
import pak.dtos.GreetingPojo;
import pak.enums.Country;
import pak.mappers.GreetingMapper;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/mcg")
@RequiredArgsConstructor
public class MyControllerGreeting {

    private final GreetingMapper greetingMapper;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/greeting", method = RequestMethod.GET)
    public GreetingDto greeting(@RequestParam(name = "suffix", defaultValue = "World") String suffix, GreetingPojo greetingPojo) {


        greetingPojo.setId(counter.incrementAndGet());
        greetingPojo.setContent(String.format(template, suffix));
        greetingPojo.setCountry(Country.GEO);


        GreetingDto greetingDto = greetingMapper.mapPojoToDto(greetingPojo);
        return greetingDto;
    }

}
