package com.example.demo.messaging;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.FileDetails;

public class MessageProducerImpl implements MessageProducer{
	
	
	private static final Logger log = LoggerFactory.getLogger(MessageProducerImpl.class);
	
	
	private final RabbitTemplate rabbit;
	
	@Autowired	
	public MessageProducerImpl(RabbitTemplate rabbit) {
		this.rabbit = rabbit;
	}
	
	@Override
	public void sendMessage(FileDetails fd) {
		// TODO Auto-generated method stub
		
		log.info("msg sent");
		rabbit.convertAndSend(MessagingApplication.EXCHANGE_NAME, 
				MessagingApplication.ROUTING_KEY,
				fd);
	}
	

}
