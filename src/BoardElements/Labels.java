package BoardElements;

import DoubleLinkedList.DoubleLinkedList;

import javax.swing.*;

public class Labels {
    public static JLabel Lb1;
    public static JLabel Lb2;
    public static JLabel Lb3;
    public static JLabel Lb4;
    public static JLabel Lb5;
    public static JLabel Lb6;
    public static JLabel Lb7;
    public static JLabel Lb8;
    public static JLabel Lb9;
    public static JLabel Lb10;
    public static JLabel Lb11;
    public static JLabel Lb12;
    public static JLabel Lb13;
    public static JLabel Lb14;

    public Labels(){
        Lb1 = new JLabel();
        Lb1.setText(DoubleLinkedList.findNode("1"));
        Lb1.setBounds(65,83,100,100);

        Lb2 = new JLabel();
        Lb2.setText(DoubleLinkedList.findNode("2"));

        Lb3 = new JLabel();
        Lb3.setText(DoubleLinkedList.findNode("3"));

        Lb4 = new JLabel();
        Lb4.setText(DoubleLinkedList.findNode("4"));

        Lb5 = new JLabel();
        Lb5.setText(DoubleLinkedList.findNode("5"));

        Lb6 = new JLabel();
        Lb6.setText(DoubleLinkedList.findNode("6"));

        Lb7 = new JLabel();
        Lb7.setText(DoubleLinkedList.findNode("7"));

        Lb8 = new JLabel();
        Lb8.setText(DoubleLinkedList.findNode("8"));

        Lb9 = new JLabel();
        Lb9.setText(DoubleLinkedList.findNode("9"));

        Lb10 = new JLabel();
        Lb10.setText(DoubleLinkedList.findNode("10"));

        Lb11 = new JLabel();
        Lb11.setText(DoubleLinkedList.findNode("11"));

        Lb12 = new JLabel();
        Lb12.setText(DoubleLinkedList.findNode("12"));

        Lb13 = new JLabel();
        Lb13.setText(DoubleLinkedList.findNode("13"));

        Lb14 = new JLabel();
        Lb14.setText(DoubleLinkedList.findNode("14"));

    }

}
