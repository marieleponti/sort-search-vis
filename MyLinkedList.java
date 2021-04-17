import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
    private int theSize;
    private Node<AnyType> head;
    private Node<AnyType> tail;

    private class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> next;
        public Node<AnyType> previous;

        public Node(){
            data = null;
            next = null;
            previous = null;
        }

        public Node(AnyType x){
            data = x;
            next = null;
            previous = null;
        }

        public Node(AnyType d, Node p, Node n){
            data = d;
            previous = p;
            next = n;
        }
    }

    public int size(){
        return  theSize;
    }

    public void setSize(int s){
        theSize = s;
    }

    public boolean isEmpty(){
        return theSize == 0;
    }

    public boolean add(AnyType x){
        addIdx(size(), x); return true; }

    public void addAtEnd(AnyType x){
        Node<AnyType> newNode = new Node<AnyType>();
        newNode.data = x;
        if (size() == 0){
            head = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
        }
        System.out.println("adding " + newNode.data);
        tail = newNode;
        if (tail != null) System.out.println("tail points to " + tail.data);
        theSize++;
    }

    public void addIdx(int idx, AnyType x){
        addBefore(getNode(idx), x);
    }

    public AnyType get(int idx){
        return getNode(idx).data;
    }

    public AnyType removeFromEnd(){
        if (tail != null){
            if (head == tail){
                head = null;
                tail = null;
            } else {
                AnyType dataToRemove = tail.data;
                tail.previous.next = null;
                tail = tail.previous;
                return dataToRemove;
            }
            theSize--;
        }
        return null;
    }

    public void insertAtHead(AnyType d){
        Node myNode = new Node(d);
        if (head == null){
            head = myNode;
            tail = myNode;
        } else {
            myNode.next = head;
            head.previous = myNode;
            head = myNode;
        }
        theSize++;
    }

    public void print(){print(head);}

    private Node<AnyType> getNode(int idx){
        Node<AnyType> marker;
//        if (idx <= size()/2){
//            marker = head;
//            for (int i = 0; i < idx; i++){
//                marker = marker.next;
//            }
//        } else {
//            marker = tail;
//            for (int i = size(); i > idx; i--){
//                marker = tail.previous;
//            }
//        }
        marker = head;
        for (int i = 0; i < idx; i++){
            marker = marker.next;
        }
        return marker;
    }

    private void addBefore(Node<AnyType> n, AnyType x){
        Node<AnyType> newNode = new Node(x);
        if (size() == 0){
            head = newNode;
            tail = newNode;
        } else if (n == null){
            newNode.previous = tail;
            newNode.previous.next = newNode;
            tail = newNode;
        } else if (n.next != null && n.previous != null){
            newNode.previous = n.previous;
            newNode.next = n;
            newNode.previous.next = newNode;
            n.previous = newNode;
        }
        theSize++;
    }

    private AnyType remove(Node<AnyType> p){
        p.next.previous = p.previous;
        p.previous.next = p.next;
        theSize--;
        return p.data;
    }

    public void print(Node<AnyType> t){
        if (t != null){
            System.out.println(t.data);
            while (t.next != null){
                print(t.next);
            }
        }
    }

    public Iterator<AnyType> iterator(){return new LinkedListIterator();}

    public class LinkedListIterator implements Iterator<AnyType>{
        private Node<AnyType> current = head.next;

        public boolean hasNext(){
            return current != tail;
        }

        public AnyType next(){
            if(!hasNext())throw new NoSuchElementException();
            AnyType nextElement = current.data;
            current = current.next;
            return nextElement;
        }

        public void remove(){
            MyLinkedList.this.remove(current.previous);
        }
    }
}
