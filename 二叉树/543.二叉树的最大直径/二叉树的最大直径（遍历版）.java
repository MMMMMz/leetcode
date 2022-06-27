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

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root){
        if(root == null){
            return;
        }

        res = Math.max((maxDepth(root.left) + maxDepth(root.right)), res);
        traverse(root.left);
        traverse(root.right);
    }

    int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

}
