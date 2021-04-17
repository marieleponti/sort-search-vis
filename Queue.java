public class Queue<AnyType extends Comparable<? super AnyType>> extends MyLinkedList {
    private int theSize = 0;

    public void enqueue(AnyType x){
        super.insertAtHead(x);
        theSize++;
    }

    public void dequeue(){
        super.removeFromEnd();
        theSize--;
    }
}
