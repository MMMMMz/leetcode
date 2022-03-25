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
    int rank = 0;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
    void traverse(TreeNode root, int k){
        if(root == null) return;
        traverse(root.left, k);
        rank++;
        if(rank == k){
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
