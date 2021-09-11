package SwingInterfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSInterface extends JFrame {
    private JLabel Background;
    private ImageIcon BGImage;
    private JFrame Window;
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

        Window = new JFrame();
        Window.setTitle("Login");
        Window.setVisible(true);
        Window.setLayout(null);
        Window.setSize(600,421);
        Window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Window.add(Background);
        Window.setResizable(false);
        Window.setLocationRelativeTo(null);
    }

    private class Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String Usrnm = Username.getText();
            System.out.println(Usrnm);
            if (Usrnm.equals("")) {
                JOptionPane.showMessageDialog(Window, "Please enter your user name");
            }
        }
    }

}
