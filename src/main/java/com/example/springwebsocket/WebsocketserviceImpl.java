package com.example.springwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebsocketserviceImpl implements Websocketservice {

	@Autowired
	private SimpMessagingTemplate template;

	public void sendMessage(String message) {
		template.convertAndSend("/topic/greetings", message);
	}

	@Override
	public void sendPrivateMessage(String message, String sessionId) {
		template.convertAndSendToUser(sessionId, "/queue/notify", message, createHeaders(sessionId));
	}

	private MessageHeaders createHeaders(String sessionId) {
		SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
		headerAccessor.setSessionId(sessionId);
		headerAccessor.setLeaveMutable(true);
		return headerAccessor.getMessageHeaders();
	}

}
