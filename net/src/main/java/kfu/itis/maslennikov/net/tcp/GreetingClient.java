package kfu.itis.maslennikov.net.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GreetingClient {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public void start(String ip, int port){
        try{
            socket = new Socket(ip, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String send(String message){
        try{
            out.println(message);
            return in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop(){
        try{
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
