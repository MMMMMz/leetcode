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

    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);

        return res;
    }

    boolean traverse(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        boolean left = traverse(root.left, p, q);
        boolean right = traverse(root.right, p, q);
        if((left && right) || ((root == p || root == q) && (left || right))){
            res = root;
        }

        return left || right || root == p || root == q;
    }

}
