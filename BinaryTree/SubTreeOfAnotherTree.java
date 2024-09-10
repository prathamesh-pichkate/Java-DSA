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
        } else if (root == null || subroot == null || root.data != subroot.data) {
            return false;
        }

        return isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right);
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

        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
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
