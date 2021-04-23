/** Mariele Ponticiello
 * CS 592
 * This program implements the following sorting and searching algorithms with a visualization
 * of the algorithm and its runtime:
 * Bubble Sort
 * Selection Sort
 * Radix Sort
 * Binary Search Tree Sort
 * AVL Tree Sort
 * Insertion Sort
 * Merge Sort
 * Quick Sort
 *
 * Binary Search
 * Graphs and Trees
 * 	Breadth-First Search
 * 	Depth-First Search
 * **/
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
