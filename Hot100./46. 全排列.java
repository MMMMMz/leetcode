class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;
    }

    void backtrack(int[] nums, List<List<Integer>> result, List<Integer> comb, int index){
        if(index == nums.length){
            result.add(new ArrayList<>(comb));
            return;
        } else {
            for(int i = 0 ; i < nums.length ; i++)
            {
                if(!comb.contains(nums[i])){
                    comb.add(nums[i]);
                    backtrack(nums, result, comb, index + 1);
                    comb.remove(index);
                }
            }
        }
    }
}
