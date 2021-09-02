package InterfacesSwing;

import javax.swing.*;

public class SalaEspera extends JFrame{
    private JPanel Jpanel;
    private JLabel BgLabel;

    public SalaEspera(){
        setContentPane(Jpanel);
        setVisible(true);
        setResizable(false);
        setSize(615,440);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BgLabel.setText("xd");
        BgLabel.setBounds(10,10,10,10);
    }

    public static void main(String[] args) {
        SalaEspera vent = new SalaEspera();
    }
}
