package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket sc;
    private PrintWriter sender;

    public ServerThread(Socket sc){
        this.sc = sc;
    }

    public void run(){
        try{
            String msg = null;
            BufferedReader listener = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            sender = new PrintWriter(sc.getOutputStream(), true);
            while((msg = listener.readLine()) != null){
                System.out.println("Message recived: " + msg);
                sender.println("Reply");
            }
            sc.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
