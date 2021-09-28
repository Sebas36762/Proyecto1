package Socket;

import SwingInterfaces.BoardInterfaceServer;
import SwingInterfaces.ChallengeInterface;

import java.io.*;
import java.net.Socket;

/**
 * Instituto Tecnologico de Costa Rica
 * Area Ingenierpia en Computadores
 *
 * Lenguaje: Java
 * Clase: ServerThread
 * @version 1.2
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 *
 * Descripcion: Esta clase contiene el constructor para guardar el socket y el movimiento del jugador
 */
public class ServerThread extends Thread{
    private Socket sc;
    public static String username;
    public static int X;
    public static int Y;

    /**
     * Contructor que guarda el socket en la clase
     *
     * @param sc Párametro que contiene el socket
     */
    public ServerThread(Socket sc){
        this.sc = sc;
    }

    /**
     * Método que mantiene el thread abierto, y que a la vez le permite recibir y envía datos ya sea tipo String o una lista,
     *  también permite que se de el movimiento de los jugadores en los ejes X y Y y que se actualice el movimento en las ventanas
     */
    public void run(){
        try{
            BufferedReader listener = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            username = listener.readLine();
            boolean running = true;
            while(running){
                String msg = listener.readLine();

                if(msg.equals("Ready")){
                    String Chg = listener.readLine();
                    if (Chg.equals("Chg")){
                        BoardInterfaceServer.move(1);
                    }
                }else if (msg.equals("Move")){
                    String Clientmsg = listener.readLine();
                    String[] Name = Clientmsg.split(",");
                    X = Integer.parseInt(Name[0]);
                    Y = Integer.parseInt(Name[1]);
                    BoardInterfaceServer.updateMove(X, Y);

                }else if (msg.equals("Turn")){
                    String Turn = listener.readLine();
                    BoardInterfaceServer.serverTurn(Turn);

                }else if (msg.equals("Verify")){
                    String verify = listener.readLine();
                    String[] params = verify.split(",");
                    ChallengeInterface chg = new ChallengeInterface(params[0], params[1]);
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
