package pak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
//@Import(HelloController.class)
public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        //System.setProperty("spring.devtools.restart.enabled", "false");
        System.setProperty("spring.devtools.restart.additional-paths", ".");
        System.setProperty("spring.devtools.restart.trigger-file", "restart");

        //SpringApplication.run(Application.class, args);
        SpringApplicationBuilder app = new SpringApplicationBuilder(Application.class);
        app.web(WebApplicationType.NONE);
        app.run(args);


        logger.info("hi");
    }

}
