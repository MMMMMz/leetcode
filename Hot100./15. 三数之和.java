class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        Arrays.sort(nums);
        int right;
        int mid;
        for(int left = 0 ; left < nums.length ; left++){
            if(nums[left] > 0) break;
            if(left > 0 && nums[left] == nums[left - 1]) continue;
            right = nums.length - 1;
            mid = left + 1;
            while(mid < right){
                int sum = nums[left] + nums[mid] + nums[right];
                if(sum > 0){
                    right--;
                } else if(sum < 0){
                    mid++;
                } else {
                    res.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                     while(mid < right && nums[mid] == nums[mid + 1]) mid++;
                     while(mid < right && nums[right] == nums[right - 1]) right--;
                     ++mid;
                     --right;
                }
            }
        }
        return res;
    }
} 
