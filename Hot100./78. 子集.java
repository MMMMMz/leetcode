class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, result, 0, new ArrayList<>());
        return result;
    }

    void backtrack(int[] nums, List<List<Integer>> result, int index, List<Integer> sub){
        result.add(new ArrayList<>(sub));
        if(index == nums.length){
            return;
        }
        for(int i = index ; i < nums.length ; i++)
        {
            sub.add(nums[i]);
            backtrack(nums, result, i + 1, sub);
            sub.remove(sub.size() - 1);
        }
         
    }
}
