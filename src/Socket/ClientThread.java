package Socket;
import BoardElements.Labels;
import SwingInterfaces.BoardInterfaceClient;
import SwingInterfaces.ChallengeInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *Instituo Tecnologico de Costa Rica
 * Area de Ingenierias en Computadores
 *
 * Lenguaje: Java
 * Clase: ClientThread
 * @version 1.2
 * @author Byron Mata, Gustavo Alvarado y Sebastián Chaves
 *
 * Descripcion:Esta Clase contiene el constructor para guardar el socket y el movimiento del juegador
 */
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

    /**
     * Método que mantiene el thread abierto, y que a la vez le permite recibir y envía datos ya sea tipo String o una lista,
     * también permite que se de el movimiento de los jugadores en los ejes X y Y y que se actualice el movimento en las ventanas
     */
    public void run(){
        try{
            BufferedReader listener = new BufferedReader(new InputStreamReader(sc.getInputStream())); //Puente que recibe datos
            Name = listener.readLine(); //Guarda el nombre del Servidor

            String list = listener.readLine();
            List = list.split(","); //Guarda la lista de casillas y crea los Labels
            Labels.LabelsClient(List);

            boolean running = true;
            while(running){
                String msg = listener.readLine(); //Mensaje recibido del Servidor
                if(msg.equals("Ready")){ //Dato recibido para ejecutar el movimiento al salir un reto
                    String Challenge = listener.readLine();
                    if(Challenge.equals("Chg")){
                        BoardInterfaceClient.move(1);
                    }

                }else if (msg.equals("Move")){ //Actualizacion del movimiento del jugador
                    String serverMsg = listener.readLine();
                    String[] Name = serverMsg.split(",");
                    X = Integer.parseInt(Name[0]);
                    Y = Integer.parseInt(Name[1]);
                    BoardInterfaceClient.updateMove(X, Y);

                }else if (msg.equals("Turn")){ //Cambio de turno
                    String Turn = listener.readLine();
                    BoardInterfaceClient.clientTurn(Turn);

                }else if (msg.equals("Verify")){ //Lanza la ventana con la verificación del reto
                    String verify = listener.readLine();
                    String[] params = verify.split(",");
                    ChallengeInterface Chg = new ChallengeInterface(params[0], params[1]);

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