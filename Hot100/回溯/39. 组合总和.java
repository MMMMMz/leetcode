class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(res, candidates, target, 0, new ArrayList<>());
        return res;
    }

    void backtrack(List<List<Integer>> res, int[] candidates, int target, int index, List<Integer> candidate){
        int sum = 0;
        for(int num : candidate){
            sum += num;
        }
        if(sum == target){
            res.add(new ArrayList<>(candidate));
        }
        if(index == candidates.length){
            return;
        }
        for(int i = index ; i < candidates.length ; i++){
            if(target - sum - candidates[i] >= 0){
                candidate.add(candidates[i]);
                backtrack(res, candidates, target, i, candidate);
                candidate.remove(candidate.size() - 1);
            }
        }
    }
}
