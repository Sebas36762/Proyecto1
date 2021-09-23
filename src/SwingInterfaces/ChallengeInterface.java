package SwingInterfaces;

import DoubleLinkedList.DoubleLinkedList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChallengeInterface extends JFrame {
    private JFrame Rwindow;
    private JLabel Rlabel;
    private JTextField Rtextf;
    private JButton Rbutton;


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

    public static void main(String[] args) {
        ChallengeInterface challenge = new ChallengeInterface();
    }

    public class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String ansnumb = Rtextf.getText();
            System.out.println(ansnumb);
            if (Rtextf.getText().equals("")) {
                JOptionPane.showMessageDialog(Rwindow, "Please answer the challenge");
            } else {
                if (ansnumb.equals(DoubleLinkedList.values)) {
                    System.out.println("YES");
                    Rwindow.dispose();
                } else {
                    System.out.println("NO");
                    Rwindow.dispose();
                }
            }
        }
    }
}
