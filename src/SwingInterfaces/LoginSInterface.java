package SwingInterfaces;

import DoubleLinkedList.DoubleLinkedList;
import Socket.Server;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

/**
 * Instituto Tecnológico de Costa Rica
 * Área de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: LoginSInterface
 * @version 1.0
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 *
 * Descripción: Esta clase contiene los componentes de la interfaz gráfica del login de los jugadores y contiene la subclase
 * del funcionamiento del botón
 */
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

    /**
     * Instituto Tecnológico de Costa Rica
     * Área de Ingeniería en Computadores
     *
     * Sub-clase: Action (Recreación de action Listener)
     * @version 1.0
     * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
     *
     * Descripción: Esta sub-clase contiene el método que le da el funcionamiento al botón del login
     */
    private class Action implements ActionListener {

        /**
         * Método de escucha del botón el cual toma los datos ingresados en el text field, lanza un popup en caso de que
         * el botón al ser activado no guarde nada ingresado en el text field y cierra la ventana de espera
         *
         * @param e Parámetro de eventos del ActionListener
         */
        public void actionPerformed(ActionEvent e) {
            String Usrnm = Username.getText();
            System.out.println(Usrnm);
            if (Usrnm.equals("")) {
                JOptionPane.showMessageDialog(WindowS, "Please enter your user name");
            } else {
                try {
                    server.sendMsg(Usrnm);
                    DoubleLinkedList list = new DoubleLinkedList();
                    String List = list.showList();
                    Server.sendList(List);
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
