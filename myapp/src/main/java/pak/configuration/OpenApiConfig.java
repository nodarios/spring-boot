package pak.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// http://localhost:8080/swagger-ui/index.html
// http://localhost:8080/v3/api-docs

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI springDocOpenApi() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("title")
                                .description("description")
                                .version("v0.0.1")
                                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                )
                .externalDocs(
                        new ExternalDocumentation()
                                .description("description")
                                .url("http://springdoc.org")
                );
    }

}
