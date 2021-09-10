package SwingInterfaces.waitingScreen;

import javax.swing.*;
import java.io.DataInputStream;

public class waitingInterface extends JFrame {
    private JPanel waitPane;
    private JLabel waitLabel;

    public waitingInterface() {
        setContentPane(waitPane);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 421);
        setVisible(true);
        setResizable(false);
    }
}
