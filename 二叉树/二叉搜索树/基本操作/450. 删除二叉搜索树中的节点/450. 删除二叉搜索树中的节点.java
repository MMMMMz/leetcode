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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode curParent = null;
        TreeNode cur = root;
        while(cur != null && cur.val != key){
            curParent = cur;
            if(cur.val > key){
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if(cur == null){
            return root;
        }
        //第一种情况，在叶子上
        if(cur.left == null && cur.right == null){
            cur = cur.left;
        } else if(cur.left == null && cur.right != null){ //第二种情况，有一个非空子节点
            cur = cur.right;
        } else if(cur.left != null && cur.right == null){
            cur = cur.left;
        } else if(cur.left != null && cur.right != null){ //第三种情况，两个非空子节点
            TreeNode temp = cur.left;
            while(temp.right != null){
                temp = temp.right;
            }
            temp.right = cur.right;
            cur = cur.left;
        }

        if(curParent == null){
            return cur;
        }

        if(curParent.left != null && curParent.left.val == key){
            curParent.left = cur;
        } else if(curParent.right != null && curParent.right.val == key){
            curParent.right = cur;
        }

        return root;
    }
}
