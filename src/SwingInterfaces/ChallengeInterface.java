package SwingInterfaces;
import DoubleLinkedList.DoubleLinkedList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Instituto Tecnológico de Costa Rica
 * Área de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: ChallengeInterface
 * @version 1.2
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 *
 * Descripción: Esta clase contiene los diferentes componentes que conforman la ventana de la casilla de reto
 */
public class ChallengeInterface extends JFrame {
    private JFrame Rwindow;
    private JLabel Rlabel;
    private JTextField Rtextf;
    private JButton Rbutton;

    /**
     * Constructor que contiene los componentes y elementos de la ventana de la casilla de reto, además de su interfaz gráfica
     * en sí
     */
    public ChallengeInterface () {

        Rlabel = new JLabel();
        Rlabel.setBounds(83,3,100,100);
        Rlabel.setFont(new Font("default",Font.BOLD,16));
        Rlabel.setForeground(Color.black);
        Rlabel.setText(DoubleLinkedList.Mathchallenge());

        Rtextf = new JTextField();
        Rtextf.setBounds(45,90,150,25);

        Rbutton = new JButton();
        Rbutton.setBounds(45,125,150,25);
        Rbutton.setText("Answer");
        Rbutton.addActionListener(new ChallengeInterface.Action());

        Rwindow = new JFrame();
        Rwindow.setTitle("Challenge");
        Rwindow.setVisible(true);
        Rwindow.setLayout(null);
        Rwindow.setSize(250,200);
        Rwindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Rwindow.setResizable(false);
        Rwindow.setLocationRelativeTo(null);

        Rwindow.add(Rlabel);
        Rwindow.add(Rbutton);
        Rwindow.add(Rtextf);

    }

    /**
     * Instituto Tecnológico de Costa Rica
     * Área de Ingeniería en Computadores
     *
     * Sub-clase: Action (Recreación de action Listener)
     * @version 1.0
     * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
     *
     * Descripción: Esta sub-clase contiene el método que permite realizar el envío y comprobación del resultado de la
     * operación matemática, por medio del accionar del botón
     */
    public class Action implements ActionListener {

        /**
         * Método de escucha del botón que contiene la opción de capturar el dato ingresado (respuesta de la operación
         * matemática), la cual a la vez es verificada
         *
         * @param e Parámetro de eventos del ActionListener
         */
        public void actionPerformed(ActionEvent e) {
            String ansnumb = Rtextf.getText();
            System.out.println(ansnumb);
            if (Rtextf.getText().equals("")) {
                JOptionPane.showMessageDialog(Rwindow, "Please answer the challenge");
            } else {
                if (ansnumb.equals(DoubleLinkedList.values)) {
                    Rwindow.dispose();
                } else {
                    Rwindow.dispose();
                }
            }
        }
    }

}
