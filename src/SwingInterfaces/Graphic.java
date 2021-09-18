package SwingInterfaces;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
class Graphic extends JPanel {

    /**
     *
     * @param graphics
     */
    public void paint(Graphics graphics) {

        super.paint(graphics);

        graphics.setColor(Color.BLACK);
        graphics.drawRect(65,83,100,100);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(215,83,100,100);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(365,83,100,100);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(515,83,100,100);

        graphics.setColor(Color.BLACK);
        graphics.drawRect(65,228,100,100);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(215,228,100,100);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(365,228,100,100);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(515,228,100,100);

        graphics.setColor(Color.BLACK);
        graphics.drawRect(65,373,100,100);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(215,373,100,100);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(365,373,100,100);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(515,373,100,100);

        graphics.setColor(Color.BLACK);
        graphics.drawRect(65,518,100,100);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(215,518,100,100);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(365,518,100,100);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(515,518,100,100);

    }
}
