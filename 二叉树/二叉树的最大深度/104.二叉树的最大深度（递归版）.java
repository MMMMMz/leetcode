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
    int res = 0;
    int depth = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }
    void traverse(TreeNode root){
        if(root == null){
            res = Math.max(res,depth);
        }
        depth++;
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
