package Socket;

import java.net.Socket;
import java.io.IOException;

public class Cliente {
    private Socket socketCliente;

    public void linkC() throws IOException{

        socketCliente = new Socket("LocalHost", 7777);
        System.out.println("Client connected");
    }

    public static void main(String[] args) throws IOException {
        Cliente cli = new Cliente();
        cli.linkC();
    }
}
