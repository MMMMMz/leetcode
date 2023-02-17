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
    long val = 0;
    public int pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return res;
    }

    void traverse(TreeNode root, int targetSum){
        if(root == null){
            return;
        }
        sum(root, targetSum, val);
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
    }

    void sum(TreeNode root, int targetSum, long val){
        if(root == null){
            return;
        }
        val += root.val;
        if(val == targetSum){
            ++res;
        }
        sum(root.left, targetSum, val);
        sum(root.right, targetSum, val);
    }
}
