import Socket.Client;
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
 * Descripción:
 */
public class AppClient {

    /**
     * Método main para la ejecución del código fuente
     * @param args argumentos que se le pasan a un programa en tiempo de ejecución para modificar su funcionamiento
     * @throws IOException Excepción en caso de que ocurra algún problema
     */
    public static void main(String[] args) throws IOException {
        Client Client = new Client();
        LoginCInterface LgnCW = new LoginCInterface();
        Client.linkC();
    }
}
