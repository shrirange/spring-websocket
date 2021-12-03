package com.example.springwebsocket;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

@Component
public class SessionConnectedEventListener implements ApplicationListener<SessionConnectedEvent> {

	private Websocketservice webSocketSessionService;

	public SessionConnectedEventListener(Websocketservice webSocketSessionService) {
		this.webSocketSessionService = webSocketSessionService;
	}

	@Override
	public void onApplicationEvent(SessionConnectedEvent event) {
		System.out.println("Connected " + event.getMessage().getHeaders().get("simpSessionId") + " " + event.getUser().getName());
		webSocketSessionService
				.sendMessage("connected " + event.getMessage().getHeaders().get("simpSessionId").toString());
	}
}