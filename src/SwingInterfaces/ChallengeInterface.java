package SwingInterfaces;
import DoubleLinkedList.DoubleLinkedList;
import Socket.Client;
import Socket.Server;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Instituto Tecnológico de Costa Rica
 * Area de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: ChallengeInterface
 * @version 1.2
 * @author Byron Mata, Gustavo Alvarado y Sebastián Chaves
 *
 * Descripción: Esta clase contiene los diferentes componentes que conforman la ventana de la casilla de reto
 */
public class ChallengeInterface extends JFrame {
    private JFrame Rwindow, Chgwindow;
    private JLabel Rlabel, Rsltlabel, Answrlabel;
    private JTextField Rtextf;
    private JButton Rbutton, Extbutton;
    private String player;
    private JLabel Player;

    /**
     * Constructor que contiene los componentes y elementos de la ventana de la casilla de reto, además de su interfaz gráfica
     * en sí
     *
     * @param player Parámetro para realizar el movimiento del jugador
     * @param Player Parámetro para indetificar si se es cliente o servidor
     */
    public ChallengeInterface (String Player, JLabel player) {

        //Creación y agregación de elementos a la ventana
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

        this.player = Player;
        this.Player = player;
    }

    /**
     * Constructor que contiene los componentes y elementos de la ventana que avisa del resultado de la operación y de
     * la respuesta, además de su interfaz gráfica como tal y la funcionalidad de un botón para cerrarla
     *
     * @param resultado Parámetro que se le pasa el valor ingresado por quien responde el reto
     * @param respuesta Parámetro que le pasa el valor que se espera de respuesta para la operación
     */
    public ChallengeInterface (String resultado, String respuesta) {

        //Creación y agregación de elementos a la ventana
        Rsltlabel = new JLabel();
        Rsltlabel.setBounds(18,15,300,100);
        Rsltlabel.setFont(new Font("default",Font.BOLD,16));
        Rsltlabel.setForeground(Color.black);
        Rsltlabel.setText("> The result of the operation is: "+resultado);

        Answrlabel = new JLabel();
        Answrlabel.setBounds(18,40,300,100);
        Answrlabel.setFont(new Font("default", Font.BOLD,16));
        Answrlabel.setForeground(Color.black);
        Answrlabel.setText("> The opponent's response: "+respuesta);

        Extbutton = new JButton("Close");
        Extbutton.setBounds(110, 180, 100, 40);
        Extbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chgwindow.dispose();
            }
        });

        Chgwindow = new JFrame();
        Chgwindow.setTitle("Check");
        Chgwindow.setVisible(true);
        Chgwindow.setLayout(null);
        Chgwindow.setSize(350,300);
        Chgwindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Chgwindow.setResizable(false);
        Chgwindow.setLocationRelativeTo(null);

        Chgwindow.add(Answrlabel);
        Chgwindow.add(Rsltlabel);
        Chgwindow.add(Extbutton);

    }

    /**
     * Instituto Tecnológico de Costa Rica
     * Area de Ingeniería en Computadores
     *
     * Sub-clase: Action (Recreación de action Listener)
     * @version 1.0
     * @author Byron Mata, Gustavo Alvarado y Sebastián Chaves
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
            //System.out.println(ansnumb);
            if (Rtextf.getText().equals("")) {
                JOptionPane.showMessageDialog(Rwindow, "Please answer the challenge");
            } else {
                if (ansnumb.equals(DoubleLinkedList.values)) {
                    if (player.equals("Server")){

                        //Mensaje para lanzar verificación del reto
                        Server.sendMsg("Verify");
                        Server.sendMsg(DoubleLinkedList.values+","+Rtextf.getText());

                    }else{

                        //Mensaje para lanzar verificación del reto
                        Client.sendMsg("Verify");
                        Client.sendMsg(DoubleLinkedList.values+","+Rtextf.getText());
                    }
                    Rwindow.dispose();
                } else {
                    //Movimiento hacia atrás al fallar el reto
                    int move = 1;
                    if (Player.getY() == 107) {
                        int pos = 0;
                        while(pos < move){
                            if(Player.getX() == 66){
                                break;
                            }
                            Player.setLocation(Player.getX()-150, Player.getY());
                            pos++;
                        }
                        if(Player.getX() < 66){
                            Player.setLocation(66,Player.getY());
                        }

                    } else if(Player.getY() == 257) {
                        int pos = 0;
                        while(pos < move){
                            if((Player.getX() == 516 && pos != move) || (Player.getX() == 566 && pos != move)){

                                if(player.equals("Server")){
                                    Player.setLocation(Player.getX(), Player.getY()-150);
                                    pos++;
                                    for(int i = pos; i < move; i++) {
                                        Player.setLocation(Player.getX()-150, Player.getY());
                                        pos++;
                                    }
                                    pos++;
                                    break;

                                }else{
                                    Player.setLocation(Player.getX()-50, Player.getY()-150);
                                    pos++;
                                    for(int i = pos; i < move; i++) {
                                        Player.setLocation(Player.getX()-150, Player.getY());
                                        pos++;
                                    }
                                    pos++;
                                    break;
                                }
                            }
                            Player.setLocation(Player.getX()+150, Player.getY());
                            pos++;
                        }

                    } else if (Player.getY() == 407){
                        int pos = 0;
                        while(pos < move){
                            if((Player.getX() == 66 && pos != move) || (Player.getX() == 116 && pos != move)){
                                Player.setLocation(Player.getX(), Player.getY()-150);
                                pos++;
                                for(int i = pos; i < move; i++) {
                                    Player.setLocation(Player.getX()+150, Player.getY());
                                    pos++;
                                }
                                pos++;
                                break;
                            }
                            Player.setLocation(Player.getX()-150, Player.getY());
                            pos++;
                        }

                    } else if (Player.getY() == 557) {
                        int pos = 0;
                        while(pos < move){
                            if((Player.getX() == 516 && pos != move) || (Player.getX() == 556 && pos != move)){
                                Player.setLocation(Player.getX(), Player.getY()-150);
                                pos++;
                                for(int i = pos; i < move; i++) {
                                    Player.setLocation(Player.getX()-150, Player.getY());
                                    pos++;
                                }
                                pos++;
                                break;
                            }
                            Player.setLocation(Player.getX()+150, Player.getY());
                            pos++;
                        }
                    }
                    if(player.equals("Server")){
                        //Actualización del movimiento
                        Server.sendMsg("Move");
                        Server.updateMove(Player.getX(), Player.getY());
                        //Mensaje para lanzar la ventana de verificación
                        Server.sendMsg("Verify");
                        Server.sendMsg(DoubleLinkedList.values+","+Rtextf.getText());

                    }else{
                        //Actualización del movimiento
                        Client.sendMsg("Move");
                        Client.updateMove(Player.getX(), Player.getY());
                        //Mensaje para lanzar la ventana de verificación
                        Client.sendMsg("Verify");
                        Client.sendMsg(DoubleLinkedList.values+","+Rtextf.getText());
                    }
                    Rwindow.dispose();
                }
            }
        }
    }

}
