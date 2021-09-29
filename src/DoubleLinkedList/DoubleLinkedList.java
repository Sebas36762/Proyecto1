package DoubleLinkedList;
import Socket.Client;
import Socket.Server;
import SwingInterfaces.BoardInterfaceClient;
import SwingInterfaces.BoardInterfaceServer;
import javax.swing.*;
import java.io.Serializable;
import java.util.*;

/**
 * Instituto Tecnológico de Costa Rica
 * Área de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: DoubleLinkedList
 * @version 3.0
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 *
 * Descripción: Esta clase contiene algunos de los métodos que se utilizan en la lista doblemente enlazada, principalmente
 * en los movimientos y los casos de las casillas
 */
public class DoubleLinkedList implements Serializable {

    public static String values;
    private static DoubleNode head;
    private DoubleNode tail;
    private int trampa = 0, tunel = 0, reto = 0;

    /**
     * Constructor de un nuevo objeto "Double Linked List" con head y tail como nulos
     */
    public DoubleLinkedList() {
        head = null;
        tail = null;
        Casillas();
    }

    /**
     * Método que retorna verdadero si la lista esta vacía y falso de ser caso contrario
     *
     * @return Retorno de true si la lista es vacía o flase de ser caso contario
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * Método que crea las casillas de manera aleatoria
     */
    public void Casillas(){
        int i = 1;
        while(i <=14){
            int probability = (int)(Math.random()*3)+1; //Probabilidad random de crear las casillas
            if(probability == 1 && this.trampa <4){ //Casilla de trampa
                addCasilla('A', String.valueOf(i));
                this.trampa++;
                i++;

            }else if(probability == 2 && this.reto <7){ //Casilla de reto
                addCasilla('R', String.valueOf(i));
                this.reto++;
                i++;

            }else if (probability == 3 && this.tunel <3){ //Casilla de tunel
                addCasilla('T', String.valueOf(i));
                this.tunel++;
                i++;
            }
        }
    }

    /**
     * Método que crea las casillas de la lista y las va añadiendo
     *
     * @param Id Parámetro que permite reconocer el tipo de casilla
     * @param ID Parámetro para reconcer el número de la casilla
     */
    public void addCasilla(char Id, String ID){
        DoubleNode casilla = new DoubleNode(null, Id, ID, head);
        if(isEmpty()){
            head = tail = casilla;
        }else{
            head.setPrev(casilla);
            head = casilla;
        }
    }

    /**
     * Método que permite realizar un print de la lista creada
     *
     * @return Retorno de la lista creada
     */
    public String showList(){
        DoubleNode cn = head;
        String str = "";
        while(cn != null){
            str += cn.getC() + ",";
            cn = cn.getNext();
        }
        String list = str;
        return list;
    }

    /**
     * Método que busca un nodo dado por medio del parámetro
     *
     * @param Id Parámetro para permite acceder a un determinado nodo
     * @return Retorno null
     */
    public static String findNode(String Id) {
        DoubleNode objective = head;
        while (objective != null){
            if (objective.getID().equals(Id)) { //Se cumple si se encuentra el nodo en la lista
                return objective.getC();
            }else{
                objective = objective.getNext();
            }
        }
        return null; //No se encontró el nodo en la lista
    }

    /**
     * Método que realiza la creación de una operación matemática aleatorea
     *
     * @return Retorno de la variable "format" que contiene el formato de la operación aleatorea
     */
    public static String Mathchallenge() {
        Random r = new Random();
        int A = (int) (Math.random()*50+1); //Primer operando para el reto
        int B = (int) (Math.random()*50+1); //Segundo operando del reto
        char operator = 'a';
        int value = 0;

        switch (r.nextInt(3)){
            case 0: operator = '+';
                value = A+B;
                break;
            case 1: operator = '-';
                value = A-B;
                break;
            case 2: operator = '*';
                value = A*B;
                break;
            case 3: operator = '/';
                value = A/B;
                break;
        }
        values = (String.valueOf(value));
        String format = (String.valueOf(A)+" "+String.valueOf(operator)+" "+String.valueOf(B)); //Expresión total del reto con valores random
        return format;
    }

    /**
     * Método que contiene la funcionalidad de la casilla de tunel, asignado su movimiento de manera aleatoria
     *
     * @param Player Parámetro que pasa el Label del jugador para su actualización
     * @param player Parámetro que define que jugador llamó al método
     */
    public static void Tunel(JLabel Player, String player){

        int move = (int)(Math.random()*3)+1; //Cantidad de casillas a moverse, de 1 a 3
        System.out.println("Tunel move: " + move);

        //Aumento en el contador de casillas de Clinte o Servidor
        if(player.equals("Server")){
            BoardInterfaceServer.casillas += move;
        }else{
            BoardInterfaceClient.casillas +=move;
        }

        if (Player.getY() == 107) { //Primera fila del tablero
            int pos = 0;
            while(pos < move){
                if(Player.getX() == 516 && pos != move){
                    if(player.equals("Server")){
                        Player.setLocation(Player.getX(), Player.getY()+150); //Movimiento hacia la segunda fila del tablero
                        pos++;
                        for(int i = pos; i < move; i++) { //Movimiento hacia la izquierda en segunda fila
                            Player.setLocation(Player.getX()-150, Player.getY());
                            pos++;
                        }
                        pos++;
                        break;

                    }else{
                        Player.setLocation(Player.getX()+50, Player.getY()+150); //Movimiento hacia la segunda fila del tablero
                        pos++;
                        for(int i = pos; i < move; i++) { //Movimiento hacia la izquierda en segunda fila
                            Player.setLocation(Player.getX()-150, Player.getY());
                            pos++;
                        }
                        pos++;
                        break;
                    }
                }
                Player.setLocation(Player.getX()+150, Player.getY());
                pos++;
            }

        } else if(Player.getY() == 257) { //Segunda fila del tablero
            int pos = 0;
            while(pos < move){
                if((Player.getX() == 66 && pos != move)||(Player.getX() == 116 && pos != move)){
                    Player.setLocation(Player.getX(), Player.getY()+150); //Movimiento a la tercera fila
                    pos++;
                    for(int i = pos; i < move; i++) {
                        Player.setLocation(Player.getX()+150, Player.getY()); //Movimiento a la derecha en la tercera fila del tablero
                        pos++;
                    }
                    pos++;
                    break;
                }
                Player.setLocation(Player.getX()-150, Player.getY()); //Movimiento a la izquierda en la segunda fila del tablero
                pos++;
            }

        } else if (Player.getY() == 407){ //Tercera fila del tablero
            int pos = 0;
            while(pos < move){
                if((Player.getX() == 516 && pos != move)||(Player.getX() == 566 && pos != move)){
                    Player.setLocation(Player.getX(), Player.getY()+150); //Movimiento a la cuarta fila del tablero
                    pos++;
                    for(int i = pos; i < move; i++) {
                        Player.setLocation(Player.getX()-150, Player.getY()); //Movimiento a la izquierda en la cuarta fila del tablero
                        pos++;
                    }
                    pos++;
                    break;
                }
                Player.setLocation(Player.getX()+150, Player.getY()); //Movimiento a la derecha en la tercera fila del tablero
                pos++;
            }

        } else if (Player.getY() == 557) { //Cuarta fila del tablero
            int pos = 0;
            while(pos < move){
                if((Player.getX() == 66 && Player.getY() == 557)||(Player.getX() == 116 && Player.getY() == 557)){ //Jugador llegó a la última casilla del tablero
                    BoardInterfaceServer.gameOver();
                    break;
                }
                Player.setLocation(Player.getX()-150, Player.getY()); //Movimeinto a la izquierda en la cuarta fila del tablero
                pos++;
            }

        }if((Player.getX() == 66 && Player.getY() == 557)||(Player.getX() == 116 && Player.getY() == 557)){ //Jugador llegó a la última casilla del tablero
            BoardInterfaceServer.gameOver();
        }

        if(player.equals("Server")){
            //Aviso al Cliente para acutalizar movimiento, cambio de turno y chequeo de la casilla en la que se encuentra el jugador
            Server.sendMsg("Move");
            Server.updateMove(Player.getX(), Player.getY());
            Server.sendMsg("Turn");
            Server.sendMsg("go");
            BoardInterfaceServer.checkPos(BoardInterfaceServer.casillas);

        }else{
            //Aviso al Servidor para actualizar movimiento, cambio de turno y chequeo de la casilla en la que se encuentra el jugador
            Client.sendMsg("Move");
            Client.updateMove(Player.getX(), Player.getY());
            Client.sendMsg("Turn");
            Client.sendMsg("go");
            BoardInterfaceClient.checkPos(BoardInterfaceClient.casillas);
        }
    }

    /**
     * Método que contiene la funcionalidad y el movimiento de la casilla de trampa
     *
     * @param Player Parámetro que pasa el Label del jugador para su actualización
     * @param player Parámetro que define que jugador llamó al método
     */
    public static void Trap(JLabel Player, String player){
        int move = (int)(Math.random()*3)+1; //Cantidad de casillas a moverse, de 1 a 3
        System.out.println("Trap rest: " + move);

        //Devolver al jugador a la primera casilla del tablero y reduce el contador de casillas
        if(player.equals("Server")){
            if(BoardInterfaceServer.casillas - move < 0){
                Player.setLocation(66, Player.getY());
            }else{
                BoardInterfaceServer.casillas -= move;
            }
        }else{
            if(BoardInterfaceClient.casillas - move < 0){
                Player.setLocation(66, Player.getY());
            }else{
                BoardInterfaceClient.casillas -= move;
            }

        }

        if (Player.getY() == 107) { //Jugador en la primera fila del tablero
            int pos = 0;
            while(pos < move){
                if(Player.getX() == 66){
                    break;
                }
                Player.setLocation(Player.getX()-150, Player.getY()); //Movimeinto a la izquierda en la primera fila
                pos++;
            }
            if(Player.getX() < 66){
                Player.setLocation(66,Player.getY()); //Devuelve el jugador a la casilla de inicio si este se pasa
            }

        } else if(Player.getY() == 257) { //Jugador en la segunda fila del tablero
            int pos = 0;
            while(pos < move){
                if((Player.getX() == 516 && pos != move) || (Player.getX() == 566 && pos != move)){

                    if(player.equals("Server")){
                        Player.setLocation(Player.getX(), Player.getY()-150); //Devuelve el jugador a la primera fila
                        pos++;
                        for(int i = pos; i < move; i++) {
                            Player.setLocation(Player.getX()-150, Player.getY()); //Movimiento a la izquierda en la primera fila
                            pos++;
                        }
                        pos++;
                        break;

                    }else{
                        Player.setLocation(Player.getX()-50, Player.getY()-150); //Devuelve al jugador a la primera fila
                        pos++;
                        for(int i = pos; i < move; i++) {
                            Player.setLocation(Player.getX()-150, Player.getY()); //Movimiento a la izquierda en la primera fila
                            pos++;
                        }
                        pos++;
                        break;
                    }
                }
                Player.setLocation(Player.getX()+150, Player.getY()); //Movimiento a la derecha del jugador
                pos++;
            }

        } else if (Player.getY() == 407){ //Jugador en la tercera fila del tablero
            int pos = 0;
            while(pos < move){
                if((Player.getX() == 66 && pos != move) || (Player.getX() == 116 && pos != move)){
                    Player.setLocation(Player.getX(), Player.getY()-150); //Devuelve al jugador a la segunda fila del tablero
                    pos++;
                    for(int i = pos; i < move; i++) {
                        Player.setLocation(Player.getX()+150, Player.getY()); //Movimiento a la derecha en la segunda fila del tablero
                        pos++;
                    }
                    pos++;
                    break;
                }
                Player.setLocation(Player.getX()-150, Player.getY()); //Movimiento a la izquierda en la tercera fila del tablero
                pos++;
            }

        } else if (Player.getY() == 557) { //Jugador en la cuarta fila del tablero
            int pos = 0;
            while(pos < move){
                if((Player.getX() == 516 && pos != move) || (Player.getX() == 556 && pos != move)){
                    Player.setLocation(Player.getX(), Player.getY()-150); //Devuelve al jugador a la tercera fila del tablero
                    pos++;
                    for(int i = pos; i < move; i++) {
                        Player.setLocation(Player.getX()-150, Player.getY()); //Movimiento del jugador a la izquierda en la tercera fila
                        pos++;
                    }
                    pos++;
                    break;
                }
                Player.setLocation(Player.getX()+150, Player.getY()); //Moviento del jugador a la derecha en la cuarta fila
                pos++;
            }
        }
        if(player.equals("Server")){
            //Actualiza el movimiento del jugador
            Server.sendMsg("Move");
            Server.updateMove(Player.getX(), Player.getY());
            //Cambio de turno
            Server.sendMsg("Turn");
            Server.sendMsg("go");
            BoardInterfaceServer.checkPos(BoardInterfaceServer.casillas);

        }else{
            //Actualiza el movimiento del jugador
            Client.sendMsg("Move");
            Client.updateMove(Player.getX(), Player.getY());
            //Cambio de turno
            Client.sendMsg("Turn");
            Client.sendMsg("go");
            BoardInterfaceClient.checkPos(BoardInterfaceClient.casillas);
        }
    }

}








