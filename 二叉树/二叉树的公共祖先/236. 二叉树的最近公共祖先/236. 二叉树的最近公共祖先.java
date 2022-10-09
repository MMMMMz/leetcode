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
        return traverse(root, p.val, q.val);
    }

    TreeNode traverse(TreeNode root, int val1, int val2){
        if(root == null){
            return null;
        }

        if(root.val == val1 || root.val == val2){
            return root;
        }

        TreeNode left = traverse(root.left, val1, val2);
        TreeNode right = traverse(root.right, val1, val2);
        //当val1和val2出现在当前节点的异侧的时候，当前节点即为公共祖先
        if(left != null && right != null){
            return root;
        }

        return left != null ? left : right;
    }
}
