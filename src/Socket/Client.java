package Socket;

import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;

public class Client {
    private Socket socketCliente;
    private PrintWriter sender;

    /**
     * Crea la conexion de cliente.
     * @throws IOException Excepcion en caso de que la conexion falle.
     */
    public void linkC() throws IOException{

        socketCliente = new Socket("LocalHost", 7777);
        System.out.println("Client connected");
        this.sender = new PrintWriter(socketCliente.getOutputStream(), true);
        this.sender.println("hello");

    }
}
