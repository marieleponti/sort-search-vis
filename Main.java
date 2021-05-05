import java.lang.reflect.Array;
import java.util.Arrays;

/** Mariele Ponticiello
 * CS 592
 * This program implements the following sorting and searching algorithms with a visualization
 * of the algorithm and its runtime:
 * Bubble Sort
 * Selection Sort
 * Insertion Sort
 * Merge Sort
 * Quick Sort
 * Binary Search
 * Graphs and Trees
 * Breadth-First Search
 * Depth-First Search
 * **/
public class Main {

    // Iterative binarySearch method for type int
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

    // Generic binary search for any type
    public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType[] arr, AnyType x){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = (end - start)/2 + start;
            int compare = x.compareTo(arr[mid]);
            if (compare == 0){
                return mid;
            } else if (compare < 0){
                end = mid - 1;
            } else if (compare > 0){
                start = mid + 1;
            }
        }
        return -1; // error: not found
    }

    // Recursive binary search for type int
    public static int binarySearchRecursiveAux(int[] array, int element){
        return binarySearchRecursive(array, element, 0, array.length - 1);
    }
    public static int binarySearchRecursive(int[] arr, int x, int start, int end){
        if (start < end){
            int mid = (end - start)/2 + start;
            if (arr[mid] == x){
                return mid;
            } else if (x < arr[mid]){
                return binarySearchRecursive(arr, x, start, mid - 1);
            } else if (x > arr[mid]){
                return binarySearchRecursive(arr, x, mid + 1, end);
            }
        }
        return -1; // error: not found
    }

    public static void mergesort(int[] arr){
        int[] helper = new int[arr.length];
        mergesort(arr, helper, 0, arr.length - 1);
    }

    public static void mergesort(int[] arr, int[] aux, int low, int high){
        if (low < high){
            int mid = (high - low)/2 + low;
            mergesort(arr, aux, low, mid);
            mergesort(arr, aux, mid + 1, high);
            merge(arr, aux, low, mid, high);
        }
    }

    public static void merge(int[] arr, int[] aux, int low, int mid, int high){
        /* Copy both halves of array into aux array
         */
        for (int i = low; i <= high; i++){
            aux[i] = arr[i];
        }

        int trackLeft = low;
        int trackRight = mid + 1;
        int current = low;

        /* Iterate through helper array. Compare left and right half, copying back
        the smaller element from the two halves into the original array
         */
        while (trackLeft <= mid && trackRight <= high){
            if (aux[trackLeft] <= aux[trackRight]){
                arr[current] = aux[trackLeft];
                trackLeft++;
            } else {
                arr[current] = aux[trackRight];
                trackRight++;
            }
            current++;
            printArray(arr);
        }
        int remaining = mid - trackLeft;
        for (int i = 0; i < remaining; i++){
            arr[current + 1] = aux[trackLeft + 1];
        }
    }

    public static void insertionsort(int[] array){
        for (int i = 1; i < array.length; i++){
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key){
                array[j + 1] = array[j];
                j--;
                printArray(array);
            }
            array[j + 1] = key;
        }
    }

    public static void quicksort(int[] array){
        quicksort(array, 0, array.length - 1);
    }

    public static void quicksort(int[]array, int left, int right){
        if (left >= right) {
            return;
        }
        int pivot = array[(left + right) / 2];
        System.out.print("Pivot is " + pivot + " | ");
        int index = partition(array, left, right, pivot);
        if (left < index - 1){
            // sort left half
            quicksort(array, left, index - 1);
        }
        if (right > index){
            quicksort(array, index, right);
        }
    }

    public static int partition(int[] arr, int left, int right, int pivot){
        while (left <= right){
            while (arr[left] < pivot){
                left++;
            }
            while (arr[right] > pivot){
                right--;
            }
            if (left <= right){
                swap(arr, left, right);
                left++;
                right--;
            }
            printArray(arr);
        }
        return left;
    }

    public static void bubblesort(int[] arr){
        int i = 0;
        boolean swap = true;
        while (swap){
            swap = false;
            i++;
            for (int j = 0; j < arr.length - i; j++){
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                }
                swap = true;
                printArray(arr);
            }
        }
    }

    public static void selectionsort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            int minPtr = i;
            for (int j = i; j < arr.length; j++){
                if (arr[j] < arr[minPtr]) minPtr = j;
            }
            swap(arr, i, minPtr);
            printArray(arr);
        }
    }

    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void printArray(int[] arr){
        System.out.print("Current elements: ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static <AnyType extends Comparable<? super AnyType>> void printArray(AnyType[] arr) {
        System.out.print("Current elements: ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        // create instance of BST of type int
        System.out.println("--------------------- BST Tree of type int ---------------------");
        BinarySearchTree BST = new BinarySearchTree();
        for (int i = 0; i < 10; i++){
            int num = (int) (Math.random() * 100);
            System.out.print("insert " + num + "\n");
            BST.insert(num);

        }
        System.out.println("--------------------- Breadth first search ---------------------");
        System.out.println("Level order traversal:");
        BST.print();
        System.out.println();
        System.out.println("--------------------- Depth first search ---------------------");
        System.out.println("In order traversal:");
        BST.printInOrder();
        System.out.println("Find min element: ");
        System.out.println(BST.findMin());
        System.out.println("Find max element: ");
        System.out.println(BST.findMax());
        System.out.println();

        // create instance of BST of type String
        System.out.println("--------------------- BST Tree of type String ---------------------");
        BinarySearchTree BST1 = new BinarySearchTree();
        String[] strArr = {"joy", "wander", "forest", "laugh", "chat", "joke"};
        String[] strArr1 = {"Petersburg", "Louisville", "Detroit", "Atlanta", "atlanta", "louisville",
                "Birmingham", "Jacksonville", "Charlotte"};
        for (int i = 0; i < strArr.length; i++){
            System.out.println("insert " + strArr[i]);
            BST1.insert(strArr[i]);
        }
        System.out.println("\nLevel order traversal:");
        BST1.print();
        System.out.println();
        System.out.println("In order traversal:");
        BST1.printInOrder();
        System.out.println();
        for (int i = 0; i < strArr1.length; i++){
            System.out.println("insert " + strArr1[i]);
            BST1.insert(strArr1[i]);
        }
        System.out.println("\nLevel order traversal:");
        BST1.print();
        System.out.println();
        System.out.println("In order traversal:");
        BST1.printInOrder();
        System.out.println("\ncontains " + strArr1[4] + "? " + BST1.contains(strArr1[4]));
        System.out.println("remove " + strArr1[4]);
        BST1.remove(strArr1[4]);
        System.out.println("In order traversal:");
        BST1.printInOrder();

        System.out.println("--------------------- Linked List of ints ---------------------");
        MyLinkedList llint = new MyLinkedList();
        for (int i = 0; i < 10; i++){
            int num = (int) (Math.random() * 100);
            System.out.print("add at end: " + num + "\n");
            llint.addAtEnd(num);
            llint.print();
        }
        System.out.println();

        System.out.println("--------------------- Linked List of Strings ---------------------");
        MyLinkedList llstr = new MyLinkedList();
        for (int i = 0; i < strArr1.length; i++){
            if (i % 2 == 0){
                System.out.print("add at head: " + strArr1[i] + "\n");
                llstr.insertAtHead(strArr1[i]);
            } else {
                System.out.print("add at tail: " + strArr1[i] + "\n");
                llstr.addAtEnd(strArr1[i]);
            }
            llstr.print();
        }
        System.out.println();

        System.out.println("--------------------- AVL Tree of random ints ---------------------");
        // instance of AVLTree
        BinarySearchTree avlTree = new AVLTree();
        for (int i = 0; i < 10; i++){
            int num = (int) (Math.random() * 100);
            System.out.print("insert " + num + "\n");
            avlTree.insert(num);

        }
        System.out.println("Level order traversal:");
        avlTree.print();
        System.out.println();
        System.out.println("In order traversal:");
        avlTree.printInOrder();
        System.out.println();

        // instance of AVLTree
        System.out.println("--------------------- AVL Tree (2) of ints ---------------------");
        BinarySearchTree avlTree1 = new AVLTree();
        int[] arr = {52, 44, 41, 3, 52, 3, 12, 29, 80, 0};
        for (int i = 0; i < 7; i++){
            avlTree1.insert(arr[i]);
        }
        System.out.println("Level order traversal:");
        avlTree1.print();
        System.out.println();

        System.out.println("--------------------- Mergesort with ints ---------------------");
        int[] arrRandInts = new int[10];
        for (int i = 0; i < 10; i++){
            arrRandInts[i] = (int)(Math.random() * 100);
        }
        printArray(arrRandInts);
        mergesort(arrRandInts);

        System.out.println("--------------------- Quicksort ---------------------");
        for (int i = 0; i < 10; i++){
            arrRandInts[i] = (int)(Math.random() * 100);
        }
        printArray(arrRandInts);
        quicksort(arrRandInts);

        System.out.println("--------------------- Insertionsort ---------------------");
        for (int i = 0; i < 10; i++){
            arrRandInts[i] = (int)(Math.random() * 100);
        }
        printArray(arrRandInts);
        insertionsort(arrRandInts);

        System.out.println("--------------------- Bubblesort ---------------------");
        for (int i = 0; i < 10; i++){
            arrRandInts[i] = (int)(Math.random() * 100);
        }
        printArray(arrRandInts);
        bubblesort(arrRandInts);

        System.out.println("--------------------- Selectionsort ---------------------");
        for (int i = 0; i < 10; i++){
            arrRandInts[i] = (int)(Math.random() * 100);
        }
        printArray(arrRandInts);
        selectionsort(arrRandInts);

        System.out.println("--------------------- Binary search ---------------------");
        printArray(arrRandInts);
        int intToFind = arrRandInts[7];
        System.out.println("Binary search for " + intToFind);
        System.out.println("Found at index " + binarySearch(arrRandInts, intToFind));
        System.out.println("Recursive binary search for " + intToFind);
        System.out.println("Found at index " + binarySearchRecursiveAux(arrRandInts, intToFind));
        String strToFind = strArr[3];
        System.out.println("Binary search (generic method) for " + strToFind);
        System.out.println("Found at index " + binarySearch(strArr, strToFind));
    }
}
