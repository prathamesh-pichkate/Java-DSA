
import java.util.*;
public class ConvertBtToBST{
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

    public static void inorder( Node root, ArrayList<Integer> sort){
        if(root == null){
            return;
        }

        inorder(root.left, sort);
        sort.add(root.data);
        inorder(root.right, sort);
    }

    public static Node arrToBst(int sort[], int start, int end) {
        if (start > end) {
            return null;
        }

        // Corrected calculation of mid
        int mid = start + (end - start) / 2;
        Node root = new Node(sort[mid]);

        root.left = arrToBst(sort, start, mid - 1);
        root.right = arrToBst(sort, mid + 1, end);
        return root;
    }


    public static Node balanceBST(Node root){
        ArrayList<Integer> sort = new ArrayList<>();
        inorder(root, sort);
        
        
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
    }
}