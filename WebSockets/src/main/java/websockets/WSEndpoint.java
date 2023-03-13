/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package websockets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author xmnislas
 */
@ServerEndpoint(value = "/endpoint", encoders = {EncoderMensaje.class}, decoders = {DecoderMensaje.class})
public class WSEndpoint {
    private static final List<Session> conectados = new ArrayList<>();
    
    @OnOpen
    public void open(Session session) {
        conectados.add(session);
    }
    
    @OnClose
    public void close(Session session){
        conectados.remove(session);
    }
    
    @OnError
    public void error(Throwable error) {
        error.printStackTrace();
    }

    @OnMessage
    public void onMessage(Mensaje message) throws IOException, EncodeException {
        for(Session sesion: conectados){
            sesion.getBasicRemote().sendObject(message);
        }
    } 
}
