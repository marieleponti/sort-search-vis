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
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    TreeNode<AnyType> root;

    // Constructor BinarySearchTree
    public BinarySearchTree(){
        root = null;
    }

    public BinarySearchTree(TreeNode<AnyType> node){
        root = node;
    }

    // public method isEmpty
    public boolean isEmpty(){
        return root == null;
    }

    /* public method contains takes parameter of AnyType, calls
     * private contains() method taking parameter of AnyType and
     * root Node */
     public boolean contains(AnyType x){
        return contains(x, root);
    }

    /* Public insert() method. Takes AnyType argument.
     * Calls private insert() method calling AnyType element
     * and root Node. */
    public void insert(AnyType x){
        root = insert(x, root);
    }

    /* public remove() method. Calls private remove() method which
     * returns root after removal. */
    public void remove(AnyType x){
        root = remove(x, root);
    }

    public AnyType findMin(){
        return findMin(root).data;
    }

    public AnyType findMax(){
        return findMax(root).data;
    }

    public boolean find(AnyType x){return find(x, root); }

    public void print(){printLevelOrder(root);}

    public void printInOrder(){printInOrder(root);}

    /* private contains() method
     * If root is null return false. Otherwise, compare node (root to begin)'s element to
     * element x being searched for. If x < node's element, go left in the tree.
     * That is, recursively call contains method on t.left. If x > node's element,
     * go right in the tree-> call contains on t.right. Otherwise (x is neither less than
     * nor greater than node's element), x == node's element, return true. */
    private boolean contains(AnyType x, TreeNode<AnyType> t){
         if (t == null) return false;
         int compare = x.compareTo(t.data);
         if (compare < 0){
             return contains(x, t.left);
         } else if (compare > 0){
             return  contains(x, t.right);
         } else {
             return true;
         }
    }

    /* Private insert() method which inserts element into
     * tree and returns the root node after insert.
     * if the element to be inserted x is less than t's element, and
     * t has no left child, insert x here. otherwise recursive call to
     * method with t's left child node. If x is greater than t's
     * element, and there is no right child, insert there. Otherwise
     * recursive call to insert with t's right child node.*/
    private TreeNode<AnyType> insert(AnyType x, TreeNode<AnyType> t){
        if (t == null) return new TreeNode(x);
        int compare = x.compareTo(t.data);
        if (compare <= 0){
            if (t.left == null){
                t.left = new TreeNode(x);
            } else {
                insert(x, t.left);
            }
        } else if (compare > 0){
            if (t.right == null){
                t.right = new TreeNode(x);
            } else {
                insert(x, t.right);
            }
        }
        return t;
    }

    /* private remove method that returns a Node of AnyType.
    * Parameters are AnyType and the root node. If x is less
    * than root node's data go left. If greater, goes right.
    * Otherwise (the element to be removed has been found):
    * If two children: replace calling node's element with
    * the greatest value of right subtree. Then remove the
    * original node from left subtree.
    * */
    private TreeNode<AnyType> remove(AnyType x, TreeNode<AnyType> t){
        if (t == null) {
            return null;
        }
        int compare = x.compareTo(t.data);
        if (compare < 0){
            remove(x, t.left);
        } else if (compare > 0){
            remove(x, t.right);
        } else { // match
            if (t.left != null && t.right != null){ // 2 children
              // replace with max of left subtree
                t.data = findMax(t.left).data;
                t.left = remove(t.data, t.left);
            } else {
                t = t.left != null ? t.left : t.right;
            }
        }
        return t;
    }

    private TreeNode<AnyType> findMin(TreeNode<AnyType> t){
        if (t == null) return null;
        if (t.left != null) return findMin(t.left);
        return t;
    }

    private TreeNode<AnyType> findMax(TreeNode<AnyType> t){
        if (t == null) return null;
        if (t.right != null) return findMax(t.right);
        return t;
    }

    private boolean find(AnyType element, TreeNode<AnyType> t){
        if (t.data == element) {
            return true;
        } else if (t.left != null && t.right != null){
            return find(element, t.left) || find(element, t.right);
        } else if (t.left != null){
            return find(element, t.left);
        } else if (t.right != null){
            return find(element, t.right);
        } else {
            return false;
        }
    }

    /********************** Breadth First Search ****************************/
    private void printLevelOrder(TreeNode<AnyType> t){
        if (t == null) {
            return;
        }
        Queue<TreeNode<AnyType>> q = new Queue<TreeNode<AnyType>>();
        q.enqueue(t);
        while (!q.isEmpty()){
            TreeNode<AnyType> node = q.dequeue();
            System.out.println(node.data);
            if (node.left != null){
                q.enqueue(node.left);
            }
            if (node.right != null){
                q.enqueue(node.right);
            }
        }
    }

    /********************** Depth First Search ****************************/
    public void printInOrder(TreeNode<AnyType> t){
        if (t == null) return;
        if (t.left != null){
            printInOrder(t.left);
        }
        System.out.println(t.data);
        if (t.right != null){
            printInOrder(t.right);
        }
    }
}
