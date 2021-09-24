package Socket;
import BoardElements.Labels;
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
    public static String[] List;

    /**
     * Contructor que guarda el socket en la clase
     *
     * @param sc Parámetro que contiene el socket
     */
    public ClientThread(Socket sc){
        this.sc = sc;
    }

    public void run(){
        try{
            BufferedReader listener = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            Name = listener.readLine();

            String list = listener.readLine();
            List = list.split(",");
            Labels.LabelsClient(List);

            boolean running = true;
            while(running){
                if(listener.readLine().equals("Ready")){
                    String Challenge = listener.readLine();
                    if(Challenge.equals("Chg")){
                        BoardInterfaceClient.move(1);
                    }

                }else{
                    String serverMsg = listener.readLine();
                    String[] Name = serverMsg.split(",");
                    X = Integer.parseInt(Name[0]);
                    Y = Integer.parseInt(Name[1]);
                    BoardInterfaceClient.updateMove(X, Y);

                    String Turn = listener.readLine();
                    BoardInterfaceClient.clientTurn(Turn);

                }


            }

        }catch (IOException e){
            try {
                sc.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}