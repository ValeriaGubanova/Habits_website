package com.javapoint.habits.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("15672:15672"); // указываем адрес RabbitMQ
    }
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setExchange("habits.Topic");
        rabbitTemplate.setRoutingKey("habit-alert");
        return rabbitTemplate;
    }
    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }
    @Bean
    public Queue setQueue() {
        return new Queue("habit-alert");
    }
    @Bean
    DirectExchange exchange() {
        return new DirectExchange("testExchange", true, false);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("testRoutingKey");
    }
}
