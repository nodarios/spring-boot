package pak;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
//@Import(HelloController.class)
public class Application {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "true");
        System.setProperty("spring.devtools.restart.additional-paths", ".");
        System.setProperty("spring.devtools.restart.trigger-file", "restart");
        //System.setProperty("https.proxyHost", "proxy.loc");
        //System.setProperty("https.proxyPort", "3128");

        //SpringApplication.run(MyEntity.class, args);
        SpringApplicationBuilder app = new SpringApplicationBuilder(Application.class);
        //app.web(WebApplicationType.NONE);
        app.run(args);
    }

}
