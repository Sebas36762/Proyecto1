package BoardElements;
import DoubleLinkedList.DoubleLinkedList;
import javax.swing.*;
import java.awt.*;

/**
 * Instituto Tecnológico de Costa Rica
 * Área de Ingeniería en Computadores
 *
 * Lenguaje: Java
 * Clase: Labels
 * @version 1.0
 * @author Byron Mata, Gustavo Alvarado & Sebastián Chaves
 *
 * Descripción: Esta clase contiene los labels utilizados en el tablero, labels a los que se les asigna un valor del tipo
 * de casilla, para así ser detectados
 */
public class Labels {
    //Stack Labels
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

    //Client labels
    public static JLabel Lb1C;
    public static JLabel Lb2C;
    public static JLabel Lb3C;
    public static JLabel Lb4C;
    public static JLabel Lb5C;
    public static JLabel Lb6C;
    public static JLabel Lb7C;
    public static JLabel Lb8C;
    public static JLabel Lb9C;
    public static JLabel Lb10C;
    public static JLabel Lb11C;
    public static JLabel Lb12C;
    public static JLabel Lb13C;
    public static JLabel Lb14C;

    /**
     * Contructor de los diferentes JLabels que se utilizan para la asignación del tipo de casilla del tablero,
     * tomando la posición que el nodo de la lista le asigne
     */
    public static void Labels(){
        Lb1 = new JLabel();
        Lb1.setText(DoubleLinkedList.findNode("1"));
        Lb1.setBounds(260,83,100,100);
        Lb1.setFont(new Font("default", Font.BOLD, 20));

        Lb2 = new JLabel();
        Lb2.setText(DoubleLinkedList.findNode("2"));
        Lb2.setBounds(410,83,100,100);
        Lb2.setFont(new Font("default", Font.BOLD, 20));

        Lb3 = new JLabel();
        Lb3.setText(DoubleLinkedList.findNode("3"));
        Lb3.setBounds(560,83,100,100);
        Lb3.setFont(new Font("default", Font.BOLD, 20));

        Lb4 = new JLabel();
        Lb4.setText(DoubleLinkedList.findNode("4"));
        Lb4.setBounds(560,228,100,100);
        Lb4.setFont(new Font("default", Font.BOLD, 20));

        Lb5 = new JLabel();
        Lb5.setText(DoubleLinkedList.findNode("5"));
        Lb5.setBounds(410,228,100,100);
        Lb5.setFont(new Font("default", Font.BOLD, 20));

        Lb6 = new JLabel();
        Lb6.setText(DoubleLinkedList.findNode("6"));
        Lb6.setBounds(260,228,100,100);
        Lb6.setFont(new Font("default", Font.BOLD, 20));

        Lb7 = new JLabel();
        Lb7.setText(DoubleLinkedList.findNode("7"));
        Lb7.setBounds(110,228,100,100);
        Lb7.setFont(new Font("default", Font.BOLD, 20));

        Lb8 = new JLabel();
        Lb8.setText(DoubleLinkedList.findNode("8"));
        Lb8.setBounds(110,373,100,100);
        Lb8.setFont(new Font("default", Font.BOLD, 20));

        Lb9 = new JLabel();
        Lb9.setText(DoubleLinkedList.findNode("9"));
        Lb9.setBounds(260,373,100,100);
        Lb9.setFont(new Font("default", Font.BOLD, 20));

        Lb10 = new JLabel();
        Lb10.setText(DoubleLinkedList.findNode("10"));
        Lb10.setBounds(410,373,100,100);
        Lb10.setFont(new Font("default", Font.BOLD, 20));

        Lb11 = new JLabel();
        Lb11.setText(DoubleLinkedList.findNode("11"));
        Lb11.setBounds(560,373,100,100);
        Lb11.setFont(new Font("default", Font.BOLD, 20));

        Lb12 = new JLabel();
        Lb12.setText(DoubleLinkedList.findNode("12"));
        Lb12.setBounds(560,518,100,100);
        Lb12.setFont(new Font("default", Font.BOLD, 20));

        Lb13 = new JLabel();
        Lb13.setText(DoubleLinkedList.findNode("13"));
        Lb13.setBounds(410,518,100,100);
        Lb13.setFont(new Font("default", Font.BOLD, 20));

        Lb14 = new JLabel();
        Lb14.setText(DoubleLinkedList.findNode("14"));
        Lb14.setBounds(260,518,100,100);
        Lb14.setFont(new Font("default", Font.BOLD, 20));

        //Se guardan los Labels en al pila creada
        StackLabels stack = new StackLabels();
        StackLabels.push(Lb14);
        StackLabels.push(Lb13);
        StackLabels.push(Lb12);
        StackLabels.push(Lb11);
        StackLabels.push(Lb10);
        StackLabels.push(Lb9);
        StackLabels.push(Lb8);
        StackLabels.push(Lb7);
        StackLabels.push(Lb6);
        StackLabels.push(Lb5);
        StackLabels.push(Lb4);
        StackLabels.push(Lb3);
        StackLabels.push(Lb2);
        StackLabels.push(Lb1);

    }

    /**
     * Contructor de los diferentes JLabels que se utilizan para la asignación del tipo de casilla del tablero,
     * tomando la posición que el nodo de la lista le asigne
     *
     * @param list Parámetro para acceder a la lista
     */
    public static void LabelsClient(String[] list){
        Lb1C = new JLabel();
        Lb1C.setText(list[13]);
        Lb1C.setBounds(260,83,100,100);
        Lb1C.setFont(new Font("default", Font.BOLD, 20));

        Lb2C = new JLabel();
        Lb2C.setText(list[12]);
        Lb2C.setBounds(410,83,100,100);
        Lb2C.setFont(new Font("default", Font.BOLD, 20));

        Lb3C = new JLabel();
        Lb3C.setText(list[11]);
        Lb3C.setBounds(560,83,100,100);
        Lb3C.setFont(new Font("default", Font.BOLD, 20));

        Lb4C = new JLabel();
        Lb4C.setText(list[10]);
        Lb4C.setBounds(560,228,100,100);
        Lb4C.setFont(new Font("default", Font.BOLD, 20));

        Lb5C = new JLabel();
        Lb5C.setText(list[9]);
        Lb5C.setBounds(410,228,100,100);
        Lb5C.setFont(new Font("default", Font.BOLD, 20));

        Lb6C = new JLabel();
        Lb6C.setText(list[8]);
        Lb6C.setBounds(260,228,100,100);
        Lb6C.setFont(new Font("default", Font.BOLD, 20));

        Lb7C = new JLabel();
        Lb7C.setText(list[7]);
        Lb7C.setBounds(110,228,100,100);
        Lb7C.setFont(new Font("default", Font.BOLD, 20));

        Lb8C = new JLabel();
        Lb8C.setText(list[6]);
        Lb8C.setBounds(110,373,100,100);
        Lb8C.setFont(new Font("default", Font.BOLD, 20));

        Lb9C = new JLabel();
        Lb9C.setText(list[5]);
        Lb9C.setBounds(260,373,100,100);
        Lb9C.setFont(new Font("default", Font.BOLD, 20));

        Lb10C = new JLabel();
        Lb10C.setText(list[4]);
        Lb10C.setBounds(410,373,100,100);
        Lb10C.setFont(new Font("default", Font.BOLD, 20));

        Lb11C = new JLabel();
        Lb11C.setText(list[3]);
        Lb11C.setBounds(560,373,100,100);
        Lb11C.setFont(new Font("default", Font.BOLD, 20));

        Lb12C = new JLabel();
        Lb12C.setText(list[2]);
        Lb12C.setBounds(560,518,100,100);
        Lb12C.setFont(new Font("default", Font.BOLD, 20));

        Lb13C = new JLabel();
        Lb13C.setText(list[1]);
        Lb13C.setBounds(410,518,100,100);
        Lb13C.setFont(new Font("default", Font.BOLD, 20));

        Lb14C = new JLabel();
        Lb14C.setText(list[0]);
        Lb14C.setBounds(260,518,100,100);
        Lb14C.setFont(new Font("default", Font.BOLD, 20));

    }

}
