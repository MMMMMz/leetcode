/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    void traverse(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        traverse(root.left, sb);
        traverse(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] treeData = data.split(",");
        Queue<String> treeList = new LinkedList<>();
        for(String str : treeData){
            treeList.add(str);
        }
        TreeNode root;
        root = deserialize(treeList);
        return root;
    }

    TreeNode deserialize(Queue<String> treeList){
        if(treeList.size() == 0){
            return null;
        }
        String str = treeList.poll();
        if(str.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = deserialize(treeList);
        root.right = deserialize(treeList);
        return root;
    }
}
