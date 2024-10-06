import java.util.*;

public class SizeOfLargestBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    // Variable to track the size of the largest BST
    public static int maxBST = 0;

    public static Info largestBST(Node root) {
        // Base case: An empty tree is a BST of size 0
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Recursively get info from left and right subtrees
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        // Initialize current subtree's size, min, and max
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        // Check if the current subtree is a BST
        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        // If both left and right subtrees are BSTs, update maxBST
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max); // Added return statement
        }

        // If not a BST, return the size of the subtree
        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        // Invoke the largestBST method to compute the size of the largest BST
        largestBST(root);

        // Print the result
        System.out.println("Size of the Largest BST is: " + maxBST); // Corrected output
    }
}
