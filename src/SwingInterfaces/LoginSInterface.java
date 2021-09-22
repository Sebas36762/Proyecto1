package SwingInterfaces;

import Socket.Server;
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
    private Server server;

    /**
     * Constructor que contiene los componentes y elementos de la ventana, la interfaz gráfica en sí de la misma
     */
    public LoginSInterface(Server server) {
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
        WindowS.setTitle("Server");
        WindowS.setVisible(true);
        WindowS.setLayout(null);
        WindowS.setSize(600,421);
        WindowS.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        WindowS.add(Background);
        WindowS.setResizable(false);
        WindowS.setLocationRelativeTo(null);

        this.server = server;
    }

    private class Action implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String Usrnm = Username.getText();
            System.out.println(Usrnm);
            if (Usrnm.equals("")) {
                JOptionPane.showMessageDialog(WindowS, "Please enter your user name");
            } else {
                try {
                    server.sendMsg(Usrnm);
                    BoardInterfaceServer brnRunnable = new BoardInterfaceServer();
                    brnRunnable.getUsername(Usrnm);
                    WindowS.dispose();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
