package pak.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public GraphQLScalarType graphqlLong() {
        return ExtendedScalars.GraphQLLong;
    }

}
