public class ValidateBST{
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
    
    public static boolean isValidate(Node root,Node min,Node max){

        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }
        if(max != null && root.data >= max.data){
            return false;
        }
        return isValidate(root.left, min, root) && isValidate(root.right, root, max);
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(6);

        if(isValidate(root, null, null)){
            System.out.println("The tree is validate");
        }else{
            System.out.println("The tree is not validate");
        }
    }
}