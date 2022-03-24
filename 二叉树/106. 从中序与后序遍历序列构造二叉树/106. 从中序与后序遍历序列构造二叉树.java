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
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd){
        if(inStart > inEnd) return null;
        int rootVal = postorder[poEnd];
        TreeNode root = new TreeNode(rootVal);
        int index = -1;
        for(int i = inStart ; i <= inEnd ; i++){
            if(inorder[i] == rootVal){
                index = i;
            }
        }
        int leftSize = index - inStart;
        root.left = build(inorder, inStart, index - 1, postorder, poStart, poStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder,  poStart + leftSize, poEnd - 1);
        return root;
    }
}
