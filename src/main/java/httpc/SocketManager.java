package httpc;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketManager {

    public Socket clientSocket = null;
    public PrintWriter pw = null;
    public InputStream inputStream = null;

    SocketManager(String url, int port) {
        createSocket(url, port);
    }

    public void closeSocket() {
        try {
            pw.close();
            inputStream.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Could not close socket or buffered reader...");
            System.exit(1);
        }
    }

    private void createSocket(String url, int port) {
        try {
            // create a client socket
            String domainName = url.replace("http://", "").split("/")[0];
            System.out.println("Domain name: " + domainName);

            clientSocket = new Socket(domainName, port); // default port number is 80
            pw = new PrintWriter(clientSocket.getOutputStream());
            inputStream = clientSocket.getInputStream();

            System.out.println("Socket connected: " + clientSocket.isConnected());
            System.out.println("Connected on port: " + clientSocket.getPort());
            System.out.println("Remote socket address: " + clientSocket.getRemoteSocketAddress());
        } catch (UnknownHostException e) {
            System.out.println("IP address of the host could not be found...");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Could not create socket...");
            System.exit(1);
        }
    }

}
