//103. Binary Tree Zigzag Level Order Traversal
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        boolean leftToRight = true; 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> inner = new ArrayList<>();

            for(int i = 0; i < levelSize; i++){
                TreeNode currNode = q.poll();
                inner.add(currNode.val);

                if(currNode.left != null){
                    q.offer(currNode.left);
                }

                if(currNode.right != null){
                    q.offer(currNode.right);
                }
            }

           
            if (!leftToRight) {
                Collections.reverse(inner);
            }

            result.add(inner);
            leftToRight = !leftToRight; 
        }

        return result;
    }
}
