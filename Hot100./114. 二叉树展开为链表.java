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
        if(root == null) return;
        
        traverse(root);
    }

    TreeNode traverse(TreeNode root)
    {
        if(root == null) return root;

        TreeNode left = traverse(root.left);
        TreeNode right = traverse(root.right);
        TreeNode p = left;
        while(p != null && p.right != null)
        {
            p = p.right;
        }
        if(p != null){
            p.right = right;
            root.right = left;
            root.left = null;
        }
        
        return root;
    }
}
