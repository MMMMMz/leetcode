class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        } 
        for(int key : map.keySet()){
            pq.offer(new int[]{key, map.get(key)});
        }
        for(int i = 0 ; i < k ; i++){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
