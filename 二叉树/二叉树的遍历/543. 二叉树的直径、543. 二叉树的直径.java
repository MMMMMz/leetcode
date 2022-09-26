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

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        //计算左右子树的最大深度，然后相加
        traverse(root);
        return max;
    }

    int traverse(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDepth = traverse(root.left);
        int rightDepth = traverse(root.right);
        max = Math.max(max, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth)+ 1;
    }
}
