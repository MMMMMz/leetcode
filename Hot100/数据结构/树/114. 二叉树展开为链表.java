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
        if(root == null) return root;

        TreeNode leftNode = traverse(root.left);
        TreeNode rightNode = traverse(root.right);
        TreeNode p = leftNode;
        if(p != null){
            while(p.right != null){
                p = p.right;
            }
            p.right = rightNode;
            root.right = leftNode;
            root.left = null;
        }
        return root;
    }
}
