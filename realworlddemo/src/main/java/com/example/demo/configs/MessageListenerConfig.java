package com.example.demo.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import com.example.demo.messaging.MessagingApplication;


@Component
public class MessageListenerConfig implements RabbitListenerConfigurer {

	@Bean
	public TopicExchange appExchange() {
		return new TopicExchange(MessagingApplication.EXCHANGE_NAME);
	}

	@Bean
	public Queue appQueueGeneric() {
		return new Queue(MessagingApplication.QUEUE_GENERIC_NAME);
	}

	@Bean
	public Queue appQueueSpecific() {
		return new Queue(MessagingApplication.QUEUE_SPECIFIC_NAME);
	}

	@Bean
	public Binding declareBindingGeneric() {
		return BindingBuilder.bind(appQueueGeneric()).to(appExchange()).with(MessagingApplication.ROUTING_KEY);
	}

	@Bean
	public Binding declareBindingSpecific() {
		return BindingBuilder.bind(appQueueSpecific()).to(appExchange()).with(MessagingApplication.ROUTING_KEY);
	}

	
	// You can comment all methods below and remove interface's implementation to use the default serialization / deserialization
		@Bean
		public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
			final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
			rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
			return rabbitTemplate;
		}

		@Bean
		public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
			return new Jackson2JsonMessageConverter();
		}

		@Bean
		public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
			return new MappingJackson2MessageConverter();
		}

		@Bean
		public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
			DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
			factory.setMessageConverter(consumerJackson2MessageConverter());
			return factory;
		}

		@Override
		public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
			registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
		}
	
	

}
