package BoardElements;
import javax.swing.*;

/**
 * Instituto Tecnológico de Costa Rica
 * Área de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: StackLabels
 * @version 1.0
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 *
 * Descripción: Esta clase contiene la pila de los Jlabel que  utilizan en el tablero a su vez contiene algunos métodos
 * que se aplican para su uso los cuales contiene funcinalidades como: la inserción de un objeto u elemento, la posibilidad
 * de sacar el objeto o elemento del top y para poder leer el objeto o elemento ubicado en el top de la pila
 */
public class StackLabels {
    private static Object[] stackLabels;
    private static int top = -1;

    /**
     * Constructor de de la pila donde se le define el tamaño de esta
     */
    public StackLabels(){
        stackLabels = new Object[14];
    }

    /**
     * Método para insertar un objeto en la pila
     *
     * @param label Parámetro que se le pasa para insertar el JLabel
     */
    public static void push(JLabel label){
        stackLabels[++top] = label;
    }

    /**
     * Método para sacar un objeto o elemento de la pila
     *
     * @return Retorno de la pila menos el objeto del top
     */
    public static Object pop(){
        return stackLabels[top--];
    }

    /**
     * Método para leer el objeto o el elemento del top de la pila
     *
     * @return Retorno del objeto o elemento ubicado en el top de la pila
     */
    public static Object peek(){
        return stackLabels[top];
    }
}
