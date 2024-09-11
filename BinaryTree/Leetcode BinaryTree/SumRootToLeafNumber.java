// Leetcode 129

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
    public int sumNumbers(TreeNode root) {
        return totalSum(root,0);
    }

    private int totalSum(TreeNode root,int currSum){
        if(root == null){
            return 0;
        }

        currSum = currSum * 10 + root.val;

        if(root.left == null && root.right == null){
            return currSum;
        }
   
        int leftSum = totalSum(root.left,currSum);
        int rightSum = totalSum(root.right,currSum);

        return leftSum + rightSum;
    }
}