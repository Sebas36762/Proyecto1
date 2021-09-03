package Socket;

import java.net.Socket;
import java.io.IOException;

public class Cliente {
    private Socket socketCliente;

    /**
     * Crea la conexion de cliente.
     * @throws IOException Excepcion en caso de que la conexion falle.
     */
    public void linkC() throws IOException{

        socketCliente = new Socket("LocalHost", 7777);
        System.out.println("Client connected");
    }
}
