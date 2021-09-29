package BoardElements;
import javax.swing.*;

/**
 * Instituto Tecnológico de Costa Rica
 * Area de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: Dice
 * @version 1.0
 * @author Byron Mata, Gustavo Alvarado y Sebastián Chaves
 *
 * Descripción: Esta clase contiene la funcionalidad del dado
 */
public class Dice {

    /**
     * Declaración de la variable con la cual la clase se instancia a si misma
     * Parte del Singleton Pattern
     */
    private static Dice Instance = new Dice();

    /**
     * Constructor vacío del dado
     */
    private Dice(){ }

    /**
     * Método que contiene la funcionalidad del dado por medio Math.random para la selección de un número al azar
     *
     * @return Retorno de un número al azar
     */
    public int shot() {
        return (int)(Math.random()*4) + 1;
    }

    /**
     * Método que contiene el print de un número tipo entero seleccionado al azar y contiene el update del label
     * referenciado
     *
     * @param label Parámetro de referencia label que se actualiza
     * @param Numero Parámetro de tipo entero para hacer print en la actualización del label
     */
    public void updateLabel(JLabel label, int Numero){
        label.setText(String.valueOf(Numero));
    }

    /**
     * Método por medio del cual se puede invocar la clase desde cualquier otra clase y se pude realizar el 
     * instanciamiento de la clase
     *
     * @return Retorna de la variable que se utiliza para instanciar la clase en sí misma
     */
    public static Dice getInstance() {
        return Instance;
    }

}
