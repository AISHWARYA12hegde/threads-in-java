import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;




public class Server{
    public void run(){
        int port=8010; //defining the port the server listen
        // Create a ServerSocket that listens for incoming client connections on the given port
       // OS allocates a socket, binds it to the port, and starts listening
      // This socket is used only to accept connections (not for data communication)
      try(ServerSocket socket =new ServerSocket(port)){
       
        socket.setSoTimeout(10000);
        while(true){
            try{
                System.out.println("SERVER IS LISTENING ON PORT "+port);
                Socket acceptedConnection = socket.accept();
                System.out.println("Connection accepted from client "+acceptedConnection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(),true);// Sends text data as bytes over the network via socket output stream (autoFlush enabled)

                BufferedReader fromClient = new BufferedReader(
             new InputStreamReader(acceptedConnection.getInputStream())
             );
                toClient.println("heloo from server");
                String msg = fromClient.readLine();
                System.out.println("Client says: " + msg); 
            }
        
            catch(IOException ex){
                ex.printStackTrace();
            }
        
        }
        
    }catch(IOException ex){
                ex.printStackTrace();
            }
}

    public static void main(String[] args){
        Server server = new Server();
       
            server.run();
        
        
    }
}