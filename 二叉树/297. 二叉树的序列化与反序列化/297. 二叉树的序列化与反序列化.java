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
        LinkedList<String> nodes = new LinkedList();
        for(String s : data.split(",")){
            nodes.add(s);
        }
        
        return traverse2(nodes);
    }
    TreeNode traverse2(LinkedList<String> nodes){
        if(nodes.isEmpty()) return null;

        String first = nodes.removeFirst();
        if(first.equals("#")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = traverse2(nodes);
        root.right = traverse2(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
