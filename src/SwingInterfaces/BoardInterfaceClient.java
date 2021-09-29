package SwingInterfaces;
import BoardElements.Dice;
import BoardElements.Labels;
import DoubleLinkedList.DoubleLinkedList;
import Socket.Client;
import Socket.ClientThread;
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
 * Clase: BoardInterfaceClient
 * @version 2.4
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 *
 * Descripción: Esta clase contiene los diferentes componentes que conforman la ventana del tablero, así mismo posee
 * la funcionalidad del movimiento de acuerdo a los dados desde el accionar del botón
 */
public class BoardInterfaceClient extends JFrame {
    private static JFrame Bwindow;
    private JLabel Userlabel;
    private JLabel Enemylabel;
    private JLabel DiceLabel;
    private JLabel Dicenumber;
    private static JButton Dicebutton;
    private static JLabel Player;
    private static JLabel Player2;
    public static int casillas;
    private JLabel CasillaType;
    private static JLabel Caller;

    /**
     * Constructor que contiene los componentes y elementos de la ventana y la interfaz gráfica en sí de la misma
     *
     * @throws IOException Excepción en caso de que ocurra algún problema
     */
    public BoardInterfaceClient() throws IOException {

        //Creación y agregación de elemento a la ventana
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
        while (run) {
            String Name = ClientThread.Name;
            if (Name != null) {
                Enemylabel.setText(">User: " + ClientThread.Name);
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

        Dicebutton = new JButton();
        Dicebutton.setBounds(575, 638, 80, 25);
        Dicebutton.setText("Dice");
        Dicebutton.addActionListener(new BoardInterfaceClient.Action());
        Dicebutton.setVisible(false);

        CasillaType = new JLabel();
        CasillaType.setText("R = Reto | T = Trampa | A = Tunel");
        CasillaType.setBounds(200, 0, 400, 50);
        CasillaType.setFont(new Font("default", Font.BOLD, 20));

        Caller = new JLabel();
        Caller.setBounds(310, 35, 100, 50);
        Caller.setFont(new Font("default", Font.BOLD, 16));

        ImageIcon avatar = new ImageIcon("avatar.png");
        Player = new JLabel(avatar);
        Player.setBounds(66, 107, 50, 50);

        ImageIcon avatar2 = new ImageIcon("aavatar.png");
        Player2 = new JLabel(avatar2);
        Player2.setBounds(115, 107, 50, 50);

        Graphic g = new Graphic();

        Bwindow = new JFrame("Client");
        Bwindow.setVisible(true);

        Bwindow.setSize(700, 720);
        Bwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Bwindow.setResizable(false);

        Bwindow.add(Userlabel);
        Bwindow.add(Enemylabel);
        Bwindow.add(DiceLabel);
        Bwindow.add(Dicenumber);
        Bwindow.add(Dicebutton);
        Bwindow.add(Player);
        Bwindow.add(Player2);
        Bwindow.add(CasillaType);
        Bwindow.add(Caller);

        Bwindow.add(Labels.Lb1C);
        Bwindow.add(Labels.Lb2C);
        Bwindow.add(Labels.Lb3C);
        Bwindow.add(Labels.Lb4C);
        Bwindow.add(Labels.Lb5C);
        Bwindow.add(Labels.Lb6C);
        Bwindow.add(Labels.Lb7C);
        Bwindow.add(Labels.Lb8C);
        Bwindow.add(Labels.Lb9C);
        Bwindow.add(Labels.Lb10C);
        Bwindow.add(Labels.Lb11C);
        Bwindow.add(Labels.Lb12C);
        Bwindow.add(Labels.Lb13C);
        Bwindow.add(Labels.Lb14C);

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
     * Método que habilita el botón del dado para el cliente cuándo es su turno
     *
     * @param turn Parámetro que determina cuando es el turno del jugador para habilitar el botón.
     */
    public static void clientTurn(String turn) {
        if (turn.equals("go")) {
            Dicebutton.setVisible(true);
        }
    }

    /**
     * Método que actualiza el avatar del jugador 2 en el tablero cuando se realiza un movimiento
     *
     * @param x Coordenada en X del jugador 2
     * @param y Coordenada en Y del jugador 2
     */
    public static void updateMove(int x, int y) {
        Player2.setBounds(x, y, 50, 50);
    }

    /**
     * Método para verificar la posición del jugador y revisar la casilla
     *
     * @param pos Parámetro que le pasa la posición (el número de casilla) para su chequeo
     */
    public static void checkPos(int pos) {
        System.out.println("Check " + String.valueOf(pos));

        //Verifica que contiene cada casilla en el tablero
        if (pos == 1) {
            if ((Labels.Lb1C).getText().equals("R")) {
                ChallengeInterface vent = new ChallengeInterface("Client", Player);
                Caller.setText("Reto!");
                Client.sendMsg("Ready");
                Client.sendMsg("Chg");

            } else if ((Labels.Lb1C).getText().equals("T")) {
                DoubleLinkedList.Trap(Player, "Client");
                Caller.setText("Trampa!");

            } else if ((Labels.Lb1C).getText().equals("A")) {
                DoubleLinkedList.Tunel(Player, "Client");
                Caller.setText("Tunel!");
            }

        } else if (pos == 2) {
            if ((Labels.Lb2C).getText().equals("R")) {
                ChallengeInterface vent = new ChallengeInterface("Client", Player);
                Caller.setText("Reto!");
                Client.sendMsg("Ready");
                Client.sendMsg("Chg");

            } else if ((Labels.Lb2C).getText().equals("T")) {
                DoubleLinkedList.Trap(Player, "Client");
                Caller.setText("Trampa!");

            } else if ((Labels.Lb2C).getText().equals("A")) {
                DoubleLinkedList.Tunel(Player, "Client");
                Caller.setText("Tunel!");
            }

        } else if (pos == 3) {
            if ((Labels.Lb3C).getText().equals("R")) {
                ChallengeInterface vent = new ChallengeInterface("Client", Player);
                Caller.setText("Reto!");
                Client.sendMsg("Ready");
                Client.sendMsg("Chg");

            } else if ((Labels.Lb3C).getText().equals("T")) {
                DoubleLinkedList.Trap(Player, "Client");
                Caller.setText("Trampa!");

            } else if ((Labels.Lb3C).getText().equals("A")) {
                DoubleLinkedList.Tunel(Player, "Client");
                Caller.setText("Tunel!");
            }

        } else if (pos == 4) {
            if ((Labels.Lb4C).getText().equals("R")) {
                ChallengeInterface vent = new ChallengeInterface("Client", Player);
                Caller.setText("Reto!");
                Client.sendMsg("Ready");
                Client.sendMsg("Chg");

            } else if ((Labels.Lb4C).getText().equals("T")) {
                DoubleLinkedList.Trap(Player, "Client");
                Caller.setText("Trampa!");

            } else if ((Labels.Lb4C).getText().equals("A")) {
                DoubleLinkedList.Tunel(Player, "Client");
                Caller.setText("Tunel!");
            }

        } else if (pos == 5) {
            if ((Labels.Lb5C).getText().equals("R")) {
                ChallengeInterface vent = new ChallengeInterface("Client", Player);
                Caller.setText("Reto!");
                Client.sendMsg("Ready");
                Client.sendMsg("Chg");

            } else if ((Labels.Lb5C).getText().equals("T")) {
                DoubleLinkedList.Trap(Player, "Client");
                Caller.setText("Trampa!");

            } else if ((Labels.Lb5C).getText().equals("A")) {
                DoubleLinkedList.Tunel(Player, "Client");
                Caller.setText("Tunel!");
            }

        } else if (pos == 6) {
            if ((Labels.Lb6C).getText().equals("R")) {
                ChallengeInterface vent = new ChallengeInterface("Client", Player);
                Caller.setText("Reto!");
                Client.sendMsg("Ready");
                Client.sendMsg("Chg");

            } else if ((Labels.Lb6C).getText().equals("T")) {
                DoubleLinkedList.Trap(Player, "Client");
                Caller.setText("Trampa!");

            } else if ((Labels.Lb6C).getText().equals("A")) {
                DoubleLinkedList.Tunel(Player, "Client");
                Caller.setText("Tunel!");
            }

        } else if (pos == 7) {
            if ((Labels.Lb7C).getText().equals("R")) {
                ChallengeInterface vent = new ChallengeInterface("Client", Player);
                Caller.setText("Reto!");
                Client.sendMsg("Ready");
                Client.sendMsg("Chg");

            } else if ((Labels.Lb7C).getText().equals("T")) {
                DoubleLinkedList.Trap(Player, "Client");
                Caller.setText("Trampa!");

            } else if ((Labels.Lb7C).getText().equals("A")) {
                DoubleLinkedList.Tunel(Player, "Client");
                Caller.setText("Tunel!");
            }

        } else if (pos == 8) {
            if ((Labels.Lb8C).getText().equals("R")) {
                ChallengeInterface vent = new ChallengeInterface("Client", Player);
                Caller.setText("Reto!");
                Client.sendMsg("Ready");
                Client.sendMsg("Chg");

            } else if ((Labels.Lb8C).getText().equals("T")) {
                DoubleLinkedList.Trap(Player, "Client");
                Caller.setText("Trampa!");

            } else if ((Labels.Lb8C).getText().equals("A")) {
                DoubleLinkedList.Tunel(Player, "Client");
                Caller.setText("Tunel!");
            }

        } else if (pos == 9) {
            if ((Labels.Lb9C).getText().equals("R")) {
                ChallengeInterface vent = new ChallengeInterface("Client", Player);
                Caller.setText("Reto!");
                Client.sendMsg("Ready");
                Client.sendMsg("Chg");

            } else if ((Labels.Lb9C).getText().equals("T")) {
                DoubleLinkedList.Trap(Player, "Client");
                Caller.setText("Trampa!");

            } else if ((Labels.Lb9C).getText().equals("A")) {
                DoubleLinkedList.Tunel(Player, "Client");
                Caller.setText("Tunel!");
            }

        } else if (pos == 10) {
            if ((Labels.Lb10C).getText().equals("R")) {
                ChallengeInterface vent = new ChallengeInterface("Client", Player);
                Caller.setText("Reto!");
                Client.sendMsg("Ready");
                Client.sendMsg("Chg");

            } else if ((Labels.Lb10C).getText().equals("T")) {
                DoubleLinkedList.Trap(Player, "Client");
                Caller.setText("Trampa!");

            } else if ((Labels.Lb10C).getText().equals("A")) {
                DoubleLinkedList.Tunel(Player, "Client");
                Caller.setText("Tunel!");
            }

        } else if (pos == 11) {
            if ((Labels.Lb11C).getText().equals("R")) {
                ChallengeInterface vent = new ChallengeInterface("Client", Player);
                Caller.setText("Reto!");
                Client.sendMsg("Ready");
                Client.sendMsg("Chg");

            } else if ((Labels.Lb11C).getText().equals("T")) {
                DoubleLinkedList.Trap(Player, "Client");
                Caller.setText("Trampa!");

            } else if ((Labels.Lb11C).getText().equals("A")) {
                DoubleLinkedList.Tunel(Player, "Client");
                Caller.setText("Tunel!");
            }

        } else if (pos == 12) {
            if ((Labels.Lb12C).getText().equals("R")) {
                ChallengeInterface vent = new ChallengeInterface("Client", Player);
                Caller.setText("Reto!");
                Client.sendMsg("Ready");
                Client.sendMsg("Chg");

            } else if ((Labels.Lb12C).getText().equals("T")) {
                DoubleLinkedList.Trap(Player, "Client");
                Caller.setText("Trampa!");

            } else if ((Labels.Lb12C).getText().equals("A")) {
                DoubleLinkedList.Tunel(Player, "Client");
                Caller.setText("Tunel!");
            }

        } else if (pos == 13) {
            if ((Labels.Lb13C).getText().equals("R")) {
                ChallengeInterface vent = new ChallengeInterface("Client", Player);
                Caller.setText("Reto!");
                Client.sendMsg("Ready");
                Client.sendMsg("Chg");

            } else if ((Labels.Lb13C).getText().equals("T")) {
                DoubleLinkedList.Trap(Player, "Client");
                Caller.setText("Trampa!");

            } else if ((Labels.Lb13C).getText().equals("A")) {
                DoubleLinkedList.Tunel(Player, "Client");
                Caller.setText("Tunel!");
            }

        } else if (pos == 14) {
            if ((Labels.Lb14C).getText().equals("R")) {
                ChallengeInterface vent = new ChallengeInterface("Client", Player);
                Caller.setText("Reto!");
                Client.sendMsg("Ready");
                Client.sendMsg("Chg");

            } else if ((Labels.Lb14C).getText().equals("T")) {
                DoubleLinkedList.Trap(Player, "Client");
                Caller.setText("Trampa!");

            } else if ((Labels.Lb14C).getText().equals("A")) {
                DoubleLinkedList.Tunel(Player, "Client");
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
        casillas += 1;
        if (Player.getY() == 107) { //Primera fila del tablero
            int pos = 0;
            while (pos < cant) {
                if (Player.getX() == 516 && pos != cant) {
                    Player.setLocation(Player.getX() + 50, Player.getY() + 150); //Mueve hacia la segunda fila el jugador
                    pos++;
                    for (int i = pos; i < cant; i++) {
                        Player.setLocation(Player.getX() - 150, Player.getY()); //Movimiento hacia la izquierda en la segunda fila
                        pos++;
                    }
                    pos++;
                    break;
                }
                Player.setLocation(Player.getX() + 150, Player.getY()); //Movimiento hacia la derecha en primera fila
                pos++;
            }

        } else if (Player.getY() == 257) { //Segunda fila del tablero
            int pos = 0;
            while (pos < cant) {
                if (Player.getX() == 116 && pos != cant) {
                    Player.setLocation(Player.getX(), Player.getY() + 150); //Movimiento hacia la tercera fila
                    pos++;
                    for (int i = pos; i < cant; i++) {
                        Player.setLocation(Player.getX() + 150, Player.getY()); //Movimeinto hacia la derecha en la tercera fila
                        pos++;
                    }
                    pos++;
                    break;
                }
                Player.setLocation(Player.getX() - 150, Player.getY()); //Movimiento hacia la izquierda en segunda fila
                pos++;
            }

        } else if (Player.getY() == 407) { //Tercera fila del tablero
            int pos = 0;
            while (pos < cant) {
                if (Player.getX() == 566 && pos != cant) {
                    Player.setLocation(Player.getX(), Player.getY() + 150); //Movimiento hacia la cuarta fila
                    pos++;
                    for (int i = pos; i < cant; i++) {
                        Player.setLocation(Player.getX() - 150, Player.getY()); //Movimiento hacia la izquierda en la cuarta fila
                        pos++;
                    }
                    pos++;
                    break;
                }
                Player.setLocation(Player.getX() + 150, Player.getY()); //Movimiento hacia la derecha en la tercera fila
                pos++;
            }

        } else if (Player.getY() == 557) { //Cuarta fila del tablero
            int pos = 0;
            while (pos < cant) {
                if (Player.getX() == 116 && Player.getY() == 557) { //Jugador llegó a la última casilla del tablero
                    BoardInterfaceServer.gameOver();
                    Bwindow.dispose();
                    break;
                }
                Player.setLocation(Player.getX() - 150, Player.getY()); //Movimiento hacia la izquierda en cuarta fila
                pos++;
            }
        }if(Player.getX() == 116 && Player.getY() == 557){ //Jugador llegó a la última casilla del tablero
            BoardInterfaceServer.gameOver();
            Bwindow.dispose();
        }
        //Actualización del movimiento
        Client.sendMsg("Move");
        Client.updateMove(Player.getX(), Player.getY());
    }

    /**
     * Instituto Tecnológico de Costa Rica
     * Área de Ingeniería en Computadores
     *
     * Sub-clase: Action (Recreación de action Listener)
     * @version 1.0
     * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
     *
     * Descripción: Esta sub-clase contiene el método que permite la funcionalidad del botón en relación con el movimiento
     */
    private class Action implements ActionListener {

        /**
         * Método de escucha del botón que contiene la funcionalidad de la relación del dado y el movimiento según sea el
         * caso que se dé en la suma de los números del dado
         *
         * @param e Parámetro de eventos del ActionListener
         */
        public void actionPerformed(ActionEvent e) {
            Dice dice = Dice.getInstance();
            int shot = dice.shot();
            dice.updateLabel(Dicenumber, shot);
            casillas += shot;
            if (Player.getY() == 107) {
                int pos = 0;
                while (pos < shot) {
                    if (Player.getX() == 516 && pos != shot) { //Primera fila del tablero
                        Player.setLocation(Player.getX() + 50, Player.getY() + 150); //Movimiento a la segunda fila del tablero
                        pos++;
                        for (int i = pos; i < shot; i++) {
                            Player.setLocation(Player.getX() - 150, Player.getY()); //Movimiento hacia la izquierda en la segunda fila
                            pos++;
                        }
                        pos++;
                        break;
                    }
                    Player.setLocation(Player.getX() + 150, Player.getY()); //Movimiento hacia la derecha en la primera fila
                    pos++;
                }
            } else if (Player.getY() == 257) { //Segunda fila del tablero
                int pos = 0;
                while (pos < shot) {
                    if (Player.getX() == 116 && pos != shot) {
                        Player.setLocation(Player.getX(), Player.getY() + 150); //Movimiento a la tercera fila del tablero
                        pos++;
                        for (int i = pos; i < shot; i++) {
                            Player.setLocation(Player.getX() + 150, Player.getY()); //Movimiento hacia la derecha en la tercera fila
                            pos++;
                        }
                        pos++;
                        break;
                    }
                    Player.setLocation(Player.getX() - 150, Player.getY()); //Movimiento hacia la izquierda en la segunda fila
                    pos++;
                }
            } else if (Player.getY() == 407) { //Tercera fila del tablero
                int pos = 0;
                while (pos < shot) {
                    if (Player.getX() == 566 && pos != shot) {
                        Player.setLocation(Player.getX(), Player.getY() + 150); //Movimiento a la cuarta fila del tablero
                        pos++;
                        for (int i = pos; i < shot; i++) {
                            Player.setLocation(Player.getX() - 150, Player.getY()); //Movimiento hacia la izquierda en la cuarta fila
                            pos++;
                        }
                        pos++;
                        break;
                    }
                    Player.setLocation(Player.getX() + 150, Player.getY()); //Movimiento hacia la tercera en la primera fila
                    pos++;
                }
            } else if (Player.getY() == 557) { //Cuarta fila del tablero
                int pos = 0;
                while (pos < shot) {
                    if (Player.getX() == 116 && Player.getY() == 557) { //Jugador llegó a la última casilla del tablero
                        BoardInterfaceServer.gameOver();
                        Bwindow.dispose();
                        break;
                    }
                    Player.setLocation(Player.getX() - 150, Player.getY()); //Movimiento hacia la izquierda en la cuarta fila
                    pos++;
                }

            }if(Player.getX() == 66 && Player.getY() == 557){ //Jugador llegó a la última casilla del tablero
                BoardInterfaceServer.gameOver();
                Bwindow.dispose();
            }
            //Actualización de movimiento
            Client.sendMsg("Move");
            Client.updateMove(Player.getX(), Player.getY());
            //Cambio de turno
            Client.sendMsg("Turn");
            Client.sendMsg("go");
            Dicebutton.setVisible(false);
            checkPos(casillas);
        }
    }
}




