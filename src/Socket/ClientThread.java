package Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket sc;
    public static String Name;

    public ClientThread(Socket sc){
        this.sc = sc;
    }

    public void run(){
        try{
            BufferedReader listener = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            boolean running = true;
            while(running){
                String serverMsg = listener.readLine();
                Name = serverMsg;
                System.out.println("Server says: " + Name);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}