public class Queue<AnyType extends Comparable<? super AnyType>> extends MyLinkedList {
    public void enqueue(AnyType x){
        super.insertAtHead(x);
    }

    public void dequeue(){
        super.removeFromEnd();
    }
}
