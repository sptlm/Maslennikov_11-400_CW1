package kfu.itis.maslennikov.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetingServer {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;


    public void start(int port){
        try{
            serverSocket = new ServerSocket(port);

            clientSocket = serverSocket.accept();

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;

            while ((message = in.readLine()) != null) {
                if("hello".equals(message.trim().toLowerCase())){
                    out.println("Yo!");
                }else if("bye".equals(message.trim().toLowerCase())){
                    out.println("Bye!");
                    stop();
                }
                else {
                    out.println("?");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop(){
        try{
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        GreetingServer server = new GreetingServer();

        server.start(5555);
    }

}
