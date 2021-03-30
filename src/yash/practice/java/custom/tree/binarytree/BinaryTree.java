package yash.practice.java.custom.tree.binarytree;

public class BinaryTree<T> {
    BinaryTree<T> left;
    BinaryTree<T> right;
    T data;

    public BinaryTree() { }

    // 0. Add branches to a tree
    public BinaryTree<T> add(BinaryTree<T> tree, T value) {
        if(null == tree) {
            tree = new BinaryTree<>();
            tree.data = value;
            tree.left = null;
            tree.right = null;
            return tree;
        }
        if (value.hashCode() < tree.data.hashCode()) {
            tree.left = add(tree.left, value);
        } else {
            tree.right = add(tree.right, value);
        }
        return tree;
    }

    // 1. Find/print all values in the tree
    public static void printTree(BinaryTree tree, String delimeter) {
        System.out.println(delimeter + tree.data);
        if (null != tree.left) printTree(tree.left, "L "+delimeter);
        if (null != tree.right) printTree(tree.right, "R " +delimeter);
    }
    public static void printInPreOrder(BinaryTree tree, String delimeter) {
        if (null != tree.left) printTree(tree.left, "L "+delimeter);
        System.out.println(delimeter + tree.data);
        if (null != tree.right) printTree(tree.right, "R " +delimeter);
    }
    public static void printInPostOrder(BinaryTree tree, String delimeter) {
        if (null != tree.left) printTree(tree.left, "L "+delimeter);
        if (null != tree.right) printTree(tree.right, "R " +delimeter);
        System.out.println(delimeter + tree.data);
    }
    // 2. Find Depth of the tree
    // 3. Search an element in the tree
}
