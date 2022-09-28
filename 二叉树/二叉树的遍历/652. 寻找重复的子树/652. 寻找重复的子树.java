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

    List<TreeNode> res;
    Map<String, Integer> map;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new ArrayList<>();
        map = new HashMap<>();
        traverse(root);

        return res;
    }

    String traverse(TreeNode root){
        if(root == null){
            return " ";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val + "_");
        sb.append(traverse(root.left)).append(traverse(root.right));
        String key = sb.toString();
        map.put(key, map.getOrDefault(key, 0) + 1);
        if(map.get(key) == 2){
            res.add(root);
        }

        return key;
    }
}
