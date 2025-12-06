package kfu.itis.maslennikov.udp;

import java.io.Closeable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GreetingClient implements Runnable, Closeable {
    private DatagramSocket socket;
    private byte[] buffer = new byte[1024];
    private InetAddress address;

    public GreetingClient() {
        try{
            this.socket = new DatagramSocket();
            this.address =InetAddress.getLocalHost();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void close() throws IOException {

    }

    @Override
    public void run() {

    }
}
