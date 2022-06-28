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

    List<TreeNode> res = new ArrayList();
    HashMap<String, Integer> map = new HashMap();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    String traverse(TreeNode root){
        if(root == null){
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = root.val + "," + left + "," + right;
        int count = map.getOrDefault(subTree, 0);
        if(count == 1){
            res.add(root);
        }
        map.put(subTree, count + 1);

        return subTree;
    }
}
