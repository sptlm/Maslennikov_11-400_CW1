package kfu.itis.maslennikov.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

import static kfu.itis.maslennikov.net.udp.UdpGreetingServer.PORT;

public class UdpGreetingClient implements AutoCloseable {
    private DatagramSocket socket;
    private byte[] sendBuffer = new byte[4096];
    private byte[] receiveBuffer = new byte[4096];
    private InetAddress address;

    public UdpGreetingClient() {
        try {
            this.socket = new DatagramSocket();
            this.address = InetAddress.getLocalHost();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }

    public String send(String message) {
        try{
            sendBuffer = message.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet = new DatagramPacket(sendBuffer, sendBuffer.length, address, PORT);
            socket.send(packet);

            packet = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(packet);

            return new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void close() throws IOException {
        socket.close();
    }
}
