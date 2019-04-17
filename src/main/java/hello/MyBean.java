package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Profile("test")
@Component
public class MyBean implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //@Value("hello")
    @Value("${test.prop}")
    private String myProp;

    public void run(String... args) {
        logger.info(myProp);
        for (int i = 0; i < 3; i++) {
            logger.info(Integer.toString(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            logger.info("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
            logger.info("Let's inspect the beans provided by Spring Boot:");
        };
    }

}
