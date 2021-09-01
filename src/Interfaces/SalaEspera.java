package Interfaces;

import javax.swing.*;

public class SalaEspera extends JFrame{
    private JPanel Jpanel;

    public SalaEspera(){
        setContentPane(Jpanel);
        setVisible(true);
        setSize(400,225);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SalaEspera vent = new SalaEspera();

    }
}
