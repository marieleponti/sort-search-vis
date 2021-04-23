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
public class AVLTree<AnyType extends Comparable<? super AnyType>> extends  BinarySearchTree{
    private static final int maxHeightDif = 1;
    private static class Node<AnyType>{
        AnyType data;
        Node<AnyType> left;
        Node<AnyType> right;
        int height;

        Node(AnyType x){
            this(x, null, null, 0);
        }

        Node(AnyType x, Node<AnyType> lt, Node<AnyType> rt, int h){
            data = x;
            left = lt;
            right = rt;
            height = h;
        }
    }

    private int height(Node<AnyType> t){
        return t == null? -1 : t.height;
    }

    private Node<AnyType> insert(AnyType x, Node<AnyType> t){
        if (t == null) return new Node<AnyType>(x);
        int compare = x.compareTo(t.data);
        if (compare <= 0){
            t.left = insert(x, t.left);
        } else if (compare > 0){
            t.right = insert(x, t.right);
        }
        return balance(t);
    }

    private Node<AnyType> balance(Node<AnyType> t){
        if (t == null) return null;
        if (height(t.left) - height(t.right) > maxHeightDif){
            // left subtree's height needs to be reduced
            /* check if left subtree's left side is taller than
             * left subtree's right side
             */
            if (height(t.left.left) >= height(t.left.right)){
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        } else if (height(t.right) - height(t.left) > maxHeightDif){
            // right subtree's height needs to be reduced
            /* check if right subtree's right side is taller than
             * right subtree's left side
             */
            if (height(t.right.right) >= height(t.right.left)){
                t = rotateWithRightChild(t);
            } else {
                t = doubleWithRightChild(t);
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    private Node<AnyType> rotateWithLeftChild(Node<AnyType> k2){
        Node<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max( k2.height, height(k2.right)) + 1;
        return k1;
    }

    private Node<AnyType> rotateWithRightChild(Node<AnyType> k2){
        Node<AnyType> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private Node<AnyType> doubleWithLeftChild(Node<AnyType> k3){
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private Node<AnyType> doubleWithRightChild(Node<AnyType> k3){
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    private Node<AnyType> remove(AnyType x, Node<AnyType> t){
        super.remove(x);
        return balance(t);
    }
}
