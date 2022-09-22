package pak.beans;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class MyBean implements CommandLineRunner {

    @Autowired
    private ApplicationContext ctx;

    @Value("${USERNAME:default value}")
    private String userName;

    @Value("${os.version:default value}")
    private String osVersion;

    //@Value("${dev.prop:default value}")
    @Value("${dev.prop:default value}")
    private String devProp;

    //@Value("${dev.mixed-prop:default value}")
    @Value("${dev.mixed-prop:default value}")
    private String devMixedProp;

    // SpEL
    @Value("#{systemEnvironment['USERNAME'] ?: 'default value'}")
    private String userNameSpel;

    // SpEL
    @Value("#{systemProperties['os.version'].concat(' SpEL').toUpperCase()}")
    private String osVersionSpel;

    public void run(String... args) {
        log.info("***");
        log.info("userName {}", userName);
        log.info("osVersion {}", osVersion);
        log.info("devProp {}", devProp);
        log.info("devProp2 {}", devMixedProp);
        log.info("userNameSpel {}", userNameSpel);
        log.info("osVersionSpel {}", osVersionSpel);
    }

    @Bean
    public CommandLineRunner printBeans() {
        return args -> {
            log.info("***");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                log.info("bean {}", beanName);
            }
        };
    }

    @Bean
    public CommandLineRunner printProps() {
        return args -> {
            log.info("***");
            Environment environment = ctx.getEnvironment();
            // sys env
            log.info("USERNAME {}", environment.getProperty("USERNAME"));
            // sys prop
            log.info("os.version {}", environment.getProperty("os.version"));
            // app prop
            log.info("dev.prop {}", environment.getProperty("dev.prop"));
        };
    }

    @Bean
    public CommandLineRunner printProfiles(Environment environment) {
        return args -> {
            log.info("***");
            for (String profileName : environment.getActiveProfiles()) {
                log.info("active profile - {}", profileName);
            }
            for (String profileName : environment.getDefaultProfiles()) {
                log.info("default profile - {}", profileName);
            }
        };
    }

}
