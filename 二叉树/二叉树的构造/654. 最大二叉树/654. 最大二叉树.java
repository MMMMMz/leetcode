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
        TreeNode root = traverse(nums, 0, nums.length - 1);

        return root;
    }

    TreeNode traverse(int[] nums, int start, int end)
    {
        if(start > end)
        {
            return null;
        }
        int maxIndex = 0;
        int temp = -1;
        for(int i = start ; i <= end ; i++)
        {
            if(nums[i] > temp){
                temp = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = traverse(nums, start, maxIndex - 1);
        root.right = traverse(nums, maxIndex + 1, end);
        return root;
    }
}
