package Socket;

import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private ServerSocket socketServidor;
    private Socket socketCliente;

    /**
     * Crea la conexion del servidor
     * @throws IOException Excepcion en caso de que falle la conexion.
     */
    public void linkS () throws IOException {

        socketServidor = new ServerSocket(7777);
        socketCliente = socketServidor.accept();
    }
}
