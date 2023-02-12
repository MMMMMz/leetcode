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

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return res;
    }

    int traverse(TreeNode root){
        if(root == null) return 0;
        int leftPathSum = Math.max(traverse(root.left), 0);
        int rightPathSum = Math.max(traverse(root.right), 0);
        res = Math.max(res, leftPathSum + rightPathSum + root.val);

        return Math.max(leftPathSum, rightPathSum) + root.val;
    }
}
