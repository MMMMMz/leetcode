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

        return traverse(nums, 0, nums.length - 1);
    }

    TreeNode traverse(int[] nums, int low, int hig){
        if(low > hig){
            return null;
        }

        int maxValue = -1;
        int index = low;
        for(int i = low ; i <= hig ; i++)
        {
            if(nums[i] > maxValue){
                maxValue = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(maxValue);
        root.left = traverse(nums, low, index - 1);
        root.right = traverse(nums, index + 1, hig);

        return root;
    }
}
