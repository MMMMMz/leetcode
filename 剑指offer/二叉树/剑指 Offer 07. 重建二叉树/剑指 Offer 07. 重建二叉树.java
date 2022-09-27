/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = traverse(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    TreeNode traverse(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd)
    {
        if(preStart > preEnd){
            return null;
        }

        int val = preorder[preStart];
        int index = 0;
        for(int i = inStart ; i <= inEnd ; i++)
        {
            if(inorder[i] == val){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(val);
        int leftSize = index - inStart;

        root.left = traverse(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = traverse(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);

        return root;
    }
}
