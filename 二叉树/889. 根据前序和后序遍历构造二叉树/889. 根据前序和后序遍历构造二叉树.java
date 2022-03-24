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
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }
    TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int posStart, int posEnd){
        if(preStart > preEnd) return null;
        if(preStart == preEnd) return new TreeNode(preorder[preStart]);
        
        int rootVal = preorder[preStart];
        int leftVal = preorder[preStart + 1];
        TreeNode root = new TreeNode(rootVal);
        int index = -1;
        for(int i = posStart ; i <= posEnd ; i++)
        {
            if(postorder[i] == leftVal){
                index = i;
                break;
            }
        }
        int leftSize = index - posStart + 1;
        root.left = build(preorder, preStart + 1, preStart + leftSize, postorder, posStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, posEnd);
        return root;
    }
}
