package DoubleLinkedList;

public class DoubleNode {

    private DoubleNode prev;
    private DoubleNode next;
    private char Type;
    private String ID;

    /**
     * Constructor with three arguments
     * @param p is a pointer to a previous BNode.
     * @param Id is a character for this BNode.
     * @param n is a pointer to a next BNode.
     */
    public DoubleNode(DoubleNode p, char Id, String Id2, DoubleNode n){
        prev = p;
        next = n;
        Type = Id;
        ID = Id2;
    }

    /**
     * @return c a character for this BNode.
     */
    public String getID(){
        return ID;
    }

    public String getC(){
        return String.valueOf(Type);
    }

    /**
     * @return a pointer to the next BNode or null if none exists
     */
    public DoubleNode getNext(){
        return next;
    }

    /**
     * @return a pointer to the previous BNode or null if none exists
     */
    public DoubleNode getPrev(){
        return prev;
    }

    /**
     * @param ch is assigned to this BNode
     */
    public void setC(char ch){
        Type = ch;
    }

    /**
     * @param n
     */
    public void setNext(DoubleNode n){
        next = n;
    }

    /**
     * @param p
     */
    public void setPrev(DoubleNode p){
        prev = p;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString(){
        return Character.toString(Type);
    }
}