package LinkedList.Helper.Doubly;

public class Node {
    public int data;
    public Node prev;
    public Node next;
    public Node(){
        prev = null;
        next = null;
        data = -1;
    }
    public Node(int val){
        prev = null;
        next = null;
        data = val;
    }
}
