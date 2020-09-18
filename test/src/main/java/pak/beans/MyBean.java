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

@Profile({"dev"})
@Component
public class MyBean implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApplicationContext ctx;

    @Value("${USERNAME:default value}")
    private String userName;

    @Value("${os.version:default value}")
    private String osVersion;

    //@Value("${dev.prop:default value}")
    @Value("${dev.prop:default value}")
    private String devProp;

    //@Value("${dev.prop.2:default value}")
    @Value("${dev.prop.2:default value}")
    private String devProp2;

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
        logger.info("devProp {}", devProp);
        logger.info("devProp2 {}", devProp2);
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
            logger.info("dev.prop {}", environment.getProperty("dev.prop"));
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
