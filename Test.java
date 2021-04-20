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

    public static int binarySearch(int[] arr, int x){
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            int mid = (end - start)/2 + start;
            if (arr[mid] == x){
                return mid;
            } else if (x < arr[mid]){
                end = mid - 1;
            } else if (x > arr[mid]){
                start = mid + 1;
            }
        }
        return -1; // error: not found
    }

    public static int binarySearchRecursive(int[] arr, int x, int start, int end){
        int mid = (end - start)/2 + start;
        if (arr[mid] == x){
            return mid;
        } else if (x < arr[mid]){
            return binarySearchRecursive(arr, x, start, mid - 1);
        } else if (x > arr[mid]){
            return binarySearchRecursive(arr, x, mid + 1, end);
        }
        return -1; // error: not found
    }

    public static void main(String[] args){
        // create instance of BST of type int
        System.out.println("********************* BST Tree *********************");
        BinarySearchTree BST = new BinarySearchTree();
        for (int i = 0; i < 10; i++){
            int num = (int) (Math.random() * 100);
            System.out.print("insert " + num + ", \n");
            BST.insert(num);

        }
        System.out.println("Level order traversal:");
        BST.print();
        System.out.println();

        // create instance of BST of type String
        BinarySearchTree BST1 = new BinarySearchTree();
        String[] strArr = {"joy", "wander", "forest", "laugh", "chat", "joke"};
        for (int i = 0; i < strArr.length; i++){
            BST1.insert(strArr[i]);
        }
        System.out.println("Level order traversal:");
        BST1.print();
        System.out.println();

        System.out.println("********************* AVL Tree *********************");
        // instance of AVLTree
        BinarySearchTree avlTree = new AVLTree();
        for (int i = 0; i < 10; i++){
            int num = (int) (Math.random() * 100);
            System.out.print("insert " + num + ", \n");
            avlTree.insert(num);

        }
        System.out.println("Level order traversal:");
        avlTree.print();
        System.out.println();

        // instance of AVLTree
        BinarySearchTree avlTree1 = new AVLTree();
        int[] arr = {52, 44, 41, 3, 52, 3, 12, 29, 80, 0};
        for (int i = 0; i < 7; i++){
            avlTree1.insert(arr[i]);
        }
        System.out.println("Level order traversal:");
        avlTree1.print();
        System.out.println();
    }
}
