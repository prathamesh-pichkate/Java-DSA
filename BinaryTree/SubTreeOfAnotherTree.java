public class SubTreeOfAnotherTree {
    public class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isIdentical(Node root, Node subroot) {
        if (root == null && subroot == null) {
            return true;
        } 
        else if (root == null || subroot == null || root.data != subroot.data) {
            return false;
        }

        if (!isIdentical(root.left, subroot.left)) {
            return false;
        }

        if (!isIdentical(root.right, subroot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root, Node subroot) {
        if (root == null) {
            return false;
        }

        if (root.data == subroot.data) {
            if (isIdentical(root, subroot)) {
                return true;
            }
        }

        boolean leftAns = isSubtree(root.left, subroot);
        boolean rightAns = isSubtree(root.right, subroot);

        return leftAns || rightAns;
    }

    public static void main(String[] args) {
        SubTreeOfAnotherTree tree = new SubTreeOfAnotherTree();

        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);
        root.right.left = tree.new Node(6);
        root.right.right = tree.new Node(7);

        // sub tree:
        Node subroot = tree.new Node(2);
        subroot.left = tree.new Node(4);
        subroot.right = tree.new Node(5);

        // Check if subroot is a subtree of root
        boolean result = isSubtree(root, subroot);
        System.out.println("Is subroot a subtree of root? " + result);
    }
}


/// Condition to check if it was identical or not:
///    1. Check for the null value if any of the node is null return false,if both nodes are null return true.
///    2. If both values are not identical then its not identical
///    3. Check in the left and right subtree for identical values.