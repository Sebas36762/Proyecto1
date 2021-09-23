package Socket;

import SwingInterfaces.BoardInterfaceServer;
import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket sc;
    public static String username;
    public static int X;
    public static int Y;

    public ServerThread(Socket sc){
        this.sc = sc;
    }

    public void run(){
        try{
            String msg = null;
            BufferedReader listener = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            username = listener.readLine();

            while((msg = listener.readLine()) != null){
                username = msg;
                System.out.println("Client says: " + msg);

                String[] Name = msg.split(",");
                X = Integer.parseInt(Name[0]);
                Y = Integer.parseInt(Name[1]);
                BoardInterfaceServer.updateMove(X, Y);
            }
            sc.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
