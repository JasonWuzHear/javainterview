package solutions.trees;

public class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public void traverseInOrder(TreeFunc func) {
        if (left != null) left.traverseInOrder(func);
        func.doIt(this);
        if (right != null) right.traverseInOrder(func);
    }

    public void traversePreOrder(TreeFunc func) {
        func.doIt(this);
        if (left != null) left.traversePreOrder(func);
        if (right != null) right.traversePreOrder(func);
    }

    public void traversePostOrder(TreeFunc func) {
        if (left != null) left.traversePostOrder(func);
        if (right != null) right.traversePostOrder(func);
        func.doIt(this);
    }

    public void insert(int v) {
        if (v > data) {
            if (right == null) right = new BinaryTreeNode(v);
            else right.insert(v);
        } else {
            if (left == null) left = new BinaryTreeNode(v);
            else left.insert(v);
        }
    }

    static int maxDepth(BinaryTreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    static int minDepth(BinaryTreeNode root) {
        if (root == null) return 0;
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
    
    public int maxDepth() {
        return maxDepth(this);
    }

    public int minDepth() {
        return minDepth(this);
    }

    public boolean isBalanced() {
        return (maxDepth() - minDepth() < 2);
    }
    
    
}