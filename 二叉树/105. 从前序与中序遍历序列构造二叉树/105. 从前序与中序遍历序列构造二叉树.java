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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return traverse(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode traverse(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){

        if(preStart > preEnd){
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int index = inStart;
        for(int i = inStart ; i <= inEnd ; i++)
        {
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }

        int leftLen = index - inStart;
        root.left = traverse(preorder, preStart + 1, preStart + leftLen, inorder, inStart, index - 1);
        root.right = traverse(preorder, preStart + leftLen + 1, preEnd, inorder, index + 1, inEnd);

        return root;
    }
}
