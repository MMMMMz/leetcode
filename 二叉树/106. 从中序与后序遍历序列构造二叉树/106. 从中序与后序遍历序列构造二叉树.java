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

        return traverse(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    TreeNode traverse(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd){
            return null;
        }

        int rootVal = postorder[postEnd];
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
        root.left = traverse(inorder, inStart, index - 1, postorder, postStart, postStart + leftLen - 1);
        root.right = traverse(inorder, index + 1, inEnd, postorder, postStart + leftLen, postEnd - 1);
        return root;
    }
}
