package assets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
    // Initialize socket and input/output streams
    private Socket s = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    private static String socketIp = "127.0.0.1";
    private static int socketPort = 5425;

    // Constructor to put IP address and port
    public client(String addr, int port) {
        Scanner input = new Scanner(System.in);

        // Establish a connection
        try {
            s = new Socket(addr, port);
            System.out.println("Connected");

            // Sends output to the socket
            out = new DataOutputStream(s.getOutputStream());
        }
        catch (UnknownHostException u) {
            System.out.println(u);
            return;
        }
        catch (IOException i) {
            System.out.println(i);
            return;
        }

        // String to read message from input
        String m = "";

        // Keep reading until "Over" is input
        while (!m.equals("Over")) {
            try {
                m = input.nextLine();
                out.writeUTF(m);
            }
            catch (IOException i) {
                System.out.println(i);
            }
        }

        // Close the connection
        try {
            in.close();
            out.close();
            s.close();
        }
        catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        client client = new client(socketIp, socketPort);
    }
}
