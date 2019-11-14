package com.ppchat.ppchat.web;

//import org.springframework.boot.web.servlet.server.Session;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/websocket/{sid}")
@Component
public class WebSocketServer {
    private static Map<String, Session> online = new ConcurrentHashMap<String, Session>();
    private Session session;
    private String sid = "";

    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        this.sid = sid;
        online.put(sid, session);
    }

    @OnClose
    public void onClose() {
        online.remove(sid);
    }

    /***
     *
     * @param message 用户发送的信息
     */
    @OnMessage
    public void onMessage(Session session, String message) {

    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

}
