public class TransformToSumTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int sumTree(Node root) {
        // Base case: If the root is null, return 0
        if (root == null) {
            return 0;
        }

        // Recursively convert the left and right subtrees
        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);

        // Store the old value of the current node
        int oldData = root.data;

        // Update current node's value to the sum of values of its left and right children
        root.data = leftSum + rightSum;

        // Return the sum of the node's value (before the update) and its children's sums
        return oldData + root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        sumTree(root);
        printInOrder(root); // Function to check the result
    }

    // Helper function to print the tree in order for verification
    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }
}
z