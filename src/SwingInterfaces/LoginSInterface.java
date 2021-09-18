package SwingInterfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginSInterface extends JFrame {
    private JLabel Background;
    private ImageIcon BGImage;
    private JFrame WindowS;
    private JTextField Username;
    private JButton Userbutton;

    public LoginSInterface() {
        BGImage = new ImageIcon("fondo.jpg");

        Username = new JTextField();
        Username.setBounds(150,190,300,25);

        Userbutton = new JButton();
        Userbutton.setBounds(250, 230, 100, 30);
        Userbutton.setText("Star");
        Userbutton.addActionListener(new Action());

        Background = new JLabel(BGImage);
        Background.setSize(600,421);
        Background.add(Username);
        Background.add(Userbutton);

        WindowS = new JFrame();
        WindowS.setTitle("Login2");
        WindowS.setVisible(true);
        WindowS.setLayout(null);
        WindowS.setSize(600,421);
        WindowS.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        WindowS.add(Background);
        WindowS.setResizable(false);
        WindowS.setLocationRelativeTo(null);
    }

    private class Action implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String Usrnm = Username.getText();
            System.out.println(Usrnm);
            if (Usrnm.equals("")) {
                JOptionPane.showMessageDialog(WindowS, "Please enter your user name");
            } else {
                try {
                    BoardInterface brnRunnable = new BoardInterface();
                    WindowS.dispose();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
