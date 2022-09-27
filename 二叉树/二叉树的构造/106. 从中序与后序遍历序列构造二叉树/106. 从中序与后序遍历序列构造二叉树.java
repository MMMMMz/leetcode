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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = traverse(inorder, 0, inorder.length -1, postorder, 0, postorder.length - 1);

        return root;
    }

    TreeNode traverse(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd)
    {
        if(inStart > inEnd){
            return null;
        }

        int val = postorder[postEnd];
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
        root.left = traverse(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = traverse(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);


        return root;
    }
}
