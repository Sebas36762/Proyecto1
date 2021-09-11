package SwingInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class BoardInterface extends JFrame {
    private JFrame Bwindow;
    private JLabel Userlabel;
    private JLabel Enemylabel;
    private JLabel DiceLabel;
    private JLabel Dicenumber;
    private JButton Dicebutton;


    public BoardInterface() throws IOException {

        Userlabel = new JLabel();
        Userlabel.setBounds(15, 0, 150, 50);
        Userlabel.setFont(new Font("default", Font.BOLD, 16));
        Userlabel.setForeground(Color.black);
        Userlabel.setText("> You: ...");

        Enemylabel = new JLabel();
        Enemylabel.setBounds(15, 27, 150, 50);
        Enemylabel.setFont(new Font("default", Font.BOLD, 16));
        Enemylabel.setForeground(Color.black);
        Enemylabel.setText("> User: ...");

        DiceLabel = new JLabel();
        DiceLabel.setBounds(15, 560, 250, 50);
        DiceLabel.setFont(new Font("default", Font.BOLD, 16));
        DiceLabel.setForeground(Color.black);
        DiceLabel.setText("> The number on the dice is: ");

        Dicenumber = new JLabel();
        Dicenumber.setBounds(245, 560, 100, 50);
        Dicenumber.setFont(new Font("default", Font.BOLD, 16));
        Dicenumber.setForeground(Color.black);

        Dicebutton = new JButton();
        Dicebutton.setBounds(587, 574, 80, 25);
        Dicebutton.setText("Dice");
        Dicebutton.addActionListener(new BoardInterface.Action());

        Bwindow = new JFrame();
        Bwindow.setTitle("Waiting Room");
        Bwindow.setVisible(true);
        Bwindow.setLayout(null);
        Bwindow.setSize(700, 650);
        Bwindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Bwindow.setResizable(false);
        Bwindow.setLocationRelativeTo(null);
        Bwindow.add(Userlabel);
        Bwindow.add(Enemylabel);
        Bwindow.add(DiceLabel);
        Bwindow.add(Dicenumber);
        Bwindow.add(Dicebutton);

    }

    public static void main(String[] args) throws IOException{
        BoardInterface BrdW = new BoardInterface();
    }

    private class Action implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Dice dice = new Dice(4);
            dice.updateLabel(Dicenumber, dice.shot());
        }
    }

}
