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
        for (int i = 0; i < 100; i++) {
            Thread.sleep(3000);
            Tag tag = (i % 2 == 0) ? Tag.of("my-tag", "even") : Tag.of("my-tag", "odd");
            meterRegistry.counter("mm.my-metric.total", Tags.of(tag)).increment();
            log.info("incremented");
        }

    }
}
