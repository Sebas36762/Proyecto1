package Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket sc;

    public ClientThread(Socket sc){
        this.sc = sc;
    }

    public void sendMsg(String msg) throws IOException{
        PrintWriter sender = new PrintWriter(sc.getOutputStream(), true);
        sender.println(msg);
    }

    public void run(){
        try{
            BufferedReader listener = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            while(true){
                String serverMsg = listener.readLine();
                System.out.println(serverMsg);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}