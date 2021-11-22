package com.example.springwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebsocketserviceImpl implements Websocketservice {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	public void sendMessage(String message) {
		
		template.convertAndSend("/topic/greetings", message);
		//template.convertAndSendToUser(message, message, message)
	}


}
