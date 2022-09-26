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

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            while(size > 0){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                }

                if(node.right != null){
                    q.offer(node.right);
                }

                size--;
            }
            res++;
        }

        return res;
    }
}
