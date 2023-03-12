class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, res, visited, new ArrayList<>(), 0);
       
        return res;
    }

    void backtrack(int[] nums, List<List<Integer>> res, boolean[] visited, ArrayList<Integer> buffer, int index){
        if(index == nums.length){
            res.add(new ArrayList<>(buffer));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])){
               continue;
            }
            visited[i] = true;
            buffer.add(nums[i]);
            backtrack(nums, res, visited, buffer, index + 1);
            visited[i] = false;
            buffer.remove(buffer.size() - 1);
        }
    }
}
