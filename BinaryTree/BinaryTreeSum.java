public class BinaryTreeSum {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to transform the tree so that each node contains the sum of the nodes in its left and right subtrees
    public static int sumNode(Node root) {
        if (root == null) {
            return 0;
        }

        // Recursively calculate the sum of nodes in the left and right subtrees
        int lh = sumNode(root.left);
        int rh = sumNode(root.right);

        // Store the original data before updating
        int originalData = root.data;

        // Update the current node's data to be the sum of values in its left and right subtrees
        root.data = lh + rh;

        // Return the sum of the subtree rooted at this node (including the node's original data)
        return root.data + originalData;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        sumNode(root);

        System.out.println("Updated Tree Node Values:");
        System.out.println("Root: " + root.data);
        System.out.println("Left Child of Root: " + root.left.data);
        System.out.println("Right Child of Root: " + root.right.data);
        System.out.println("Left Child of Left Child: " + root.left.left.data);
        System.out.println("Right Child of Left Child: " + root.left.right.data);
        System.out.println("Left Child of Right Child: " + root.right.left.data);
        System.out.println("Right Child of Right Child: " + root.right.right.data);
    }
}
