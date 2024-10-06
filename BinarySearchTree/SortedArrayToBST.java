public class SortedArrayToBST {
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

    public static Node arrToBst(int sortedArr[], int start, int end) {
        if (start > end) {
            return null;
        }

        // Corrected calculation of mid
        int mid = start + (end - start) / 2;
        Node root = new Node(sortedArr[mid]);

        root.left = arrToBst(sortedArr, start, mid - 1);
        root.right = arrToBst(sortedArr, mid + 1, end);
        return root;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int sortedArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node root = arrToBst(sortedArr, 0, sortedArr.length - 1);

        System.out.print("Preorder Traversal of BST: ");
        preorder(root);
    }
}
