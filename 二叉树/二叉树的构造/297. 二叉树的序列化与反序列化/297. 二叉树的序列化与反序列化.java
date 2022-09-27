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

    String SEP = ",";
    String NULL = "#";
    
    LinkedList<String> dataList = new LinkedList<>();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb  = new StringBuilder();
        serialize(root, sb);

        return sb.toString();
    }

    void serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        for(String str : data.split(SEP)){
            dataList.add(str);
        }
        TreeNode root = deserialize(dataList);

        return root;
    }

    TreeNode deserialize(LinkedList<String> dataList){
        if(dataList.isEmpty()){
            return null;
        }
        String val = dataList.removeFirst();

        if(val.equals(NULL)){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(dataList);
        root.right = deserialize(dataList);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
