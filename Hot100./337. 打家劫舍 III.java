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

    Map<TreeNode, Integer> dp1 = new HashMap<>();
    Map<TreeNode, Integer> dp2 = new HashMap<>();

    public int rob(TreeNode root) {
        traverse(root);
        return Math.max(dp1.getOrDefault(root, 0), dp2.getOrDefault(root, 0));
    }

    void traverse(TreeNode root){
        if(root == null){
            return;
        }

        traverse(root.left);
        traverse(root.right);
        dp1.put(root, root.val + dp2.getOrDefault(root.left, 0) + dp2.getOrDefault(root.right, 0));
        dp2.put(root, Math.max(dp1.getOrDefault(root.left, 0), dp2.getOrDefault(root.left, 0)) + Math.max(dp1.getOrDefault(root.right, 0), dp2.getOrDefault(root.right, 0)));
    }
}
