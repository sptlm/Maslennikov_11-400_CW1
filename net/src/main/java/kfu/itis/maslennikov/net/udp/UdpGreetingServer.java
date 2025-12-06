package kfu.itis.maslennikov.net.udp;

import java.io.Closeable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpGreetingServer extends Thread implements Closeable, Runnable {

    public static final int PORT = 5556;
    private DatagramSocket socket;
    private boolean alive = true;
    private byte[] buffer = new byte[4096];

    public UdpGreetingServer() {
        try {
            socket = new DatagramSocket(PORT);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {
        while (alive) {
            try{
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                InetAddress address = packet.getAddress();
                int port = packet.getPort();

                // logic

                String resp = "Hello " + address.getHostAddress() + ":" + port + "!\n" + "ur message: " + message;
                byte[] data = resp.getBytes();
                DatagramPacket response = new DatagramPacket(data, data.length, address, port);

                socket.send(response);

                if ("bye".equals(message.trim().toLowerCase())) {
                    alive = false;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        close();
    }

    @Override
    public void close(){
        socket.close();
    }
}
