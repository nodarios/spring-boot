package pak.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Profile("testa")
@Component
public class MyBean implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApplicationContext ctx;

    //@Value("hello")
    @Value("${test.prop}")
    private String myProp;

    public void run(String... args) {
        logger.info(myProp);

        logger.info("***");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            logger.info(beanName);
        }
        logger.info("***");
    }

    @Bean
    public CommandLineRunner commandLineRunner(Environment environment) {
        return args -> {
            for (String profileName : environment.getActiveProfiles()) {
                logger.info("active profile - " + profileName);
            }
            for (String profileName : environment.getDefaultProfiles()) {
                logger.info("default profile - " + profileName);
            }
        };
    }

}
