package SwingInterfaces;

import Socket.Client;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Instituto Tecnológico de Costa Rica
 * Área de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: LoginCInterface
 * @version 1.0
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 *
 * Descripción: Esta clase contiene los componentes de la interfaz gráfica del login de los jugadores y contiene la subclase
 * del funcionamiento del botón
 */
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

        //Creación y agregación de elementos a la ventana
        CImagenicon = new ImageIcon("fondo.jpg");

        CUsername = new JTextField();
        CUsername.setBounds(150, 190, 300, 25);

        Cbutton = new JButton();
        Cbutton.setBounds(250, 230, 100, 30);
        Cbutton.setText("Start");
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
            String User = CUsername.getText(); //Nombre del cliente
            System.out.println(User);
            if (User.equals("")) {
                JOptionPane.showMessageDialog(WindowC, "Please enter your user name");
            } else {
                try {
                    cli.sendMsg(User); //Envío de nombre del cliente a servidor
                    BoardInterfaceClient brnRunnable = new BoardInterfaceClient();
                    brnRunnable.getUsername(User); //Pasa el nombre de cliente al tablero
                    WindowC.dispose();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
