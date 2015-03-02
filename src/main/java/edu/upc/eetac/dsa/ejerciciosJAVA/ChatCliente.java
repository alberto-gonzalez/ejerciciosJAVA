package edu.upc.eetac.dsa.ejerciciosJAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatCliente implements Runnable {
    private class ReaderThread implements Runnable {
        BufferedReader reader = null;

        public ReaderThread(BufferedReader reader) {
            this.reader = reader;
        }


        public void run() {
            String msg = null;
            try {
                while ((msg = reader.readLine()) != null)
                    System.out.println(msg);
            } catch (IOException e) {
                if (!socket.isClosed())
                    e.printStackTrace();
            }
        }
    }

    private String server;
    private int port;
    private Socket socket = null;
    private BufferedReader reader = null;
    private PrintWriter writer = null;

    public ChatCliente(String server) {
        this(server, ChatServer.DEFAULT_PORT);
    }

    public ChatCliente(String server, int port) {
        this.server = server;
        this.port = port;
    }


    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your username: ");
            String username = reader.readLine();
            join(username);

            System.out.println("start chat");
            String msg = null;
            while ((msg = reader.readLine()).length() != 0) {
                send(msg);
            }
            leave();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void join(String username) throws IOException {
        socket = new Socket(server, port);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        (new Thread((new ReaderThread(reader)))).start();
        writer = new PrintWriter(socket.getOutputStream());

        writer.println("JOIN " + username);
        writer.flush();
    }

    private void leave() throws IOException {
        writer.println("LEAVE");
        writer.flush();

        socket.close();
    }

    private void send(String msg) {
        writer.println("MESSAGE " + msg);
        writer.flush();
    }

    public static void main(String[] args) {
       
        String server = "localhost";
        int port = 3333;
        ChatCliente client = new ChatCliente(server, port);
        (new Thread(client)).start();
    }
}