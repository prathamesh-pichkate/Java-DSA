import java.util.LinkedList;
import java.util.Queue;

public class TypesOfTraversal{
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

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    // 1. Preorder Traversal:
    public static void preorderTraversal(Node root){
        if(root == null){
            if(root == null){
                System.out.print(-1 + " ");
            }
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    //2.Inorder Traversal:
    public static void inorderTraversal(Node root){
        if(root == null){
            return;
        }

        inorderTraversal(root.left);
        System.out.println(root.data + " ");
        inorderTraversal(root.right);
    }

    //3. Postorder Traversal:
    public static void postOrder(Node root){
        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + " ");
    }

    //4. LevelOrder Traversal:
    public static void levelOrderTraversal(Node root){
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }


    // 5.Height:
    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    // 6.Count of Nodes:
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }

        int lh = countNodes(root.left);
        int rh = countNodes(root.right);

        return lh+rh+1;
    }

    // 7.Sum of Nodes:
    public static int sumNodes(Node root){
        if(root == null){
            return 0;
        }

        int lh = sumNodes(root.left);
        int rh = sumNodes(root.right);
        return lh+rh+root.data;
    }

    // 8.Diameter of the Tree: O(n^2)
    public static int diameterTree(Node root){
        if(root == null){
            return 0;
        }

        int lDia = diameterTree(root.left);
        int lh = height(root.left);
        int rDia = diameterTree(root.right);
        int rh = height(root.right);

        int selfDiam = lh + rh +1;

        return Math.max(selfDiam , Math.max(lDia,rDia));
    }

    // 9. Diameter of the Tree: O(n)
    static class Info{
        int diam;
        int ht;
        public Info(int d,int h){
            this.diam = d;
            this.ht = h;
        }
    }

    public static Info diameter(Node root){
        if(root == null){
            return new Info(0,0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht,rightInfo.ht) + 1;
        
        return new Info(diam, ht);
    }


    public static void main(String[] args) {
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(arr);

        // preorderTraversal(root);
        // inorderTraversal(root);
        // postOrder(root);
        // levelOrderTraversal(root);
        // System.out.println(height(root));
        // System.out.println(countNodes(root));
        // System.out.println(sumNodes(root));
        // System.out.println(diameterTree(root));
        // System.out.println(diameter(root).diam);
    }
}