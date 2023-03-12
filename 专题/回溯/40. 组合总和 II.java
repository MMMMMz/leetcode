class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        backtrack(visited, res, candidates, target, 0, new ArrayList<>());

        return res;
    }

    void backtrack(boolean[] visited, List<List<Integer>> res,int[] candidates, int target, int index, List<Integer>buffer){
        int sum = 0;
        for(int num : buffer){
            sum += num;
        }
        if(sum == target){
            res.add(new ArrayList(buffer));
            return;
        }
        int n = candidates.length;
        for(int i = index ; i < n ; i++){
            if((i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1])){
                continue;
            }
            if(sum + candidates[i] <= target){
                visited[i] = true;
                buffer.add(candidates[i]);
                backtrack(visited, res, candidates, target, i + 1, buffer);
                visited[i] = false;
                buffer.remove(buffer.size() - 1);
            }
        }
    }
}
