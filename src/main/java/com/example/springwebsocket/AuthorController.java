package com.example.springwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
	
	@Autowired
	private Websocketservice webservice;
	
	@GetMapping("/app/global/{message}")
	@MessageMapping("/hello")
	public String getMessage(@Payload @PathVariable("message") String message, 
			@Header("simpSessionId") String sessionId) {
		webservice.sendMessage(sessionId + "#" + message);
		return message;
	}
	
	@GetMapping("/app/private/{sessionId}/{message}")
	@MessageMapping("/privatehello")
	public String getPrivateMessage(@Payload @PathVariable("message") String message, 
			@PathVariable("sessionId") @Header("simpSessionId") String sessionId) {
		System.out.println("Sending private message" + sessionId);
		webservice.sendPrivateMessage(sessionId + "#" + message, sessionId);
		return message;
	}
	
	@GetMapping("/app/user/{userid}/{message}")
	@MessageMapping("/userhello")
	public String getUserMessage(@Payload @PathVariable("message") String message, 
			 @Header("simpSessionId") String sessionId) {
		System.out.println("Sending user message" + sessionId);
		webservice.sendUserMessage(sessionId + "#" + message);
		return message;
	}

}
