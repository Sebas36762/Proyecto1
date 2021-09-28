package SwingInterfaces;
import BoardElements.Dice;
import BoardElements.Labels;
import BoardElements.StackLabels;
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
 * Clase: BoardInterfaceServer
 * @version 2.4
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 *
 * Descripción: Esta clase contiene los diferentes componentes que conforman la ventana del tablero, así mismo posee
 * la funcionalidad del movimiento de acuerdo a los dados desde el accionar del botón
 */
public class BoardInterfaceServer extends JFrame {
    private static JFrame Bwindow;
    private JLabel Userlabel;
    private JLabel Enemylabel;
    private JLabel DiceLabel;
    private JLabel Dicenumber;
    private static JButton Dicebutton;
    public static JLabel Player;
    private static JLabel Player2;
    public static int casillas;
    private JLabel CasillaType;
    private static JLabel Caller;


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
        Bwindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        JLabel Lb1 = (JLabel)StackLabels.peek();
        Bwindow.add(Lb1);
        StackLabels.pop();

        JLabel Lb2 = (JLabel)StackLabels.peek();
        Bwindow.add(Lb2);
        StackLabels.pop();

        JLabel Lb3 = (JLabel)StackLabels.peek();
        Bwindow.add(Lb3);
        StackLabels.pop();

        JLabel Lb4 = (JLabel)StackLabels.peek();
        Bwindow.add(Lb4);
        StackLabels.pop();

        JLabel Lb5 = (JLabel)StackLabels.peek();
        Bwindow.add(Lb5);
        StackLabels.pop();

        JLabel Lb6 = (JLabel)StackLabels.peek();
        Bwindow.add(Lb6);
        StackLabels.pop();

        JLabel Lb7 = (JLabel)StackLabels.peek();
        Bwindow.add(Lb7);
        StackLabels.pop();

        JLabel Lb8 = (JLabel)StackLabels.peek();
        Bwindow.add(Lb8);
        StackLabels.pop();

        JLabel Lb9 = (JLabel)StackLabels.peek();
        Bwindow.add(Lb9);
        StackLabels.pop();

        JLabel Lb10 = (JLabel)StackLabels.peek();
        Bwindow.add(Lb10);
        StackLabels.pop();

        JLabel Lb11 = (JLabel)StackLabels.peek();
        Bwindow.add(Lb11);
        StackLabels.pop();

        JLabel Lb12 = (JLabel)StackLabels.peek();
        Bwindow.add(Lb12);
        StackLabels.pop();

        JLabel Lb13 = (JLabel)StackLabels.peek();
        Bwindow.add(Lb13);
        StackLabels.pop();

        JLabel Lb14 = (JLabel)StackLabels.peek();
        Bwindow.add(Lb14);
        StackLabels.pop();

        Bwindow.add(g);
    }

    /**
     * Método que realiza el set de un nombre del jugador en la ventana
     *
     * @param name Parámetro que se le pasa al método para realizar el set
     */
    public void getUsername(String name) {
        Userlabel.setText(">You: " + name);
    }

    /**
     * Método para verificar la posición del jugador y revisar la casilla
     *
     * @param pos Parámetro que le pasa la posición (el número de casilla) para su chequeo
     */
    public static void checkPos(int pos){
        System.out.println("Check " + String.valueOf(pos));
        if(pos == 1){
            if((Labels.Lb1).getText().equals("R")){
                ChallengeInterface vent = new ChallengeInterface("Server", Player);
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
                ChallengeInterface vent = new ChallengeInterface("Server", Player);
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
                ChallengeInterface vent = new ChallengeInterface("Server", Player);
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
                ChallengeInterface vent = new ChallengeInterface("Server", Player);
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
                ChallengeInterface vent = new ChallengeInterface("Server", Player);
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
                ChallengeInterface vent = new ChallengeInterface("Server", Player);
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
                ChallengeInterface vent = new ChallengeInterface("Server", Player);
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
                ChallengeInterface vent = new ChallengeInterface("Server", Player);
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
                ChallengeInterface vent = new ChallengeInterface("Server", Player);
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
                ChallengeInterface vent = new ChallengeInterface("Server", Player);
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
                ChallengeInterface vent = new ChallengeInterface("Server", Player);
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
                ChallengeInterface vent = new ChallengeInterface("Server", Player);
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
                ChallengeInterface vent = new ChallengeInterface("Server", Player);
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
                ChallengeInterface vent = new ChallengeInterface("Server", Player);
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
     * Método que da el movimiento de la casilla de reto
     *
     * @param cant Parámetro que le da el valor de la cantidad de casillas en las que se tiene que mover
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
                    gameOver();
                    Bwindow.dispose();
                    break;
                }
                Player.setLocation(Player.getX()-150, Player.getY());
                pos++;
            }
        }if(Player.getX() == 66 && Player.getY() == 557){
            gameOver();
            Bwindow.dispose();
        }
        Server.sendMsg("Move");
        Server.updateMove(Player.getX(), Player.getY());
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
     * Método constructor de un JFrame el cual contiene un JLabel, este JFrame cumple con la funcionalidad de anunciar el
     * fin del juego cuando alguno de los jugadores consigan llegar a la casilla final, la casilla de "Finish"
     */
    public static void gameOver(){
        JFrame GameOver= new JFrame("¡Game Over!");
        GameOver.setSize(300,200);
        GameOver.setVisible(true);
        GameOver.setResizable(false);
        GameOver.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GameOver.setLayout(null);
        GameOver.setLocationRelativeTo(null);
        JLabel Gmovr = new JLabel("¡Game Over!");
        Gmovr.setFont(new Font("default", Font.BOLD, 26));
        Gmovr.setForeground(Color.black);
        Gmovr.setBounds(60,50,400,50);
        GameOver.add(Gmovr);
    }

    /**
     * Constructor que contiene los componentes y elementos de la ventana y la interfaz gráfica en sí de la misma
     *
     * @throws IOException Excepción en caso de que ocurra algún problema
     */
    private class Action implements ActionListener {

        /**
         * Método de escucha del botón, este contiene la funcionalidad de la relación del dado y el movimiento según
         * sea el caso que se dé en la suma de los números del dado
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
                        gameOver();
                        Bwindow.dispose();
                        break;
                    }
                    Player.setLocation(Player.getX()-150, Player.getY());
                    pos++;
                }

            }if(Player.getX() == 66 && Player.getY() == 557){
                gameOver();
                Bwindow.dispose();
            }
            //Actualizacion de movimiento
            Server.sendMsg("Move");
            Server.updateMove(Player.getX(), Player.getY());

            //Cambio de turno
            Server.sendMsg("Turn");
            Server.sendMsg("go");
            Dicebutton.setVisible(false);
            checkPos(casillas);
        }
    }

}