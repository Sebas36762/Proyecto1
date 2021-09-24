package SwingInterfaces;

import BoardElements.Dice;
import BoardElements.Labels;
import DoubleLinkedList.DoubleLinkedList;
import Socket.Server;
import Socket.ServerThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * Instituto Tecnológico de Costa Rica
 * Área de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: BoardInterface
 * @version 2.4
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 *
 * Descripción: Esta clase contiene los diferentes componentes que conforman la ventana del tablero, así mismo posee
 * la funcionalidad del movimiento de acuerdo a los dados desde el accionar del botón
 */
public class BoardInterfaceServer extends JFrame {
    private JFrame Bwindow;
    private JLabel Userlabel;
    private JLabel Enemylabel;
    private JLabel DiceLabel;
    private JLabel Dicenumber;
    private static JButton Dicebutton;
    public static JLabel Player;
    private static JLabel Player2;
    private static String name;

    /**
     * Constructor que contiene los componentes y elementos de la ventana y la interfaz gráfica en sí de la misma
     *
     * @throws IOException Excepción en caso de que ocurra algún problema
     */
    public BoardInterfaceServer() throws IOException {

        Userlabel = new JLabel();
        Userlabel.setBounds(25, 0, 150, 50);
        Userlabel.setFont(new Font("default", Font.BOLD, 16));
        Userlabel.setForeground(Color.blue);
        Userlabel.setText("> You: ...");

        Enemylabel = new JLabel();
        Enemylabel.setBounds(25, 27, 150, 50);
        Enemylabel.setFont(new Font("default", Font.BOLD, 16));
        Enemylabel.setForeground(Color.red);
        boolean run = true;
        while(run){
            String Name = ServerThread.username;
            if(Name != null){
                Enemylabel.setText(">User: " + ServerThread.username);
                run = false;
            }
        }

        DiceLabel = new JLabel();
        DiceLabel.setBounds(25, 625, 250, 50);
        DiceLabel.setFont(new Font("default", Font.BOLD, 16));
        DiceLabel.setForeground(Color.black);
        DiceLabel.setText("> The number on the dice is: ");

        Dicenumber = new JLabel();
        Dicenumber.setBounds(255, 625, 100, 50);
        Dicenumber.setFont(new Font("default", Font.BOLD, 16));
        Dicenumber.setForeground(Color.black);

        CasillaType = new JLabel();
        CasillaType.setText("R = Reto | T = Trampa | A = Tunel");
        CasillaType.setBounds(200,0, 400,50);
        CasillaType.setFont(new Font("default", Font.BOLD, 20));

        Caller = new JLabel();
        Caller.setBounds(310, 35,100,50);
        Caller.setFont(new Font("default", Font.BOLD, 16));

        Dicebutton = new JButton();
        Dicebutton.setBounds(575, 638, 80, 25);
        Dicebutton.setText("Dice");
        Dicebutton.addActionListener(new BoardInterfaceServer.Action());

        ImageIcon avatar = new ImageIcon("avatar.png");
        Player = new JLabel(avatar);
        Player.setBounds(66,107,50,50);

        ImageIcon avatar2 = new ImageIcon("aavatar.png");
        Player2 = new JLabel(avatar2);
        Player2.setBounds(115,107,50,50);

        Graphic g = new Graphic();

        Bwindow = new JFrame("Server");
        Bwindow.setVisible(true);

        Bwindow.setSize(700, 720);
        Bwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Bwindow.setResizable(false);
        Bwindow.setLocationRelativeTo(null);

        Bwindow.add(Userlabel);
        Bwindow.add(Enemylabel);
        Bwindow.add(DiceLabel);
        Bwindow.add(Dicenumber);
        Bwindow.add(Dicebutton);
        Bwindow.add(Player);
        Bwindow.add(Player2);
        Bwindow.add(CasillaType);
        Bwindow.add(Caller);

        Labels.Labels();
        Bwindow.add(Labels.Lb1);
        Bwindow.add(Labels.Lb2);
        Bwindow.add(Labels.Lb3);
        Bwindow.add(Labels.Lb4);
        Bwindow.add(Labels.Lb5);
        Bwindow.add(Labels.Lb6);
        Bwindow.add(Labels.Lb7);
        Bwindow.add(Labels.Lb8);
        Bwindow.add(Labels.Lb9);
        Bwindow.add(Labels.Lb10);
        Bwindow.add(Labels.Lb11);
        Bwindow.add(Labels.Lb12);
        Bwindow.add(Labels.Lb13);
        Bwindow.add(Labels.Lb14);

        Bwindow.add(g);

    }

    /**
     *
     * @param name
     */
    public void getUsername(String name){
        Userlabel.setText(">You: " + name);
    }

    /**
     * Método que verificar la posición en la que el jugador se encuentra y que dependiendo de la casilla realice
     * el movimeinto definido
     *
     * @param pos Parámetro tipo entero para acceder y verificar la posición
     */
    public static void checkPos(int pos){
        System.out.println("Check " + String.valueOf(pos));
        if(pos == 1){
            if((Labels.Lb1).getText().equals("R")){
                ChallengeInterface vent = new ChallengeInterface();
                Caller.setText("Reto!");
                Server.sendMsg("Ready");
                Server.sendMsg("Chg");

            }else if((Labels.Lb1).getText().equals("T")){
                DoubleLinkedList.Trap(Player, "Server");
                Caller.setText("Trampa!");

            }else if ((Labels.Lb1).getText().equals("A")){
                DoubleLinkedList.Tunel(Player, "Server");
                Caller.setText("Tunel!");
            }

        }else if(pos == 2){
            if((Labels.Lb2).getText().equals("R")){
                ChallengeInterface vent = new ChallengeInterface();
                Caller.setText("Reto!");
                Server.sendMsg("Ready");
                Server.sendMsg("Chg");

            }else if((Labels.Lb2).getText().equals("T")){
                DoubleLinkedList.Trap(Player, "Server");
                Caller.setText("Trampa!");

            }else if ((Labels.Lb2).getText().equals("A")){
                DoubleLinkedList.Tunel(Player, "Server");
                Caller.setText("Tunel!");
            }

        }else if(pos == 3){
            if((Labels.Lb3).getText().equals("R")){
                ChallengeInterface vent = new ChallengeInterface();
                Caller.setText("Reto!");
                Server.sendMsg("Ready");
                Server.sendMsg("Chg");

            }else if((Labels.Lb3).getText().equals("T")){
                DoubleLinkedList.Trap(Player, "Server");
                Caller.setText("Trampa!");

            }else if ((Labels.Lb3).getText().equals("A")){
                DoubleLinkedList.Tunel(Player, "Server");
                Caller.setText("Tunel!");
            }

        }else if(pos == 4){
            if((Labels.Lb4).getText().equals("R")){
                ChallengeInterface vent = new ChallengeInterface();
                Caller.setText("Reto!");
                Server.sendMsg("Ready");
                Server.sendMsg("Chg");

            }else if((Labels.Lb4).getText().equals("T")){
                DoubleLinkedList.Trap(Player, "Server");
                Caller.setText("Trampa!");

            }else if ((Labels.Lb4).getText().equals("A")){
                DoubleLinkedList.Tunel(Player, "Server");
                Caller.setText("Tunel!");
            }

        }else if(pos == 5){
            if((Labels.Lb5).getText().equals("R")){
                ChallengeInterface vent = new ChallengeInterface();
                Caller.setText("Reto!");
                Server.sendMsg("Ready");
                Server.sendMsg("Chg");

            }else if((Labels.Lb5).getText().equals("T")){
                DoubleLinkedList.Trap(Player, "Server");
                Caller.setText("Trampa!");

            }else if ((Labels.Lb5).getText().equals("A")){
                DoubleLinkedList.Tunel(Player, "Server");
                Caller.setText("Tunel!");
            }

        }else if(pos == 6){
            if((Labels.Lb6).getText().equals("R")){
                ChallengeInterface vent = new ChallengeInterface();
                Caller.setText("Reto!");
                Server.sendMsg("Ready");
                Server.sendMsg("Chg");

            }else if((Labels.Lb6).getText().equals("T")){
                DoubleLinkedList.Trap(Player, "Server");
                Caller.setText("Trampa!");

            }else if ((Labels.Lb6).getText().equals("A")){
                DoubleLinkedList.Tunel(Player, "Server");
                Caller.setText("Tunel!");
            }

        }else if(pos == 7){
            if((Labels.Lb7).getText().equals("R")){
                ChallengeInterface vent = new ChallengeInterface();
                Caller.setText("Reto!");
                Server.sendMsg("Ready");
                Server.sendMsg("Chg");

            }else if((Labels.Lb7).getText().equals("T")){
                DoubleLinkedList.Trap(Player, "Server");
                Caller.setText("Trampa!");

            }else if ((Labels.Lb7).getText().equals("A")){
                DoubleLinkedList.Tunel(Player, "Server");
                Caller.setText("Tunel!");
            }

        }else if(pos == 8){
            if((Labels.Lb8).getText().equals("R")){
                ChallengeInterface vent = new ChallengeInterface();
                Caller.setText("Reto!");
                Server.sendMsg("Ready");
                Server.sendMsg("Chg");

            }else if((Labels.Lb8).getText().equals("T")){
                DoubleLinkedList.Trap(Player, "Server");
                Caller.setText("Trampa!");

            }else if ((Labels.Lb8).getText().equals("A")){
                DoubleLinkedList.Tunel(Player, "Server");
                Caller.setText("Tunel!");
            }

        }else if(pos == 9){
            if((Labels.Lb9).getText().equals("R")){
                ChallengeInterface vent = new ChallengeInterface();
                Caller.setText("Reto!");
                Server.sendMsg("Ready");
                Server.sendMsg("Chg");

            }else if((Labels.Lb9).getText().equals("T")){
                DoubleLinkedList.Trap(Player, "Server");
                Caller.setText("Trampa!");

            }else if ((Labels.Lb9).getText().equals("A")){
                DoubleLinkedList.Tunel(Player, "Server");
                Caller.setText("Tunel!");
            }

        }else if(pos == 10){
            if((Labels.Lb10).getText().equals("R")){
                ChallengeInterface vent = new ChallengeInterface();
                Caller.setText("Reto!");
                Server.sendMsg("Ready");
                Server.sendMsg("Chg");

            }else if((Labels.Lb10).getText().equals("T")){
                DoubleLinkedList.Trap(Player, "Server");
                Caller.setText("Trampa!");

            }else if ((Labels.Lb10).getText().equals("A")){
                DoubleLinkedList.Tunel(Player, "Server");
                Caller.setText("Tunel!");
            }

        }else if(pos == 11){
            if((Labels.Lb11).getText().equals("R")){
                ChallengeInterface vent = new ChallengeInterface();
                Caller.setText("Reto!");
                Server.sendMsg("Ready");
                Server.sendMsg("Chg");

            }else if((Labels.Lb11).getText().equals("T")){
                DoubleLinkedList.Trap(Player, "Server");
                Caller.setText("Trampa!");

            }else if ((Labels.Lb11).getText().equals("A")){
                DoubleLinkedList.Tunel(Player, "Server");
                Caller.setText("Tunel!");
            }

        }else if(pos == 12){
            if((Labels.Lb12).getText().equals("R")){
                ChallengeInterface vent = new ChallengeInterface();
                Caller.setText("Reto!");
                Server.sendMsg("Ready");
                Server.sendMsg("Chg");

            }else if((Labels.Lb12).getText().equals("T")){
                DoubleLinkedList.Trap(Player, "Server");
                Caller.setText("Trampa!");

            }else if ((Labels.Lb12).getText().equals("A")){
                DoubleLinkedList.Tunel(Player, "Server");
                Caller.setText("Tunel!");
            }

        }else if(pos == 13){
            if((Labels.Lb13).getText().equals("R")){
                ChallengeInterface vent = new ChallengeInterface();
                Caller.setText("Reto!");
                Server.sendMsg("Ready");
                Server.sendMsg("Chg");

            }else if((Labels.Lb13).getText().equals("T")){
                DoubleLinkedList.Trap(Player, "Server");
                Caller.setText("Trampa!");

            }else if ((Labels.Lb13).getText().equals("A")){
                DoubleLinkedList.Tunel(Player, "Server");
                Caller.setText("Tunel!");
            }

        }else if(pos == 14){
            if((Labels.Lb14).getText().equals("R")){
                ChallengeInterface vent = new ChallengeInterface();
                Caller.setText("Reto!");
                Server.sendMsg("Ready");
                Server.sendMsg("Chg");

            }else if((Labels.Lb14).getText().equals("T")){
                DoubleLinkedList.Trap(Player, "Server");
                Caller.setText("Trampa!");

            }else if ((Labels.Lb14).getText().equals("A")){
                DoubleLinkedList.Tunel(Player, "Server");
                Caller.setText("Tunel!");
            }
        }
    }

    /**
     * Método que: - Mueve al jugador 1 casilla cuando aparece un reto.
     * @param cant cantidad de casillas que se mueve el jugador.
     */
    public static void move(int cant){
        casillas+=1;
        if (Player.getY() == 107) {
            int pos = 0;
            while(pos < cant){
                if(Player.getX() == 516 && pos != cant){
                    Player.setLocation(Player.getX()+50, Player.getY()+150);
                    pos++;
                    for(int i = pos; i < cant; i++) {
                        Player.setLocation(Player.getX()-150, Player.getY());
                        pos++;
                    }
                    pos++;
                    break;
                }
                Player.setLocation(Player.getX()+150, Player.getY());
                pos++;
            }

        } else if(Player.getY() == 257) {
            int pos = 0;
            while(pos < cant){
                if(Player.getX() == 116 && pos != cant){
                    Player.setLocation(Player.getX(), Player.getY()+150);
                    pos++;
                    for(int i = pos; i < cant; i++) {
                        Player.setLocation(Player.getX()+150, Player.getY());
                        pos++;
                    }
                    pos++;
                    break;
                }
                Player.setLocation(Player.getX()-150, Player.getY());
                pos++;
            }

        } else if (Player.getY() == 407){
            int pos = 0;
            while(pos < cant){
                if(Player.getX() == 566 && pos != cant){
                    Player.setLocation(Player.getX(), Player.getY()+150);
                    pos++;
                    for(int i = pos; i < cant; i++) {
                        Player.setLocation(Player.getX()-150, Player.getY());
                        pos++;
                    }
                    pos++;
                    break;
                }
                Player.setLocation(Player.getX()+150, Player.getY());
                pos++;
            }

        } else if (Player.getY() == 557) {
            int pos = 0;
            while(pos < cant){
                if(Player.getX() == 116 && Player.getY() == 557){
                    break;
                }
                Player.setLocation(Player.getX()-150, Player.getY());
                pos++;
            }
        }
        Server.sendMsg("No");
        Server.updateMove(Player.getX(), Player.getY());
        Server.sendMsg("No");
    }

    /**
     * Método para actualizar el movimiento realizado pro el otro jugador
     *
     * @param x Parámetro para realizar el envío de las coordenadas en x
     * @param y Parámetro para realizar el envío de las coordenadas en y
     */
    public static void updateMove(int x, int y){
        Player2.setBounds(x,y,50,50);
    }

    /**
     * Método que contiene el sistema de turnos de los jugadores
     *
     * @param turn Parámetro tipo string para enviar el cambio de turno entre jugadores
     */
    public static void serverTurn(String turn){
        if(turn.equals("go")){
            Dicebutton.setVisible(true);
        }
    }

    /**
     * Constructor que contiene los componentes y elementos de la ventana y la interfaz gráfica en sí de la misma
     *
     * @throws IOException Excepción en caso de que ocurra algún problema
     */
    private class Action implements ActionListener {

        /**
         * Método de escucha del botón: - Contiene la funcionalidad de la relación del dado y el movimiento según sea el
         *                                caso que se dé en la suma de los números del dado
         *
         * @param e Parámetro de eventos del ActionListener
         */
        public void actionPerformed(ActionEvent e){
            Dice dice = Dice.getInstance();
            int shot = dice.shot();
            dice.updateLabel(Dicenumber, shot);
            casillas = casillas + shot;

            if (Player.getY() == 107) {
                int pos = 0;
                while(pos < shot){
                    if(Player.getX() == 516 && pos != shot){
                        Player.setLocation(Player.getX(), Player.getY()+150);
                        pos++;
                        for(int i = pos; i < shot; i++) {
                            Player.setLocation(Player.getX()-150, Player.getY());
                            pos++;
                        }
                        pos++;
                        break;
                    }
                    Player.setLocation(Player.getX()+150, Player.getY());
                    pos++;
                }

            } else if(Player.getY() == 257) {
                int pos = 0;
                while(pos < shot){
                    if(Player.getX() == 66 && pos != shot){
                        Player.setLocation(Player.getX(), Player.getY()+150);
                        pos++;
                        for(int i = pos; i < shot; i++) {
                            Player.setLocation(Player.getX()+150, Player.getY());
                            pos++;
                        }
                        pos++;
                        break;
                    }
                    Player.setLocation(Player.getX()-150, Player.getY());
                    pos++;
                }

            } else if (Player.getY() == 407){
                int pos = 0;
                while(pos < shot){
                    if(Player.getX() == 516 && pos != shot){
                        Player.setLocation(Player.getX(), Player.getY()+150);
                        pos++;
                        for(int i = pos; i < shot; i++) {
                            Player.setLocation(Player.getX()-150, Player.getY());
                            pos++;
                        }
                        pos++;
                        break;
                    }
                    Player.setLocation(Player.getX()+150, Player.getY());
                    pos++;
                }

            } else if (Player.getY() == 557) {
                int pos = 0;
                while(pos < shot){
                    if(Player.getX() == 66 && Player.getY() == 557){
                        break;
                    }
                    Player.setLocation(Player.getX()-150, Player.getY());
                    pos++;
                }
            }
            Server.sendMsg("No");
            //Actualizacion de movimiento
            Server.updateMove(Player.getX(), Player.getY());

            //Cambio de turno
            Server.sendMsg("go");
            Dicebutton.setVisible(false);
            checkPos(casillas);
        }
    }
}