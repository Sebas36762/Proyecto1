package Socket;
import SwingInterfaces.BoardInterfaceClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket sc;
    public static String Name;
    private static int X;
    private static int Y;

    public ClientThread(Socket sc){
        this.sc = sc;
    }

    public void run(){
        try{
            BufferedReader listener = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            Name = listener.readLine();
            String list = listener.readLine();
            System.out.println(list);

            boolean running = true;
            while(running){
                String serverMsg = listener.readLine();

                System.out.println("Server says: " + serverMsg);

                String[] Name = serverMsg.split(",");
                X = Integer.parseInt(Name[0]);
                Y = Integer.parseInt(Name[1]);
                BoardInterfaceClient.updateMove(X, Y);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}