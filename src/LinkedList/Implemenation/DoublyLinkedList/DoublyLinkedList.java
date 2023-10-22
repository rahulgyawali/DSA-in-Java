package LinkedList.Implemenation.DoublyLinkedList;
import LinkedList.Helper.Doubly.Node;

public class DoublyLinkedList {
    Node root;
    /*Adds at the back of the list*/
    public  Node addInBack(int val){
        Node temp = new Node(val);
        if(root == null){
            root =temp;
            return root;
        }
        Node current = root;
        while(current.next !=null){
            current = current.next;
        }
        temp.prev = current;
        current.next= temp;
        print(">> addInBack <<");
        return root;
    }
    /*Adds at the front of the list*/
    public Node addInFront(int val){
        Node temp = new Node(val);
        if(root == null){
            root =temp;
            return root;
        }
        temp.next = root;
        root.prev = temp;
        root = temp;
        print(">> addInFront <<");
        return root;
    }
    /*Removes from Back of the list*/
    public Node removeFromBack(){
        if(root != null){
            Node current = root;
            Node prev= null;
            while (current.next != null){
                prev = current;
                current = current.next;
            }
            if(prev ==null){
                return null;
            }
            prev.next = null;
            current.prev = null;
        }
        print(">> removeFromBack <<");
        return root;
    }
    /*Removes from Front of the list*/
    public Node removeFromFront(){
        if(root != null){
            if(root.next == null){
                return null;
            }
            Node next=root.next;
            root.next =null;
            next.prev = null;
            root = next;
        }
        print(">> removeFromFront <<");
        return root;
    }
    /*Print the current state of Node*/
    public void print(String operation){
        Node current=root;
        System.out.println(operation);
        while(current != null){
            System.out.print(current.data+" -> ");
            current = current.next;
        }
        System.out.print("\b\b\b\n");
    }
    public  static  void main(String args[]){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.root = new Node(1);
        doublyLinkedList.root = doublyLinkedList.addInBack(2);
        doublyLinkedList.root = doublyLinkedList.addInFront(0);
        doublyLinkedList.root = doublyLinkedList.addInBack(3);
        doublyLinkedList.root = doublyLinkedList.addInFront(-1);
        doublyLinkedList.root = doublyLinkedList.addInBack(4);
        doublyLinkedList.root = doublyLinkedList.addInFront(-2);
        doublyLinkedList.root = doublyLinkedList.removeFromFront();
        doublyLinkedList.root = doublyLinkedList.removeFromBack();
    }
}
