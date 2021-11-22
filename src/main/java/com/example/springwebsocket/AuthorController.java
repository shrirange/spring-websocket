package com.example.springwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
	
	@Autowired
	private Websocketservice webservice;
	
	@GetMapping("/app/{message}")
	@MessageMapping("/hello")
	public String getMessage(@PathVariable("message") String message, 
			@Header("simpSessionId") String sessionId) {
		
		webservice.sendMessage(sessionId + "#" + message);
		return message;
		
	}

}
