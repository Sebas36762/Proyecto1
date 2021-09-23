package DoubleLinkedList;
import java.util.*;

public class DoubleLinkedList {

    public static String values;
    private static DoubleNode head;
    private DoubleNode tail;
    private int trampa = 0, tunel = 0, reto = 0;

    /**
     * Constructs a new DoubleLinkedList object with head and tail as null.
     */
    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Returns true if the list is empty false otherwise
     * @return true if the list empty false otherwise
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * Método que: - Crea las casillas de manera aleatoria.
     */
    public void Casillas(){
        int i = 1;
        while(i <=14){
            int probability = (int)(Math.random()*3)+1;

            if(probability == 1 && this.trampa <4){
                addCasilla('A', String.valueOf(i));
                this.trampa++;
                i++;

            }else if(probability == 2 && this.reto <7){
                addCasilla('R', String.valueOf(i));
                this.reto++;
                i++;

            }else if (probability == 3 && this.tunel <3){
                addCasilla('T', String.valueOf(i));
                this.tunel++;
                i++;

            }

        }

    }
    /**
     * Add a character BNode containing the character c to the front of the linked list. No search is required.
     * @param Id a single character
     */
    public void addCasilla(char Id, String ID){
        DoubleNode casilla = new DoubleNode(null, Id, ID, head);
        if(isEmpty()){
            head = tail = casilla;
        }else{
            head.setPrev(casilla);
            head = casilla;
        }
    }

    /**
     * Counts the number of BNodes in the list. We are not maintaining a counter so a search is required.
     * @return the number of BNodes in the doubly linked list between head and tail inclusive
     */
    public int countBNodes(){
        DoubleNode cn = head;
        int count = 0;
        while(cn != null){
            count++;
            cn = cn.getNext();
        }
        return count;
    }

    /**
     * Returns the list as a String. The class DoubleBNode has a toString that will be called from this toString. The String returned must be presented clearly. Null pointers must be represented differently than non-null pointers.
     * @see java.lang.Object#toString()
     * @return a String containing the characters in the list
     */
    public String[] showList(){
        DoubleNode cn = head;
        String str = "";
        while(cn != null){
            str += cn.getC() + ",";
            System.out.print(cn.getC());
            cn = cn.getNext();
        }
        String[] list = str.split(",");

        return list;
    }

    public static String findNode(String Id){
        DoubleNode objective = head;
        while (objective != null){
            if (objective.getID().equals(Id)){
                return objective.getC();
            }else{
                objective = objective.getNext();
            }
        }
        return null;
    }

    public static String Mathchallenge() {

        Random r = new Random();

        int A = (int) (Math.random()*50+1);
        int B = (int) (Math.random()*50+1);
        char operator ='?';
        int value = 0;

        switch (r.nextInt(4)){
            case 0: operator = '+';
                value = A+B;
                break;
            case 1: operator = '-';
                value = A-B;
                break;
            case 2: operator = '*';
                value = A*B;
                break;
            case 3: operator = '/';
                value = A/B;
                break;
            default: operator = '?';
        }

        System.out.print(A);
        System.out.print(" ");
        System.out.print(operator);
        System.out.print(" ");
        System.out.print(B);


        values = (String.valueOf(value));
        String format = (String.valueOf(A)+" "+String.valueOf(operator)+" "+String.valueOf(B));
        return format;
    }

    public static void main(String[] args) {
        DoubleLinkedList x = new DoubleLinkedList();
        x.Casillas();

        System.out.println(Arrays.toString(x.showList()));
        System.out.println(x.findNode("4"));
    }
}








