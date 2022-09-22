package pak.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.scheduler")
@Getter
@Setter
public class SchedulerProperties {

    /**
     * Enables app-wide scheduling.
     */
    private boolean enabled;

}
