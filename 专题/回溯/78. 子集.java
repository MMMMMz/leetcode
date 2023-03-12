class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0, new ArrayDeque());
        res.add(new ArrayList<>());
        return res;
    }

    void backtrack(List<List<Integer>> res, int[] nums, int index, ArrayDeque buffer){
        if(index == nums.length){
            return;
        }

        for(int i = index ; i < nums.length ; i++){
            buffer.addLast(nums[i]);
            res.add(new ArrayList<>(buffer));
            backtrack(res, nums, i + 1, buffer);
            buffer.removeLast();
        }
    }
}
