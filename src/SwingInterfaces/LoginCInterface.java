package SwingInterfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginCInterface extends JFrame{
    private JFrame CFrame;
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

        CFrame = new JFrame();
        CFrame.setTitle("Login1");
        CFrame.setVisible(true);
        CFrame.setLayout(null);
        CFrame.setSize(600, 421);
        CFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CFrame.add(CBackground);
        CFrame.setResizable(false);
        CFrame.setLocationRelativeTo(null);

    }
    private class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String User = CUsername.getText();
            System.out.println(User);
            if (User.equals("")) {
                JOptionPane.showMessageDialog(CFrame, "Please enter your user name");
            }
        }
    }
}
