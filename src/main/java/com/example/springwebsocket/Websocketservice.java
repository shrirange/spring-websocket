package com.example.springwebsocket;

public interface Websocketservice {
	
	void sendMessage(String message);
	
	void sendPrivateMessage(String message, String sessionId);

}
