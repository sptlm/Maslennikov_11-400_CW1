package kfu.itis.maslennikov.net;

import kfu.itis.maslennikov.net.tcp.GreetingClient;
import kfu.itis.maslennikov.net.udp.UdpGreetingClient;
import kfu.itis.maslennikov.net.udp.UdpGreetingServer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //tcpClientTest();
        udpClientTest();

    }

    public static void tcpClientTest(){
        GreetingClient client = new GreetingClient();

        client.start("127.0.0.1", 5555);
        System.out.println(client.send(" Hello "));
        System.out.println(client.send(" World "));
        System.out.println(client.send(" Bye "));
        System.out.println(client.send(" hola? "));

    }
    public static void udpClientTest(){
        try(
                UdpGreetingServer server = new UdpGreetingServer();
                UdpGreetingClient client = new UdpGreetingClient();
        ){
            server.start();
            System.out.println(client.send(" Hi "));
            System.out.println(client.send(" Hello "));
            System.out.println(client.send(" World "));
            System.out.println(client.send(" Bye "));
            System.out.println(client.send(" hola? "));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

}
