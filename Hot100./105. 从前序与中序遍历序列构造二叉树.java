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
        TreeNode root = new TreeNode();
        
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd)
    {
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int pos = inStart;
        for(int i = inStart ; i <= inEnd ; i++)
        {
            if(inorder[i] == preorder[preStart]) {
                pos = i;
                break;
            }
        }

        root.left = build(preorder, preStart + 1, preStart + pos - inStart, inorder, inStart, pos - 1);
        root.right = build(preorder, preStart + 1 + pos - inStart, preEnd, inorder, pos + 1, inEnd);
        return root;
    }
}
