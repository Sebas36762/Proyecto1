package DoubleLinkedList;
import java.io.Serializable;

/**
 * Instituto Tecnológico de Costa Rica
 * Área de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: DoubleNode
 * @version 1.0
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 *
 * Descripción: Esta clase contiene algunos de los métodos que se utilizan en la lista doblemente enlazada
 */
public class DoubleNode implements Serializable {

    private DoubleNode prev;
    private DoubleNode next;
    private char Type;
    private String ID;

    /**
     * Constructor de cuatro argumentos
     *
     * @param p Parámetro que da la casilla anterior
     * @param Id Parámetro que da el tipo de casilla
     * @param Id2 Parámetro que da el número de casilla
     * @param n Parámetro que da siguiente casilla
     */
    public DoubleNode(DoubleNode p, char Id, String Id2, DoubleNode n){
        prev = p;
        next = n;
        Type = Id;
        ID = Id2;
    }

    /**
     * Método que optiene el número de la casilla
     *
     * @return Retorno del número de la casilla
     */
    public String getID(){
        return ID;
    }

    /**
     * Método que captura el tipo de casilla
     *
     * @return Retorno del tipo de casilla
     */
    public String getC(){
        return String.valueOf(Type);
    }

    /**
     * Método para apuntar a la siguiente casilla
     *
     * @return Retorno de un puntero a la siguiente casilla
     */
    public DoubleNode getNext(){
        return next;
    }

    /**
     * Método que permite apuntar a la casilla anterior
     *
     * @param p Parámetro que permite apuntar a la casilla anterior
     */
    public void setPrev(DoubleNode p){
        prev = p;
    }

    /**
     * Método que convierte los char a string
     *
     * @return Retorno de la convesion
     */
    public String toString(){
        return Character.toString(Type);
    }
}