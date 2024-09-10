import java.util.ArrayList;

public class LowestCommenAncestor {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean getPath(Node root,int n,ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);

        if(root.data == n){
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    //First approach:
    public static Node lca(Node root,int n1,int n2){
      ArrayList<Node> path1 = new ArrayList<>();
      ArrayList<Node> path2 = new ArrayList<>();

      //Find the path
      getPath(root,n1,path1);
      getPath(root,n2,path2);

      //last common ancestor:
      int i = 0;
      for(;i<path1.size() && i<path2.size();i++){
          if(path1.get(i) != path2.get(i)){
            break;
          }
      }

      Node lca = path1.get(i-1);
      return lca;
    }


    //Second approach:
    public static Node lca2(Node root,int n1,int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if(leftLca == null){
            return rightLca;
        }

        if(rightLca == null){
            return leftLca;
        }

       return root;
    }

    public static int lcaDist(Node root,int n){
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int left = lcaDist(root.left, n);
        int right = lcaDist(root.right, n);

        if(left == -1 && right == -1){
            return -1;
        }else if(left == -1){
            return right+1;
        }else{
            return left+1;
        }
    }

    //Calculate the min dist between the two nodes:
    public static int minDis(Node root,int n1,int n2){
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca,n1);
        int dist2 = lcaDist(lca,n2);

        return dist1 + dist2;
    }



    //Kth ancestor:
    public static int KAncestor(Node root,int n,int k){
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }

        int max = Math.max(leftDist,rightDist);
        if (max+1 == k) {
            System.out.println("Kth Ancestor is: " + root.data);
        }

        return max+1;
    }

    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        // System.out.println(lca(root, 4, 6).data);
        // System.out.println(lca2(root, 4, 5).data);
        // System.out.println(minDis(root, 4, 5));
        KAncestor(root, 4, 2);
    }
}