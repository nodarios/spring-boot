package pak.datajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pak.datajpa.entity.MyEntity;
import pak.datajpa.service.MyService;

@Profile("test-data-jpa")
@Component
public class Test {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public CommandLineRunner demo(/*MyRepo repository*/MyService svc) {
        return (args) -> {
            svc.save(new MyEntity("name", "owner", "desc"));

            for (MyEntity ent : svc.findAll()) {
                logger.info("The entity is: " + ent.toString());
            }
        };
    }

}
