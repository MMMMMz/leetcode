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
    int res = 1;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return res;
    }

    int dfs(TreeNode root)
    {
        if(root == null){
           return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        res = Math.max(left, right) + 1;
        return res;
    }
}
