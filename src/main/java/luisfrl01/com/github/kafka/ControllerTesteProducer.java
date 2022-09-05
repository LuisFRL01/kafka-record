package luisfrl01.com.github.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka-teste")
public class ControllerTesteProducer {

    @Autowired
    ProducerKafka producerKafka;

    @GetMapping
    public void testarProducerkafka() {
        producerKafka.enviarMensagem();
    }
}
