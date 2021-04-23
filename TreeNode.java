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
public class TreeNode<AnyType extends  Comparable<? super AnyType>> implements Comparable<TreeNode<AnyType>> {
    TreeNode<AnyType> left;
    TreeNode<AnyType> right;
    AnyType data;

    // Constructors
    TreeNode(AnyType element){
        data = element;
        left= null;
        right = null;
    }

    TreeNode(AnyType element, TreeNode<AnyType> lt, TreeNode<AnyType> rt){
        data = element;
        left = lt;
        right = rt;
    }

    @Override
    public int compareTo(TreeNode o) {
        return 0;
    }
}
