import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.nio.ByteBuffer;

@ServerEndpoint(value = "/websocket", configurator = WebSocketConfigurator.class, encoders = {
        CustomTextEncoder.class }, decoders = { CustomTextDecoder.class, CustomBinaryDecoder.class })
public class WebSocketServer {

    private String username;
    private Session session;

    @OnOpen
    public void onOpen(Session session, EndpointConfig endpointConfig) throws IOException {
        this.session = session;
        this.username = (String) endpointConfig.getUserProperties().get("username");

        session.getBasicRemote().sendText("Welcome " + username + "!");
    }

    @OnMessage
    public void onMessage(String message) throws IOException, EncodeException {
        session.getBasicRemote().sendText("You sent: " + message);
    }

    @OnMessage
    public void onMessage(ByteBuffer message) throws IOException {
        session.getBasicRemote().sendBinary(message);
    }

    @OnClose
    public void onClose() throws IOException {
        session.getBasicRemote().sendText("Goodbye " + username + "!");
    }

    @OnError
    public void onError(Throwable error) {
        System.out.println("Error: " + error.getMessage());
    }
}