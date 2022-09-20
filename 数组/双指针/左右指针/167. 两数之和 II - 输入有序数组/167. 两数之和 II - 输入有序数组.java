class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int slow = 0;
        int fast = numbers.length - 1;

        while(slow <= fast){
            if(numbers[slow] + numbers[fast] == target){
                return new int[]{slow + 1, fast + 1};
            } 
            if(numbers[slow] + numbers[fast] > target){
                fast--;
            } else {
                slow++;
            }
        }

        return null;
    }
}
