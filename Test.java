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
 *
 * 	Week 2: 4/13/21 (4/17/21)
 * 	1. tests: insert(), remove(), find(), print()
 * 	2. data struct to test: arrays or lists or Stream objects of Integers and Strings
 *
 * 	Week 3: 4/20/21
 * 	1. Binary search, depth-first search, breadth-first search
 * 	2. Bubble sort, selection sort, radix sort, binary search tree sort, avl tree sort
 *
 * 	Week 4: 4/27/21
 * 	1. insertion sort, merge sort, quick sort
 * 	2. debugging & final testing
 * **/
public class Test {
    public static void main(String[] args){
        // create instance of BST
        System.out.println("********************* BST Tree *********************");
        BinarySearchTree bstree = new BinarySearchTree();
        for (int i = 0; i < 7; i++){
            int num = (int) (Math.random() * 100);
            System.out.print("insert " + num + ", ");
            System.out.println();
            bstree.insert(num);
        }
        bstree.print();
        System.out.println();
        /*
        // create instance of AVLT
        System.out.println("********************* AVL Tree *********************");
        AVLTree avltree = new AVLTree();
        for (int i = 0; i < 10; i++){
            avltree.insert(Math.random());
        }
        avltree.print();
        System.out.println();

        // create instance of LL
        System.out.println("********************* LL *********************");
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < 10; i++){
            list.insertAtHead(Math.random());
        }
        list.print();
        System.out.println();

        // create instance of Queue
        System.out.println("********************* Queue *********************");
        Queue queue = new Queue();
        for (int i = 0; i < 10; i++){
            queue.enqueue(Math.random());
        }
        queue.print();
        System.out.println();
        */
    }
}
