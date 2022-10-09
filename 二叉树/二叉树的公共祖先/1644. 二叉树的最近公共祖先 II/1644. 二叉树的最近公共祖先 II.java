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
    boolean foundP;
    boolean foundQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = traverse(root, p.val, q.val);
        if(!foundP || !foundQ){
            return null;
        }
        return res;
    }
    
    TreeNode traverse(TreeNode root, int val1, int val2){
        if(root == null){
            return null;
        }

        TreeNode left = traverse(root.left, val1, val2);
        TreeNode right = traverse(root.right, val1, val2);
        if(left != null && right != null){
            return root;
        }
        if(root.val == val1 || root. val == val2){
            if(root.val == val1){
                foundP = true;
            }
            if(root.val == val2){
                foundQ = true;
            }
            return root;
        }
        return left == null ? right : left;
    }
}
