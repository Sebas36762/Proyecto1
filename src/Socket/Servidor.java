package Socket;

import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private ServerSocket socketServidor;
    private Socket socketCliente;

    public void linkS () throws IOException {
        socketServidor = new ServerSocket(7777);
        socketCliente = socketServidor.accept();
    }

    public static void main(String[] args) throws IOException{
        Servidor serverRunnable = new Servidor();
        serverRunnable.linkS();
    }
}
