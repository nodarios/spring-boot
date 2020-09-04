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

@Profile({"test"})
@Component
public class MyBean implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApplicationContext ctx;

    @Value("${USERNAME:default value}")
    private String userName;

    @Value("${os.version:default value}")
    private String osVersion;

    //@Value("${test.prop:default value}")
    @Value("${test.prop:default value}")
    private String testProp;

    //@Value("${test.prop.2:default value}")
    @Value("${test.prop.2:default value}")
    private String testProp2;

    // SpEL
    @Value("#{systemEnvironment['USERNAME'] ?: 'default value'}")
    private String userNameSpel;

    // SpEL
    @Value("#{systemProperties['os.version'].concat(' SpEL').toUpperCase()}")
    private String osVersionSpel;

    public void run(String... args) {
        logger.info("***");
        logger.info("userName {}", userName);
        logger.info("osVersion {}", osVersion);
        logger.info("testProp {}", testProp);
        logger.info("testProp2 {}", testProp2);
        logger.info("userNameSpel {}", userNameSpel);
        logger.info("osVersionSpel {}", osVersionSpel);
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
