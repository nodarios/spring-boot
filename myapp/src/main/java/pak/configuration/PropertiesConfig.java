package pak.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import pak.properties.KafkaSchedulerProperties;
import pak.properties.MySchedulerProperties;
import pak.properties.SchedulerProperties;

@Configuration
@EnableConfigurationProperties({SchedulerProperties.class, MySchedulerProperties.class, KafkaSchedulerProperties.class})
public class PropertiesConfig {
}
