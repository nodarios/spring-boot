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

    //@Value("${test.prop}")
    @Value("${test.prop}")
    private String testProp;

    public void run(String... args) {
        logger.info("***");
        logger.info("testProp {}", testProp);
    }

    @Bean
    public CommandLineRunner printBeans() {
        return args -> {
            logger.info("***");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                logger.info("bean {}", beanName);
            }
        };
    }

    @Bean
    public CommandLineRunner printProps() {
        return args -> {
            logger.info("***");
            Environment environment = ctx.getEnvironment();
            // sys env
            logger.info("USERNAME {}", environment.getProperty("USERNAME"));
            // sys prop
            logger.info("os.version {}", environment.getProperty("os.version"));
            // app prop
            logger.info("test.prop {}", environment.getProperty("test.prop"));
        };
    }

    @Bean
    public CommandLineRunner printProfiles(Environment environment) {
        return args -> {
            logger.info("***");
            for (String profileName : environment.getActiveProfiles()) {
                logger.info("active profile - {}", profileName);
            }
            for (String profileName : environment.getDefaultProfiles()) {
                logger.info("default profile - {}", profileName);
            }
        };
    }

}
