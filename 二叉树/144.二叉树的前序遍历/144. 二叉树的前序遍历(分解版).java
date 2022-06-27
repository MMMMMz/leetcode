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

    public List<Integer> preorderTraversal(TreeNode root) {
        return traverse(root);
    }

    List<Integer> traverse(TreeNode root){
        List<Integer> res = new ArrayList();
        if(root == null){
            return res;
        }

        res.add(root.val);
        List<Integer> leftPreOrder = traverse(root.left);
        List<Integer> rightPreOrder = traverse(root.right);
        res.addAll(leftPreOrder);
        res.addAll(rightPreOrder);

        return res;
    }
}
