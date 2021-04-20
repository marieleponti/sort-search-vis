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
        BinarySearchTree BST = new BinarySearchTree();
        for (int i = 0; i < 10; i++){
            int num = (int) (Math.random() * 100);
            System.out.print("insert " + num + ", \n");
            BST.insert(num);

        }
        System.out.println("Level order traversal:\n");
        BST.print();
        System.out.println();

        BinarySearchTree BST1 = new BinarySearchTree();
        String[] strArr = {"joy", "wander", "forest", "laugh", "chat", "joke"};
        for (int i = 0; i < strArr.length; i++){
            BST1.insert(strArr[i]);
        }

        System.out.println("Level order traversal:\n");
        BST1.print();
        System.out.println();

    }
}
