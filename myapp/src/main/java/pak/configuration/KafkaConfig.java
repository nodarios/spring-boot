package pak.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import pak.dtos.MyEventDto;
import pak.messaging.MyEventProcessor;
import pak.dtos.MyEventResultDto;

import java.util.function.Function;

@Configuration
public class KafkaConfig {

    @Bean
    public Function<Message<MyEventDto>, Message<MyEventResultDto>> myEventConsumerProducer(
            MyEventProcessor myEventProcessor) {
        return myEventProcessor::processMyEvent;
    }

}
