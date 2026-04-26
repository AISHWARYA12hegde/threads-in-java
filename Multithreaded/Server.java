package Multithreaded;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;
import java.io.IOException;

public class Server {
    public Consumer<Socket> getConsumer() {
        return (clientSocket) -> {
            try (PrintWriter toSocket = new PrintWriter(clientSocket.getOutputStream(), true)) {
                toSocket.println("Hello from server " + clientSocket.getInetAddress());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        };
    }
    

    public static void main(String[] args) {
        int port =8010;
        Server server = new Server();
        try ( ServerSocket serverSocket = new ServerSocket(port)){

        serverSocket.setSoTimeout(100000);
        System.out.println("server is listening on" +port);
        while(true){
            Socket clientSocket = serverSocket.accept();
            Thread thread =new Thread(()-> server.getConsumer().accept(clientSocket));
               thread.start();
        }
    
    
    
    }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
