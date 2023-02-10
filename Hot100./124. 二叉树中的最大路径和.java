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

        int leftMax = Math.max(traverse(root.left), 0);
        int rightMax = Math.max(traverse(root.right), 0);
        res = Math.max(res, leftMax + rightMax + root.val);

        return root.val + Math.max(leftMax, rightMax);
    }
}
