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

    StringBuilder sb = new StringBuilder();
    Deque<String> list = new ArrayDeque<>();

    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        traverse(root);
        return sb.toString();
    }

    void traverse(TreeNode root){
        if(!sb.isEmpty()){
            sb.append(",");
        }
        
        if(root == null){
            sb.append("#");
            return;
        }
        sb.append(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tree = data.split(",");
        for(String str : tree){
            list.add(str);
        }
        return build();
    }

    TreeNode build(){
        if(list.isEmpty()) return null;
        String cur = list.removeFirst();
        if(cur.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = build();
        root.right = build();
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
