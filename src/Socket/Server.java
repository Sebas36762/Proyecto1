package Socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Instituto Tecnológico de Costa Rica
 * Área de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: Servidor
 * @version 1.0
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 * Descripción:
 */
public class Server {
    private ServerSocket socketServidor;
    private Socket socketCliente;
    private PrintWriter sender;

    /**
     * Crea la conexión del servidor
     * @throws IOException Excepcion en caso de que falle la conexión.
     */
    public void linkS () throws IOException {
        socketServidor = new ServerSocket(7777);
        socketCliente = socketServidor.accept();
        sender = new PrintWriter(socketCliente.getOutputStream(), true);
        new ServerThread(socketCliente).start();
    }

    /**
     *
     * @param msg
     */
    public static void sendMsg(String msg){
        sender.println(msg);
    }

}
