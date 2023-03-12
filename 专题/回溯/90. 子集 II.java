class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(visited, res, nums, 0, new ArrayDeque<>());
        res.add(new ArrayList<>());
        return res;
    }

    void backtrack(boolean[] visited, List<List<Integer>> res, int[] nums, int index, Deque<Integer> buffer){
        if(index == nums.length){
            return ;
        }

        for(int i = index ; i < nums.length ; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]){
                continue;
            }
           // if(!visited[i]){
                buffer.addLast(nums[i]);
                res.add(new ArrayList<>(buffer));
                visited[i] = true;
                backtrack(visited, res, nums, i + 1, buffer);
                visited[i] = false;
                buffer.removeLast();
          //  }
            
        }
    }
}
