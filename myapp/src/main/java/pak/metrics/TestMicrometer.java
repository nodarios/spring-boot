package pak.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"dev3"})
@Slf4j
@Component
@RequiredArgsConstructor
public class TestMicrometer implements CommandLineRunner {

    private final MeterRegistry meterRegistry;

    @Override
    public void run(String... args) throws InterruptedException {
        while (true) {
            Thread.sleep(3000);
            Tag tag = Tag.of("tagKey", "tagValue");
            meterRegistry.counter("mm.my.metric", Tags.of(tag)).increment();
            log.info("incremented");
        }

    }
}
