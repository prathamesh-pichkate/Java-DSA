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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalOutput = new ArrayList<>();
        if (root == null) {
            return finalOutput;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currValue = queue.poll();
                currLevel.add(currValue.val);

                if (currValue.left != null) {
                    queue.offer(currValue.left);
                }
                if (currValue.right != null) {
                    queue.offer(currValue.right);
                }
            }
            finalOutput.add(currLevel); 
        }
        return finalOutput;
    }
}
