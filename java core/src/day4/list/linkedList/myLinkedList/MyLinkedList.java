package day4.list.linkedList.myLinkedList;

public class MyLinkedList<E> {
    private  Node head;
    private  int numNodes;

    public MyLinkedList(){
        
    }

    public MyLinkedList(Object data) {
        head = new Node(data);
    }
 
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, E data) {
        Node temp = head;
        Node holder;

        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E data){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(data);
        temp.next.next = null;
        numNodes++;
    }

    public E remove (int index){
        E rm_element = null;
        Node temp = head;
        Node previous = head;
        for(int i = 0; i < index; i++){
            previous = temp;
            temp = temp.next;
        }
        rm_element = (E) temp.getData();
        previous.next = temp.next;
        numNodes--;
        return rm_element;
    }

    public boolean remove(Object e){
        boolean result = false;
        Node temp = head;
        Node previous = head;
        while(temp.next != null){
            if(temp.getData() == e){
                if(temp == head){
                    head = temp.next;
                } else {
                    previous.next = temp.next;
                }
                numNodes--;
                result = true;
                break;
            }
            previous = temp;
            temp = temp.next;
        }
        return result;
    }

    public int size(){
        return numNodes;
    }

    public boolean contains(E o){
        Node temp = head;
        while(temp.next != null){
            if(temp.getData() == o){
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o){
        Node temp = head;
        if(contains(o)){
            for(int i = 0; i < numNodes; i++){
                if(temp.getData() == o){
                    return i;
                }
                temp = temp.next;
            }
        }
        return -1;
    }

    public Node get(int index){
        Node temp=head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void printList() {
        Node temp = head;
        System.out.println("My list: ");
        while(temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.next;
        }
        System.out.println();
    } 
}
