public class Queue<AnyType extends Comparable<? super AnyType>> extends MyLinkedList {
    private int theSize;

    public void enqueue(AnyType x){
        super.insertAtHead(x);
        theSize++;
    }

    public AnyType dequeue(){
        theSize--;
        return (AnyType) super.removeFromEnd();
    }
}
