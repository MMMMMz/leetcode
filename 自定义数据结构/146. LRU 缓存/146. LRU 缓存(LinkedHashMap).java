class LRUCache {

    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }

        makeRecently(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
            cache.put(key, value);
            return;
        }

        if(cap == cache.size()){
           int leastKey = cache.keySet().iterator().next();
           cache.remove(leastKey);
        }

        cache.put(key, value);
    }

    public void makeRecently(int key){
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
