package BoardElements;

import javax.swing.*;

/**
 * Instituto Tecnológico de Costa Rica
 * Área de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: Dice
 * @version 1.0
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 *
 * Descripción: Esta clase contiene la funcionalidad del dado
 */
public class Dice {
    private static Dice Instance = new Dice();

    /**
     * Constructor del dado
     *
     */
    private Dice(){ }

    /**
     * Método que contiene: - Funcionalidad del dado
     *                      - Math.random para la selección de un número al azar
     *
     * @return Retorno de un número al azar
     */
    public int shot() {
        return (int)(Math.random()*4) + 1;
    }

    /**
     * Método que contiene: - El print de un número tipo entero seleccionado al azar
     *                      - El update del label referenciado
     *
     * @param label Parámetro de referencia label que se actualiza
     * @param Numero Parámetro de tipo entero para hacer print en la actualización del label
     */
    public void updateLabel(JLabel label, int Numero){
        label.setText(String.valueOf(Numero));
    }

    public static Dice getInstance(){
        return Instance;
    }

}
