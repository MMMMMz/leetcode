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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return traverse(root, p.val, q.val);
    }

    TreeNode traverse(TreeNode root, int val1, int val2){
        TreeNode p = root;
        while(true){
            if(val1 < p.val && val2 < p.val){
                p = p.left;
            } else if(val1 > p.val && val2 > p.val){
                p = p.right;
            } else {
                break;
            }
        }

        return p;
    }
}
