class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, res, 0, new ArrayList<>());
        return res;
    }

    void backtrack(int[] nums, List<List<Integer>> res, int index, List<Integer> num){
        if(index == nums.length){
            res.add(new ArrayList<>(num));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(!num.contains(nums[i])){
                num.add(nums[i]);
                backtrack(nums, res, index + 1, num);
                num.remove(num.size() - 1);
            }
        }
    }
}
