class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        List<Integer> res = new ArrayList<>();
        for(int num : nums){
            count[num]++;
        }
        for(int i = 1 ; i <= n ; i++){
            if(count[i] == 0){
                res.add(i);
            }
        }
        return res;
    }
}
