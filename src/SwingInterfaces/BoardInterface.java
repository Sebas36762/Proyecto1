package SwingInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *
 */
public class BoardInterface extends JFrame {
    private JFrame Bwindow;
    private JLabel Userlabel;
    private JLabel Enemylabel;
    private JLabel DiceLabel;
    private JLabel Dicenumber;
    private JButton Dicebutton;
    private JLabel Player;
    private JLabel Player2;

    /**
     *
     * @throws IOException
     */
    public BoardInterface() throws IOException {

        Userlabel = new JLabel();
        Userlabel.setBounds(25, 0, 150, 50);
        Userlabel.setFont(new Font("default", Font.BOLD, 16));
        Userlabel.setForeground(Color.black);
        Userlabel.setText("> You: ...");

        Enemylabel = new JLabel();
        Enemylabel.setBounds(25, 27, 150, 50);
        Enemylabel.setFont(new Font("default", Font.BOLD, 16));
        Enemylabel.setForeground(Color.black);
        Enemylabel.setText("> User: ...");

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
        Dicebutton.addActionListener(new BoardInterface.Action());

        ImageIcon avatar = new ImageIcon("avatar.png");
        Player = new JLabel(avatar);
        Player.setBounds(66,107,50,50);

        ImageIcon avatar2 = new ImageIcon("aavatar.png");
        Player2 = new JLabel(avatar2);
        Player2.setBounds(115,107,50,50);

        Graphic g = new Graphic();

        Bwindow = new JFrame();
        Bwindow.setTitle("Board");
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

        Bwindow.add(g);

    }

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        BoardInterface BrdW = new BoardInterface();
    }

    /**
     *
     */
    private class Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Dice dice = new Dice(4);
            int shot = dice.shot();
            dice.updateLabel(Dicenumber, shot);

            if (Player.getY() == 107) {
                //Player.setLocation(Player.getX(), Player.getY() +150);
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
            }

        }
    }
}


