package edu.upc.eetac.dsa.ejerciciosJAVA;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;

public class ServidorUDPnoconcurrente {
    private final static int DEFAULT_PORT = 12345;

    public static void main(String[] args) throws IOException {
        int port = DEFAULT_PORT;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        DatagramSocket datagramSocket = new DatagramSocket(port);
        while (true) {
            byte[] buffer = new byte[0];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(datagramPacket);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeUTF(sdf.format(System.currentTimeMillis()));
            byte[] data = baos.toByteArray();

            datagramPacket = new DatagramPacket(data, data.length, datagramPacket.getAddress(), datagramPacket.getPort());
            datagramSocket.send(datagramPacket);
        }
    }
}