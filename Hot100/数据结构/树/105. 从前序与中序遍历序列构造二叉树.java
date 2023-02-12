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
        TreeNode root = new TreeNode(0);
         root = traverse(root, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    TreeNode traverse(TreeNode root, int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd) return null;
        int val = preorder[preStart];
        root = new TreeNode(val);
        int pos = inStart;
        for(int i = inStart ; i <= inEnd ; i++){
            if(inorder[i] == val){
                pos = i;
                break;
            }
        }

        int leftSize = pos - inStart;
        root.left = traverse(root, preorder, preStart + 1, preStart + leftSize, inorder, pos - leftSize, pos - 1);
        root.right = traverse(root, preorder, preStart + leftSize + 1, preEnd, inorder, pos + 1, inEnd);

        return root;
    }
}
