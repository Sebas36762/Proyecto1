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
    private JButton Rbutton, Extbutton;
    private String player;
    private JLabel Player;

    /**
     * Constructor que contiene los componentes y elementos de la ventana de la casilla de reto, además de su interfaz gráfica
     * en sí
     */
    public ChallengeInterface (String Player, JLabel player) {

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
                        Server.sendMsg("Move");
                        Server.updateMove(Player.getX(), Player.getY());
                        Server.sendMsg("Verify");
                        Server.sendMsg(DoubleLinkedList.values+","+Rtextf.getText());

                    }else{
                        Client.sendMsg("Move");
                        Client.updateMove(Player.getX(), Player.getY());
                        Client.sendMsg("Verify");
                        Client.sendMsg(DoubleLinkedList.values+","+Rtextf.getText());
                    }
                    Rwindow.dispose();
                }
            }
        }
    }

}
