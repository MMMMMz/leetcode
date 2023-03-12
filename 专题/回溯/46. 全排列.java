class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, 0, new ArrayList<>());

        return res;
    }

    void backtrack(int[] nums, List<List<Integer>> res, int index, ArrayList<Integer> buffer){
        if(index == nums.length){
            res.add(new ArrayList(buffer));
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(!buffer.contains(nums[i])){
                buffer.add(nums[i]);
                backtrack(nums, res, index + 1, buffer);
                buffer.remove(buffer.size() - 1);
            }
        }
    }
}
