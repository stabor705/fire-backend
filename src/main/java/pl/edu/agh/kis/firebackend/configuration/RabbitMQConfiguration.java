package pl.edu.agh.kis.firebackend.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    private final Logger log = LoggerFactory.getLogger(RabbitMQConfiguration.class);

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setRoutingKey(DeclaredQueues.CAMERA_QUEUE_NAME);
        return template;
    }

//    @Bean
//    public SimpleMessageListenerContainer listenerContainer() {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory());
//        container.setQueueNames(DeclaredQueues.CAMERA_QUEUE_NAME);
//        container.setMessageListener(new MessageListenerAdapter() {
//            public void handleMessage(Camera camera) {
//                log.error("{}", camera.cameraId());
//            }
//        });
//        return container;
//    }

    @Bean
    public Queue myQueue() {
        return new Queue(DeclaredQueues.CAMERA_QUEUE_NAME);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
