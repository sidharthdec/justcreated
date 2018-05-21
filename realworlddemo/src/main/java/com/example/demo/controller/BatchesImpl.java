package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

@RestController
public class BatchesImpl implements Batches{

	@Autowired
	private JdbcOperations template;
	//run batch , the task of batch is to change an entry
	public void runbatch() {
		String insertQuery = "insert into requestlog (id, name) values(1,'sid')";
		template.execute(insertQuery);
		
	}
}
