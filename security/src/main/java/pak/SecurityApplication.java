package pak;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@Slf4j
@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder app = new SpringApplicationBuilder(SecurityApplication.class);
        app.run(args);
    }

}
