package pak.schedulers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pak.dtos.MyEventDto;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "app.scheduler.kafka-scheduler", name = "enabled", havingValue = "true")
public class KafkaScheduler {

    private final StreamBridge streamBridge;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final AtomicLong counter = new AtomicLong();

    @Async
    @Scheduled(
            initialDelayString = "${app.scheduler.kafka-scheduler.initial-delay}",
            fixedDelayString = "${app.scheduler.kafka-scheduler.fixed-delay}")
    public void feed() throws JsonProcessingException {
        if (counter.get() % 2 == 0) {
            feedIngressChannel();
        } else {
            feedIngressTopic();
        }
    }

    private void feedIngressChannel() {
        var myEventDto = new MyEventDto("hello");
        String key = Long.toString(counter.incrementAndGet());
        Message<MyEventDto> message = MessageBuilder
                .withPayload(myEventDto)
                .setHeader(KafkaHeaders.RECEIVED_MESSAGE_KEY, key).build();

        streamBridge.send("myEventConsumerProducer-in-0", message);
        log.info("ingress channel populated with key {}: {}", key, myEventDto);
    }

    private void feedIngressTopic() throws JsonProcessingException {
        String myEventString = objectMapper.writeValueAsString(new MyEventDto("hello"));
        String key = Long.toString(counter.incrementAndGet());
        Message<String> message = MessageBuilder
                .withPayload(myEventString)
                .setHeader(KafkaHeaders.MESSAGE_KEY, key)
                .setHeader(KafkaHeaders.TOPIC, "my.event.ingress.topic").build();

        kafkaTemplate
                .send(message)
                .addCallback(
                        result -> log.info("ingress topic populated: {}", result),
                        ex -> log.error("failed to send message", ex)
                );
    }

}
