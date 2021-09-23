package Socket;

import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;

public class Client {
    private static Socket socketCliente;
    private static PrintWriter sender;

    /**
     *
     * @throws IOException Excepción en caso de que ocurra algún problema
     */
    public Client() throws IOException {
    }

    /**
     * Crea la conexion de cliente.
     * @throws IOException Excepcion en caso de que la conexion falle.
     */
    public void linkC() throws IOException{
        socketCliente = new Socket("LocalHost", 7777);
        System.out.println("Client connected");
        new ClientThread(socketCliente).start();
        sender = new PrintWriter(socketCliente.getOutputStream(), true);
    }

    /**
     * Método que: - Realiza el envió de una variable tipo String
     *
     * @param msg Parámetro que se le da al método para que capture el mensaje a enviar
     */
    public void sendMsg(String msg){
        sender.println(msg);
    }

}
