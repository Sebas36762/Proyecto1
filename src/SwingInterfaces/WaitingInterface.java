package SwingInterfaces;

import Socket.Client;
import Socket.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Instituto Tecnológico de Costa Rica
 * Area de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: WaitingInterface
 * @version 1.0
 * @author Byron Mata, Gustavo Alvarado y Sebastián Chaves
 *
 * Descripción: Esta clase contiene la ventana de espera
 */
public class WaitingInterface extends JFrame {
    private JLabel Sbackground;
    private ImageIcon SBGImage;
    private JFrame Swindow;
    private JLabel Slabel;

    /**
     * Constructor que contiene los componentes y elementos de la ventana
     *
     * @throws IOException Excepción en caso de que ocurra algún problema
     */
    public WaitingInterface() throws IOException {

        //Creación y agregación de elementos a la ventana
        SBGImage = new ImageIcon("fondo.jpg");

        Slabel = new JLabel();
        Slabel.setBounds(190, 182, 300, 50);
        Slabel.setFont(new Font("default", Font.PLAIN, 19));
        Slabel.setForeground(Color.white);
        Slabel.setText("WAITING PLAYER...");

        Sbackground = new JLabel(SBGImage);
        Sbackground.setSize(600,421);
        Sbackground.add(Slabel);

        Swindow = new JFrame();
        Swindow.setTitle("Waiting Room");
        Swindow.setVisible(true);
        Swindow.setLayout(null);
        Swindow.setSize(600,421);
        Swindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Swindow.add(Sbackground);
        Swindow.setResizable(false);
        Swindow.setLocationRelativeTo(null);

        Server Srv = new Server();
        Srv.linkS(); //Inicia la conexión del servidor
        Swindow.dispose();
        LoginSInterface LgnW = new LoginSInterface(Srv);
    }

}
