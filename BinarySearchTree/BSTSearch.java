public class BSTSearch{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean checkKey(Node root,int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data > key){
            return checkKey(root.left, key);
        }else{
            return checkKey(root.right, key);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(6);

        if(checkKey(root, 10)){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }
    }
}



//Note:
/* 
 * Time Complexcity : O(H) = Height of the tree
 */