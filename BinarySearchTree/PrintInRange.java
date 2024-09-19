public class PrintInRange {
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

    public static void printRange(Node root, int r1, int r2) {
        if (root == null) {
            return;
        }

        // Traverse the left subtree if root's data is greater than r1
        if (root.data > r1) {
            printRange(root.left, r1, r2);
        }

        // Print the root's data if it lies within the range [r1, r2]
        if (root.data >= r1 && root.data <= r2) {
            System.out.print(root.data + " ");
        }

        // Traverse the right subtree if root's data is less than r2
        if (root.data < r2) {
            printRange(root.right, r1, r2);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(6);

        // Print all nodes in the range [3, 5]
        printRange(root, 3, 5);
    }
}
