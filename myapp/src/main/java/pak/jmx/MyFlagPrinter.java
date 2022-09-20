package pak.jmx;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"dev2"})
@Component
@RequiredArgsConstructor
@Slf4j
public class MyFlagPrinter implements CommandLineRunner {

    private final MyFlag myFlag;

    @Override
    public void run(String... args) throws InterruptedException {
        while (true) {
            Thread.sleep(3000);
            log.info("myFlag status: {}", myFlag.getStatus());
        }
    }

}
