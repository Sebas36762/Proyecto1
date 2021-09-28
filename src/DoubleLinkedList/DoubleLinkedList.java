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
     * Constructor de un nuevo objeto "Double Linked List" con head y tail comnulos
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
            int probability = (int)(Math.random()*3)+1;
            if(probability == 1 && this.trampa <4){
                addCasilla('A', String.valueOf(i));
                this.trampa++;
                i++;

            }else if(probability == 2 && this.reto <7){
                addCasilla('R', String.valueOf(i));
                this.reto++;
                i++;

            }else if (probability == 3 && this.tunel <3){
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
            //System.out.print(cn.getC());
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
            if (objective.getID().equals(Id)) {
                return objective.getC();
            }else{
                objective = objective.getNext();
            }
        }
        return null;
    }

    /**
     * Método que realiza la creación de una operación matemática aleatorea
     *
     * @return Retorno de la variable "format" que contiene el formato de la operación aleatorea
     */
    public static String Mathchallenge() {
        Random r = new Random();
        int A = (int) (Math.random()*50+1);
        int B = (int) (Math.random()*50+1);
        char operator ='?';
        int value = 0;

        switch (r.nextInt(4)){
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
            default: operator = '?';
        }
        values = (String.valueOf(value));
        String format = (String.valueOf(A)+" "+String.valueOf(operator)+" "+String.valueOf(B));
        return format;
    }

    /**
     * Método que contiene la funcionalidad de la casilla de tunel, asignado su movimiento de manera aleatoria
     *
     * @param Player Parámetro del jugador
     */
    public static void Tunel(JLabel Player, String player){

        int move = (int)(Math.random()*3)+1;
        System.out.println("Tunel move: " + move);
        if(player.equals("Server")){
            BoardInterfaceServer.casillas += move;
        }else{
            BoardInterfaceClient.casillas +=move;
        }

        if (Player.getY() == 107) {
            int pos = 0;
            while(pos < move){
                if(Player.getX() == 516 && pos != move){
                    if(player.equals("Server")){
                        Player.setLocation(Player.getX(), Player.getY()+150);
                        pos++;
                        for(int i = pos; i < move; i++) {
                            Player.setLocation(Player.getX()-150, Player.getY());
                            pos++;
                        }
                        pos++;
                        break;

                    }else{
                        Player.setLocation(Player.getX()+50, Player.getY()+150);
                        pos++;
                        for(int i = pos; i < move; i++) {
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

        } else if(Player.getY() == 257) {
            int pos = 0;
            while(pos < move){
                if((Player.getX() == 66 && pos != move)||(Player.getX() == 116 && pos != move)){
                    Player.setLocation(Player.getX(), Player.getY()+150);
                    pos++;
                    for(int i = pos; i < move; i++) {
                        Player.setLocation(Player.getX()+150, Player.getY());
                        pos++;
                    }
                    pos++;
                    break;
                }
                Player.setLocation(Player.getX()-150, Player.getY());
                pos++;
            }

        } else if (Player.getY() == 407){
            int pos = 0;
            while(pos < move){
                if((Player.getX() == 516 && pos != move)||(Player.getX() == 566 && pos != move)){
                    Player.setLocation(Player.getX(), Player.getY()+150);
                    pos++;
                    for(int i = pos; i < move; i++) {
                        Player.setLocation(Player.getX()-150, Player.getY());
                        pos++;
                    }
                    pos++;
                    break;
                }
                Player.setLocation(Player.getX()+150, Player.getY());
                pos++;
            }

        } else if (Player.getY() == 557) {
            int pos = 0;
            while(pos < move){
                if((Player.getX() == 66 && Player.getY() == 557)||(Player.getX() == 116 && Player.getY() == 557)){
                    BoardInterfaceServer.gameOver();
                    break;
                }
                Player.setLocation(Player.getX()-150, Player.getY());
                pos++;
            }

        }if((Player.getX() == 66 && Player.getY() == 557)||(Player.getX() == 116 && Player.getY() == 557)){
            BoardInterfaceServer.gameOver();
        }

        if(player.equals("Server")){
            Server.sendMsg("Move");
            Server.updateMove(Player.getX(), Player.getY());
            Server.sendMsg("Turn");
            Server.sendMsg("go");
            BoardInterfaceServer.checkPos(BoardInterfaceServer.casillas);

        }else{
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
     * @param Player Parámetro del jugador
     */
    public static void Trap(JLabel Player, String player){
        int move = (int)(Math.random()*3)+1;
        boolean flag = true;
        System.out.println("Trap rest: " + move);

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

        if (Player.getY() == 107) {
            int pos = 0;
            while(pos < move){
                if(Player.getX() == 66){
                    break;
                }
                Player.setLocation(Player.getX()-150, Player.getY());
                pos++;
            }
            if(Player.getX() < 66){
                Player.setLocation(66,Player.getY());
            }

        } else if(Player.getY() == 257) {
            int pos = 0;
            while(pos < move){
                if((Player.getX() == 516 && pos != move) || (Player.getX() == 566 && pos != move)){

                    if(player.equals("Server")){
                        Player.setLocation(Player.getX(), Player.getY()-150);
                        pos++;
                        for(int i = pos; i < move; i++) {
                            Player.setLocation(Player.getX()-150, Player.getY());
                            pos++;
                        }
                        pos++;
                        break;

                    }else{
                        Player.setLocation(Player.getX()-50, Player.getY()-150);
                        pos++;
                        for(int i = pos; i < move; i++) {
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

        } else if (Player.getY() == 407){
            int pos = 0;
            while(pos < move){
                if((Player.getX() == 66 && pos != move) || (Player.getX() == 116 && pos != move)){
                    Player.setLocation(Player.getX(), Player.getY()-150);
                    pos++;
                    for(int i = pos; i < move; i++) {
                        Player.setLocation(Player.getX()+150, Player.getY());
                        pos++;
                    }
                    pos++;
                    break;
                }
                Player.setLocation(Player.getX()-150, Player.getY());
                pos++;
            }

        } else if (Player.getY() == 557) {
            int pos = 0;
            while(pos < move){
                if((Player.getX() == 516 && pos != move) || (Player.getX() == 556 && pos != move)){
                    Player.setLocation(Player.getX(), Player.getY()-150);
                    pos++;
                    for(int i = pos; i < move; i++) {
                        Player.setLocation(Player.getX()-150, Player.getY());
                        pos++;
                    }
                    pos++;
                    break;
                }
                Player.setLocation(Player.getX()+150, Player.getY());
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








