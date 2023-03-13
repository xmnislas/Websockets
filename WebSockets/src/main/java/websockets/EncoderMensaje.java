/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package websockets;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author xmnislas
 */
public class EncoderMensaje implements Encoder.TextStream<Mensaje>{

    @Override
    public void encode(Mensaje object, Writer writer) throws EncodeException, IOException {
        JsonObject json = Json.createObjectBuilder().
                add("usuario", object.getUsuario())
               .add("entidad", object.getEntidad().toString())
               .build();
        
        try(JsonWriter jsonWriter = Json.createWriter(writer)){
            jsonWriter.writeObject(json);
        }
    }

    @Override
    public void init(EndpointConfig config) { 
    }

    @Override
    public void destroy() {
    }
    
}
