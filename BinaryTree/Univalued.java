public class Univalued{
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
    public static boolean univaluedOrNot(Node root,int val){
        if(root == null){
            return true;
        }   

        if(root.data != val){
            return false;
        }

        boolean left = univaluedOrNot(root.left,val);
        boolean right = univaluedOrNot(root.right, val);
         
        return left && right;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right.left = new Node(1);
        root.right.right = new Node(1);

        if(univaluedOrNot(root, root.data)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}