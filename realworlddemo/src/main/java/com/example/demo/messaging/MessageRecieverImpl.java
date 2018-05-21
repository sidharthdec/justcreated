package com.example.demo.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.model.FileDetails;

@Component
public class MessageRecieverImpl {
	
	 private static final Logger log = LoggerFactory.getLogger(MessageRecieverImpl.class);

	    @RabbitListener(queues = MessagingApplication.QUEUE_GENERIC_NAME)
	    public void receiveMessage(final Message message) {
	        log.info("Received message as generic: {}", message.toString());
	    }

	    @RabbitListener(queues = MessagingApplication.QUEUE_SPECIFIC_NAME)
	    public void receiveMessage(final FileDetails fd) {
	        log.info("Received message as specific class: {}", fd.toString());
	    }

	

}
