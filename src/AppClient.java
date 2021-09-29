import Socket.Client;
import SwingInterfaces.BoardInterfaceServer;
import SwingInterfaces.LoginCInterface;
import java.io.*;

/**
 * Instituto Tecnológico de Costa Rica
 * Área de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: AppCliente
 * @version 1.0
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 *
 * Descripción: Clase que contiene el método principal para la ejecución de la aplicación del cliente
 */
public class AppClient {

    /**
     * Método para la ejecución del código fuente
     *
     * @param args Argumentos que se dan a un programa en tiempo de ejecución para modificar su funcionamiento
     * @throws IOException Excepción en caso de que ocurra algún problema
     */
    public static void main(String[] args) throws IOException {
        Client Client = new Client();
        LoginCInterface LgnCW = new LoginCInterface(Client); //Lanza la ventana de inicio
        Client.linkC(); //Inicia la conexión del cliente
    }

}
