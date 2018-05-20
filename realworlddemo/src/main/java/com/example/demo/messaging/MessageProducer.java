package com.example.demo.messaging;

import com.example.demo.model.FileDetails;

public interface MessageProducer {

	public void sendMessage(FileDetails fd);
}
