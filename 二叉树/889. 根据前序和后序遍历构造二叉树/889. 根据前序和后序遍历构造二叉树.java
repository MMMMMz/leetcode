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

        return traverse(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    TreeNode traverse(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if(preStart > preEnd){
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int index = postStart;
        for(int i = postStart ; i <= postEnd ; i++)
        {
            if(postorder[i] == preorder[preStart + 1]){
                index = i;
                break;
            }
        }

        int leftLen =   index - postStart + 1;
        root.left = traverse(preorder, preStart + 1, preStart + leftLen, postorder, postStart, index);
        root.right = traverse(preorder, preStart + 1 + leftLen, preEnd, postorder, index + 1, postEnd - 1);

        return root;
    }
}
