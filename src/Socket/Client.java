package Socket;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;

/**
 * Instituto Tecnológico de Costa Rica
 * Área de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: Client
 * @version 1.2
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 *
 * Descripción: Esta clase contiene el constructor del socket de cliente y establece sus valores para realizar la conexión,
 * además contiene el hilo que mantiene a en escucha a estos a traves de la conexión que se estableció
 */
public class Client {
    private static Socket socketCliente;
    private static PrintWriter sender;

    /**
     * Constructor vacío
     *
     * @throws IOException Excepción en caso de que ocurra algún problema
     */
    public Client() throws IOException {
    }

    /**
     * Constructor que establece la conexión entre los sockets de cliente y servidor y permite que se mantenga a la escucha de
     * lo que se le envíe por medio de un hilo
     *
     * @throws IOException Excepción en caso de que ocurra algún problema
     */
    public void linkC() throws IOException {
        socketCliente = new Socket("LocalHost", 7777);
        System.out.println("Client connected");
        new ClientThread(socketCliente).start(); //Inicia el hilo del cliente
        sender = new PrintWriter(socketCliente.getOutputStream(), true); //Crea el puente para envio de datos al servidor
    }

    /**
     * Método que realiza el envió de una variable tipo String
     *
     * @param msg Parámetro que se le da al método para que capture el mensaje a enviar
     */
    public static void sendMsg(String msg){
        sender.println(msg);
    }

    /**
     * Método que envía las coordenadas del jugador al servidor después de realizar un movimiento
     *
     * @param X Coordenada en X del jugador
     * @param Y Coordenada en Y del jugador
     */
    public static void updateMove(int X, int Y){
            sender.println(String.valueOf(X) + "," + String.valueOf(Y));

    }
}





