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

    public void flatten(TreeNode root) {
        traverse(root);
    }

    TreeNode traverse(TreeNode root){
        if(root == null){
            return null;
        }
       
        TreeNode leftTree = traverse(root.left);
        TreeNode rightTree = traverse(root.right);
        root.left = null;
        root.right = leftTree;
        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        p.right = rightTree;
        return root;
    }
}
