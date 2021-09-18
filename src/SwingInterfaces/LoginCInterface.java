package SwingInterfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginCInterface extends JFrame{
    private JFrame WindowC;
    private JButton Cbutton;
    private JTextField CUsername;
    private JLabel CBackground;
    private ImageIcon CImagenicon;

    public LoginCInterface() {
        CImagenicon = new ImageIcon("fondo.jpg");

        CUsername = new JTextField();
        CUsername.setBounds(150, 190, 300, 25);

        Cbutton = new JButton();
        Cbutton.setBounds(250, 230, 100, 30);
        Cbutton.setText("Star");
        Cbutton.addActionListener(new Action());

        CBackground = new JLabel(CImagenicon);
        CBackground.setSize(600,421);
        CBackground.add(CUsername);
        CBackground.add(Cbutton);

        WindowC = new JFrame();
        WindowC.setTitle("Login1");
        WindowC.setVisible(true);
        WindowC.setLayout(null);
        WindowC.setSize(600, 421);
        WindowC.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        WindowC.add(CBackground);
        WindowC.setResizable(false);
        WindowC.setLocationRelativeTo(null);

    }
    private class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String User = CUsername.getText();
            System.out.println(User);
            if (User.equals("")) {
                JOptionPane.showMessageDialog(WindowC, "Please enter your user name");
            } else {
                try {
                    BoardInterface brnRunnable = new BoardInterface();
                    WindowC.dispose();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
