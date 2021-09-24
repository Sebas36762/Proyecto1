package SwingInterfaces;

import Socket.Client;
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
    private Client cli;

    /**
     * Constructor que contiene los componentes y elementos de la ventana, la interfaz gráfica en sí de la misma
     */
    public LoginCInterface(Client client) {
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
        WindowC.setTitle("Cliente");
        WindowC.setVisible(true);
        WindowC.setLayout(null);
        WindowC.setSize(600, 421);
        WindowC.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        WindowC.add(CBackground);
        WindowC.setResizable(false);

        this.cli = client;

    }
    private class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String User = CUsername.getText();
            System.out.println(User);
            if (User.equals("")) {
                JOptionPane.showMessageDialog(WindowC, "Please enter your user name");
            } else {
                try {
                    cli.sendMsg(User);
                    BoardInterfaceClient brnRunnable = new BoardInterfaceClient();
                    brnRunnable.getUsername(User);
                    WindowC.dispose();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
