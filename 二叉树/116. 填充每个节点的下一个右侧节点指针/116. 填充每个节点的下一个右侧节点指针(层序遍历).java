/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        traverse(root);
        return root;
    }

    void traverse(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        List<Node> levelList = new LinkedList<>();
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                size--;
                Node cur = q.poll();
                levelList.add(cur);
                if(cur.left != null){
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
            for(int i = 0 ; i < levelList.size() ; i++)
                {
                    if(i != levelList.size() - 1){
                        levelList.get(i).next = levelList.get(i + 1);
                    } else {
                        levelList.get(i).next = null;
                    }
                }
            levelList = new LinkedList<>();
        }
    }
}
