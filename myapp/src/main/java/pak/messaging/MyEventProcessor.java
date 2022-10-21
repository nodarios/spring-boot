package pak.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import pak.dtos.MyEventDto;
import pak.dtos.MyEventResultDto;

import java.util.Optional;

@Slf4j
@Component
public class MyEventProcessor {

    public Message<MyEventResultDto> processMyEvent(Message<MyEventDto> message) {
        MyEventDto myEventDto = message.getPayload();
        var key = extractHeader(message.getHeaders(), KafkaHeaders.RECEIVED_MESSAGE_KEY);
        log.info("received message with key {}: {}", key, myEventDto);

        var myEventResultDto = new MyEventResultDto("enriched " + myEventDto.getContent());
        return MessageBuilder
                .withPayload(myEventResultDto)
                .setHeader(KafkaHeaders.MESSAGE_KEY, key).build();
    }

    private String extractHeader(MessageHeaders messageHeaders, String key) {
        return Optional.ofNullable(messageHeaders.get(key))
                .map(Object::toString)
                .orElse(null);
    }

}
