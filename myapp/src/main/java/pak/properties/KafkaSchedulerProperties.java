package pak.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.scheduler.kafka-scheduler")
@Getter
@Setter
public class KafkaSchedulerProperties {

    /**
     * Enables KafkaScheduler.
     */
    private boolean enabled;

    /**
     * KafkaScheduler init delay.
     */
    private String initialDelay;

    /**
     * KafkaScheduler fixed delay.
     */
    private String fixedDelay;

}
