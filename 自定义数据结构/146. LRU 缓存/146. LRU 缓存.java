class LRUCache {

    HashMap<Integer, Node> map = new HashMap<>();
    DoubleList cache = new DoubleList();
    int cap;

    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }

    class DoubleList{
        Node head;
        Node tail;
        int size;

        public DoubleList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addLast(Node x){
            x.next = tail;
            x.prev = tail.prev;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        void remove(Node x){
            x.prev.next = x.next;
            x.next.prev = x.prev;

            size--;
        }

        public Node removeFirst() {
            if(head.next == tail){
                return null;
            }
            Node first = head.next;
            remove(first);

            return first;
        }

        int size(){
            return size;
        }
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public void makeRecently(int key){
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    public void addRecently(int key, int val){
        Node x = new Node(key, val);
        map.put(key, x);
        cache.addLast(x);
    }

    public void deleteKey(int key){
        Node x = map.get(key);
        map.remove(key);
        cache.remove(x);
    }

    public void removeLeastRecently(){
        Node x = cache.removeFirst();
        map.remove(x.key);
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        makeRecently(key);

        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if(cache.size == cap){
            removeLeastRecently();
        }
        addRecently(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
