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
    public TreeNode invertTree(TreeNode root) {
        //分解为子问题，只关注当前节点，它的左右子树都已经被反转
        if(root == null){
            return root;
        }

        TreeNode invertLeft = invertTree(root.left);
        TreeNode invertRight = invertTree(root.right);
        root.left = invertRight;
        root.right = invertLeft;

        return root;
    }
}
