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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    TreeNode build(int[] nums, int l, int h)
    {
        if(l > h) return null;
        int m = l;
        for(int i = l; i <= h; i++)
        {
            if(nums[i] > nums[m]){
                m = i;
            }
        }
        TreeNode root = new TreeNode(nums[m]);
        root.left = build(nums, l, m - 1);
        root.right = build(nums, m + 1, h);
        return root;
    }
}
