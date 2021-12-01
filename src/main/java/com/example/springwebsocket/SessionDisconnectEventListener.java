package com.example.springwebsocket;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class SessionDisconnectEventListener implements ApplicationListener<SessionDisconnectEvent> {

	private Websocketservice webSocketSessionService;

	public SessionDisconnectEventListener(Websocketservice webSocketSessionService) {
		this.webSocketSessionService = webSocketSessionService;
	}

	@Override
	public void onApplicationEvent(SessionDisconnectEvent event) {
		System.out.println("***** Disconnected " + event.getMessage().getHeaders().get("simpSessionId"));
		webSocketSessionService
				.sendMessage("disconnected " + event.getMessage().getHeaders().get("simpSessionId").toString());
	}
}