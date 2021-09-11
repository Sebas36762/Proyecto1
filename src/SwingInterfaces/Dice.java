package SwingInterfaces;

import javax.swing.*;

/**
 * Instituto Tecnológico de Costa Rica
 * Área de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: Dado
 * @version 1.0
 * @author Byron Mata
 * Descripción: Esta clase contiene la funcionalidad del dado
 */
public class Dice {
    private int Dicefaces;

    /**
     * Constructor que crea el dado
     * @param Dicefaces Parámetro para ingresar el número de caras del dado
     */
    public Dice(int Dicefaces) {
        this.Dicefaces = Dicefaces;
    }

    /**
     * Método para la tirada del dado y obtener un número al azar
     * @return retorna un número al azar
     */
    public int shot() {
        return (int)(Math.random()*this.Dicefaces) + 1;
    }

    public static void main(String[] args) {
        Dice myD = new Dice(4);
        System.out.println(myD.shot());
    }

    public void updateLabel(JLabel label, int Numero){
        label.setText(String.valueOf(Numero));
    }



}
