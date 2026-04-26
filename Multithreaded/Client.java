package Multithreaded;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public Runnable getRunnable() {
        return () -> {
            try {
                int port = 8010;
                InetAddress address = InetAddress.getByName("localhost");

                Socket socket = new Socket(address, port);

                PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);

                BufferedReader fromSocket = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                toSocket.println("hello from client");

                String line = fromSocket.readLine();
                System.out.println("response from server: " + line);

                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        Client client = new Client();

       for (int i = 0; i < 100; i++) {
    Thread thread = new Thread(client.getRunnable());
    thread.start();

    try {
        Thread.sleep(10); // 🔥 IMPORTANT: prevents flood
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
    }
}