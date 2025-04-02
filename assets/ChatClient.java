package assets;

import org.java-websocket.client.WebSocketClient;
import org.java-websocket.handshake.ServerHandshake;
import java.net.URI;

public class ChatClient extends WebSocketClient {

    public ChatClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("Connected to server");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("Received from server: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Closed connection: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }

    public static void main(String[] args) {
        URI uri = URI.create("ws://localhost:8080");
        ChatClient client = new ChatClient(uri);
        client.connect();
    }
}
