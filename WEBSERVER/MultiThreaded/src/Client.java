import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class Client {

    public Runnable getRunnable() throws UnknownHostException,IOException {
        return new Runnable() {
            @Override
            public void run() {
                int port =8010;
                try{
                    InetAddress address=InetAddress.getByName("Localhost");
                    Socket socket = new Socket(address,port);
                    try( PrintWriter toSocket=new PrintWriter(socket.getOutputStream());
                         BufferedReader fromSocket=new BufferedReader(new InputStreamReader(socket.getInputStream()))
                    ) {
                        toSocket.println("Hello from Client "+socket.getLocalSocketAddress());
                        String line=fromSocket.readLine();
                        System.out.println("Response from server "+line);
                    }catch (IOException ex){
                        ex.printStackTrace();
                    }
                    // The socket will be closed automatically when leaving the try-with-resouces block
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        };
    }

    public static void main(String[] args) {
        Client client=new Client();
        for(int i=0;i<100;i++){
            try{
                Thread thread=new Thread(client.getRunnable());
                thread.start();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return;
    }
}


