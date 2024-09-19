import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) { 
        this.val = val; 
    }
}

public class RootToLeafPath {

    public List<String> rootToLeaf(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result; // Exit if the tree is empty
        }
        
        // Start recursive path building
        System.out.println("Starting at root: " + root.val);
        buildPaths(root, "", result);
        
        return result;
    }
    
    private void buildPaths(TreeNode node, String path, List<String> result) {
        if (node != null) {
            path += node.val; // Append the current node's value to the path
            
            System.out.println("Visiting node: " + node.val);
            System.out.println("Current path: " + path);
            
            // If it's a leaf node, store the path in the result
            if (node.left == null && node.right == null) {
                System.out.println("Leaf node found, adding path to result: " + path);
                result.add(path);
            } else {
                // If not a leaf, append '->' to continue the path
                path += "->";
                
                // Recursively visit the left and right children
                if (node.left != null) {
                    System.out.println("Going left from node " + node.val);
                }
                buildPaths(node.left, path, result);
                
                if (node.right != null) {
                    System.out.println("Going right from node " + node.val);
                }
                buildPaths(node.right, path, result);
            }
        }
    }

    public static void main(String[] args) {
        RootToLeafPath sol = new RootToLeafPath();
        
        // Example tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        // Fetch and print all paths
        List<String> paths = sol.rootToLeaf(root);
        System.out.println("All paths: " + paths);
    }
}
