package assets;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  
    // Initialize socket and input stream
    private static String socketIp = "127.0.0.1";
    private static int socketPort = 5425;
    private static Socket s = null;
    private static DataInputStream in = null;

    // Constructor with port
    public Server (int port) {
      
        // Starts server and waits for a connection
        
    }

    public static void main (String args[]) {
        try
        {
            ServerSocket ss = new ServerSocket(socketPort);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            s = ss.accept();
            System.out.println("Client accepted");

            // Takes input from the client socket
            in = new DataInputStream(new BufferedInputStream(s.getInputStream()));

            String m = "";

            // Reads message from client until "Over" is sent
            while (!m.equals("Over"))
            {
                try
                {
                    m = in.readUTF();
                    System.out.println(m);

                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            // Close connection
            s.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
}