import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client{
     public void run(){
       try{ int port =8010;
        InetAddress address = InetAddress.getByName("localhost");
         Socket socket = new Socket(address,port);
         PrintWriter toSocket = new PrintWriter(socket.getOutputStream(),true);// Sends text data as bytes over the network via socket output stream (autoFlush enabled)
         BufferedReader fromSocket = new BufferedReader(
             new InputStreamReader(socket.getInputStream())
         );
         toSocket.println("hello from client");
         String line= fromSocket.readLine();
         System.out.println("response from socket is: "+line);
         socket.close();
      }
      catch(Exception e){
             e.printStackTrace();
         }

}
public static void main(String [] args){
  
        Client client =new Client();
        client.run();

}
}


