class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0, new ArrayList<>());

        return res;
    }
    
    void backtrack(List<List<Integer>> res, int[] nums, int index, List<Integer> list){
        res.add(new ArrayList<>(list));
        if(index == nums.length) return;

        for(int i = index ; i < nums.length ; i++){
            list.add(nums[i]);
            backtrack(res, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
