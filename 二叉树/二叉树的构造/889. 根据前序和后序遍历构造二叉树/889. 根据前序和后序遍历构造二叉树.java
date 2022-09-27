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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = traverse(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        return root;
    }

    TreeNode traverse(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if(preStart > preEnd){
            return null;
        }

        if(preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }
        
        int val = preorder[preStart + 1];
        int index = 0;
        for(int i = postStart ; i <= postEnd ; i++)
        {
            if(postorder[i] == val){
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int leftSize = index - postStart;
        root.left = traverse(preorder, preStart + 1, preStart + 1 + leftSize, postorder, postStart, index);
        root.right = traverse(preorder, preStart + 1 + leftSize + 1, preEnd, postorder, index + 1, preEnd - 1);

        return root;
    }
}
