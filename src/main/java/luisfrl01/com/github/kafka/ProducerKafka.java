package luisfrl01.com.github.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class ProducerKafka {

    @Value("${topico.nome}")
    private String topico;

    @Autowired
    private KafkaTemplate<String, String> template;

    public void enviarMensagem() {
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topico, "meu producer");
        producerRecord.headers().add(new RecordHeader("", "valor".getBytes()));

        template.send(producerRecord).addCallback(new ListenableFutureCallback<>(){
            public void onSuccess(SendResult<String, String> result) {
                log.info("sucesso");
            }

            public void onFailure(Throwable throwable) {
                log.error("erro");
            }
        });
    }
}
