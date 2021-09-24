package Socket;

import DoubleLinkedList.DoubleLinkedList;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
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
public class Server {
    private static ServerSocket socketServidor;
    private static Socket socketCliente;
    private static PrintWriter sender;

    /**
     * Crea la conexión del servidor
     * @throws IOException Excepcion en caso de que falle la conexión.
     */
    public void linkS () throws IOException {
        socketServidor = new ServerSocket(7777);
        socketCliente = socketServidor.accept();
        sender = new PrintWriter(socketCliente.getOutputStream(), true);
        new ServerThread(socketCliente).start();
    }

    /**
     *
     * @param msg
     */
    public static void sendMsg(String msg){
        sender.println(msg);
    }

    /**
     * Método que envía las coordenadas del jugador al cliente cuando se realiza un movimiento
     *
     * @param X Coordenada en X del jugador.
     * @param Y Coordenada en Y del jugador.
     */
    public static void updateMove(int X, int Y){
        sender.println(String.valueOf(X) + "," + String.valueOf(Y));
    }

    /**
     *  Método para el envío de la lista creada
     *
     * @param list Parámetro que contiene la lista
     * @throws IOException Excepción en caso de que ocurra algún problema
     */
    public static void sendList(String list) throws IOException{
        sender.println(list);
    }



}
