package com.sprinng.NotificationService.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    private String exchangeName = "productExchange";
    private String registerqueuename = "Product-queue";

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchangeName);

    }

    @Bean
    public Queue getQueue(){
        return new Queue(registerqueuename);
    }

    @Bean
    public Jackson2JsonMessageConverter getProducerJacksonConverter(){
        return new Jackson2JsonMessageConverter();
    }



    @Bean
    public Binding getBinding(Queue queue, DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("product_queue");
    }
}
