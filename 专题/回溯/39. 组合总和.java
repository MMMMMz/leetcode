class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, candidates, target, 0, new ArrayList<>());
       
        return res;
    }

    void backtrack( List<List<Integer>> res, int[] candidates, int target, int index, List<Integer> list){
        int sum = 0;
        for(int num : list){
            sum += num;
        }
        
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        
        int n = candidates.length;
        for(int i = index ; i < n ; i++){
            if(sum + candidates[i] <= target){
                list.add(candidates[i]);
                backtrack(res, candidates, target, i, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
