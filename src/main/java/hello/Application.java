package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;


@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
//@Import(HelloController.class)
public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private static ApplicationContext ctx;

    public static void main(String[] args) {
        //System.setProperty("spring.devtools.restart.enabled", "false");
        System.setProperty("spring.devtools.restart.additional-paths", ".");
        System.setProperty("spring.devtools.restart.trigger-file", "restart");

        //SpringApplication.run(Application.class, args);
        SpringApplicationBuilder app = new SpringApplicationBuilder(Application.class);
        //app.web(WebApplicationType.NONE);
        app.run(args);

        logger.info("***");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            logger.info(beanName);
        }
        logger.info("***");
    }

}
