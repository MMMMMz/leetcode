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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
         HashSet<Integer> values = new HashSet();
         for(TreeNode p : nodes){
             values.add(p.val);
         }

         return traverse(root, values);
    }

    TreeNode traverse(TreeNode root, HashSet values){
        if(root == null){
            return null;
        }

        if(values.contains(root.val)){
            return root;
        }

        TreeNode left = traverse(root.left, values);
        TreeNode right = traverse(root.right, values);
        if(left != null && right != null){
            return root;
        }

        return left == null ? right : left;
    }
}
