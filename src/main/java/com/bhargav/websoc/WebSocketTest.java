package com.bhargav.websoc;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocketTest {

	@OnMessage
	public void onMessage(String message, Session session){
		
		try{
		System.out.println("User input: " + message);
		session.getBasicRemote().sendText("Hello world Mr678. " + message);
		
		System.out.println("notifying all");
		session.notifyAll();
		// Sending message to client each 1 second
		/*for (int i = 0; i <= 25; i++) {
			session.getBasicRemote().sendText(i + " Message from server");
			Thread.sleep(1000);

		}*/
		}catch(Exception e){
			System.out.println("Exception in WebSocketTest onMessage() : "+e.getMessage());
		}
	}

	@OnOpen
	public void onOpen() {
		System.out.println("Client connected");
	}

	@OnClose
	public void onClose() {
		System.out.println("Connection closed");
	}
}
