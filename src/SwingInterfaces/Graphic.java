package SwingInterfaces;

import javax.swing.*;
import java.awt.*;

/**
 * Instituto Tecnológico de Costa Rica
 * Área de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: Graphic
 * @version 1.0
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 *
 * Descripción: Esta clase contiene el constructor de los cuadros que se dibujan en la ventana del tablero
 */
class Graphic extends JPanel {

    /**
     * Constructor que permite que se dibujen los componentes gráficos en la ventana del tablero
     *
     * @param graphics Parámetro para componentes gráficos
     */
    public void paint(Graphics graphics) {

        super.paint(graphics);

        graphics.setColor(Color.BLACK);
        graphics.drawRect(65,83,100,100);
        graphics.drawLine(165,133,215, 133); //
        graphics.setColor(Color.BLACK);
        graphics.drawRect(215,83,100,100);
        graphics.drawLine(315, 133,365,133); //
        graphics.setColor(Color.BLACK);
        graphics.drawRect(365,83,100,100);
        graphics.drawLine(465, 133,515,133); //
        graphics.setColor(Color.BLACK);
        graphics.drawRect(515,83,100,100);
        graphics.drawLine(565, 183, 565, 228); //

        graphics.setColor(Color.BLACK);
        graphics.drawRect(65,228,100,100);
        graphics.drawLine(165,278,215, 278); //
        graphics.drawLine(115,328,115,373); //
        graphics.setColor(Color.BLACK);
        graphics.drawRect(215,228,100,100);
        graphics.drawLine(315, 278,365,278); //
        graphics.setColor(Color.BLACK);
        graphics.drawRect(365,228,100,100);
        graphics.drawLine(465, 278,515,278); //
        graphics.setColor(Color.BLACK);
        graphics.drawRect(515,228,100,100);


        graphics.setColor(Color.BLACK);
        graphics.drawRect(65,373,100,100);
        graphics.drawLine(165,423,215, 423); //
        graphics.setColor(Color.BLACK);
        graphics.drawRect(215,373,100,100);
        graphics.drawLine(315, 423,365,423); //
        graphics.setColor(Color.BLACK);
        graphics.drawRect(365,373,100,100);
        graphics.drawLine(465, 423,515,423); //
        graphics.setColor(Color.BLACK);
        graphics.drawRect(515,373,100,100);
        graphics.drawLine(565, 473, 565, 518); //

        graphics.setColor(Color.BLACK);
        graphics.drawRect(65,518,100,100);
        graphics.drawLine(165,578,215, 578); //
        graphics.setColor(Color.BLACK);
        graphics.drawRect(215,518,100,100);
        graphics.drawLine(315, 578,365,578); //
        graphics.setColor(Color.BLACK);
        graphics.drawRect(365,518,100,100);
        graphics.drawLine(465, 578,515,578); //
        graphics.setColor(Color.BLACK);
        graphics.drawRect(515,518,100,100);

        graphics.setFont(new Font("default", Font.BOLD, 16));
        graphics.drawString("Start", 95, 100);
        graphics.drawString("Finish", 93, 535);

    }
}
