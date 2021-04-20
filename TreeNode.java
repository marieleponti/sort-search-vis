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
