/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int res = 0;
    int depth = 0;

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        depth++;
        if(root.left == null && root.right == null){
            res = Math.max(res, depth);
        }
        maxDepth(root.left);
        maxDepth(root.right);
        depth--;
        return res;
    }
}
