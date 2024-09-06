package io.microservice.SD.msavaliadorcredito.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queues.emissao-cartoes}")
    private String emissaoCartoesFila;

    @Bean // se não colocarmos esse bean, ele nao registra a mensagea no contenier
    public Queue queueEmissaoCartoes(){ // registrando no contener
        return new Queue( emissaoCartoesFila , true);
    }
}