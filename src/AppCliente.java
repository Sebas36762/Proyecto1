import Socket.Cliente;
import java.io.*;

public class AppCliente {

    public static void main(String[] args) throws IOException {
        Cliente cli = new Cliente();
        cli.linkC();
    }
}
