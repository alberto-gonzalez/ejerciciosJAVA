package edu.upc.eetac.dsa.ejerciciosJAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;



public class ClienteTCPnoconcurrente {
    public static void main(String[] args) throws IOException {
        
        String server = "localhost";
        int port = 12345;

        Socket socket = new Socket(server, port);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String time = reader.readLine();
        System.out.println(time);
    }
}





