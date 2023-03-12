class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] candidates = new int[n + 1];
        for(int i = 1 ; i <= n ; i++){
            candidates[i] = i;
        }
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, candidates, n, k, 1, new ArrayDeque<>());

        return res;
    }

    void backtrack(List<List<Integer>> res, int[] candidates, int n, int k, int index, Deque<Integer> buffer){
        if(buffer.size() == k){
            res.add(new ArrayList<>(buffer));
            return;
        }

        if(index > n){
            return;
        }

        for(int i = index ; i <= n ; i++){
            buffer.addLast(candidates[i]);
            backtrack(res, candidates, n, k, i + 1, buffer);
            buffer.removeLast();
        }
    }
}
