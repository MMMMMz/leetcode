class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length == 1){
            if(candidates[0] != target){
                return result;
            }
        }
        Arrays.sort(candidates);
        backtrack(result, candidates, target, new ArrayList<>(), 0);

        return result;
    }

    void backtrack(List<List<Integer>> result, int[] candidates, int target, List<Integer> candidate, int start){
        int sum = 0;
        if(start == candidates.length) return;
        for(int num : candidate){
            sum += num; 
        }
        if(sum == target){
            result.add(new ArrayList<Integer>(candidate));
            return;
        } else {
           for(int i = start ; i < candidates.length ; i++)
           {
               if(target - sum - candidates[i] >= 0){
                   candidate.add(candidates[i]);
                   backtrack(result, candidates, target, candidate, i);
                   candidate.remove(candidate.size() - 1);
               } else {
                   break;
               }
           }
        }
    }
}
