package pak.schedulers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import pak.properties.MySchedulerProperties;

@Slf4j
@Component
@ConditionalOnProperty(prefix = "app.scheduler.my-scheduler", name = "enabled", havingValue = "true")
@RequiredArgsConstructor
public class MyScheduler {

    private final ApplicationContext ctx;
    private final MySchedulerProperties mySchedulerProperties;

    @Async
    @Scheduled(initialDelayString = "${app.scheduler.my-scheduler.initial-delay}",
            fixedDelayString = "${app.scheduler.my-scheduler.fixed-delay}")
    public void myTask() {
        ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) ctx.getBean("applicationTaskExecutor");
        log.info("*************");
        log.info("{}", executor.getClass().getName());
        log.info("{}", executor.getCorePoolSize());
        log.info("thread id: {}", Thread.currentThread().getId());
        log.info("initialDelay: {}, fixedDelay: {}",
                mySchedulerProperties.getInitialDelay(), mySchedulerProperties.getFixedDelay());
    }

}
