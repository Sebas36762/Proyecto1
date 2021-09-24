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
            BufferedReader listener = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            username = listener.readLine();
            boolean running = true;
            while(running){
                if(listener.readLine().equals("Ready")){
                    String Chg = listener.readLine();
                    if (Chg.equals("Chg")){
                        BoardInterfaceServer.move(1);
                    }
                }else{
                    String msg = listener.readLine();
                    String[] Name = msg.split(",");
                    X = Integer.parseInt(Name[0]);
                    Y = Integer.parseInt(Name[1]);
                    BoardInterfaceServer.updateMove(X, Y);

                    String Turn = listener.readLine();
                    BoardInterfaceServer.serverTurn(Turn);

                }

            }
            sc.close();
        }catch (IOException e){
            try {
                sc.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
