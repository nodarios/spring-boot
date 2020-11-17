package pak;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
//@Import(HelloController.class)
public class Application {

    public static void main(String[] args) {
        //System.setProperty("https.proxyHost", "proxy.loc");
        //System.setProperty("https.proxyPort", "3128");

        //SpringApplication.run(Application.class, args);
        SpringApplicationBuilder app = new SpringApplicationBuilder(Application.class);
        //app.web(WebApplicationType.NONE);
        ConfigurableApplicationContext ctx = app.run(args);
    }

}
