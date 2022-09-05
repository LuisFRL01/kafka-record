package luisfrl01.com.github.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerKafka {

    @KafkaListener(topics = "${topico.nome}")
    public void ler(ConsumerRecord<String, String> consumerRecord) {
        log.info("valor {} offset {} particao {} chave {}", consumerRecord.value(), consumerRecord.offset(),
                consumerRecord.partition(), consumerRecord.key());
    }
}
