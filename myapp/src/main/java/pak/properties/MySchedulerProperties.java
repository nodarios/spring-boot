package pak.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.scheduler.my-scheduler")
@Getter
@Setter
public class MySchedulerProperties {

    /**
     * Enables MyScheduler.
     */
    private boolean enabled;

    /**
     * MyScheduler init delay.
     */
    private String initialDelay;

    /**
     * MyScheduler fixed delay.
     */
    private String fixedDelay;



}
