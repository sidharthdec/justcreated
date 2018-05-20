package com.example.demo.runner;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.messaging.MessageProducer;
import com.example.demo.messaging.MessageProducerImpl;
import com.example.demo.model.FileDetails;

@RestController
public class RestMessageInitator {
	
	//@Autowired
	//private MessageProducer sender;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
 
	private static final Logger log = LoggerFactory.getLogger(RestMessageInitator.class);
 

	@RequestMapping(value="/sendMessage", method= RequestMethod.GET )			
	//@RequestBody FileDetails fd
	public RequestEntity<?> send() throws SQLException{
		
		//sender.sendMessage(fd);
		log.debug(jdbcTemplate.getDataSource().getConnection().toString());
		
		return null;
		
	}
}
