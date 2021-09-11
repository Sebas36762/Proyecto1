package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class Server extends Thread {
    private ServerSocket socketServidor;
    private Socket socketCliente;
    private BufferedReader listener;


    /**
     * Crea la conexión del servidor
     * @throws IOException Excepcion en caso de que falle la conexión.
     */
    public void linkS () throws IOException {
        socketServidor = new ServerSocket(7777);
        socketCliente = socketServidor.accept();
        this.listener = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
    }

    public void run(){
        while(true){
            try{
                System.out.println(this.listener.readLine());
            }catch(IOException e){
                e.printStackTrace();
                break;
            }
        }
    }
}
