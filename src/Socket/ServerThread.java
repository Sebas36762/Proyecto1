package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket sc;
    public static String username;

    public ServerThread(Socket sc){
        this.sc = sc;
    }

    public void run(){
        try{
            String msg = null;
            BufferedReader listener = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            while((msg = listener.readLine()) != null){
                username = msg;
                System.out.println("Client says: " + username);
            }
            sc.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
