package SwingInterfaces.loginScreen;

import SwingInterfaces.waitingScreen.waitingInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class loginInterface extends JFrame{
    private JPanel loginPane;
    private JButton loginButton;
    private JTextField loginTextField;

    public loginInterface() {
        setContentPane(loginPane);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 421);
        setVisible(true);
        setResizable(false);



        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = loginTextField.getText();
                System.out.println(userName);
                if (loginTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(loginPane,"Please enter your user name");
                } else {
                    waitingInterface runnable = new waitingInterface();
                    setLoginPane();
                }
            }
        });
    }


    public static void main(String[] args) {
        loginInterface runnable = new loginInterface();
    }

    public void setLoginPane() { dispose(); }

}
