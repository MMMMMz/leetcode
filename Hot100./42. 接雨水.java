class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int[] dp = new int[n];
        int res = 0;
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        int max = leftMax[0];
        for(int i = 1 ; i < n ; i++){
            if(height[i] > max){
                max = height[i];
            }
            leftMax[i] = max;
        }
        max = rightMax[n - 1];
        for(int i = n - 2; i >= 0; i--){
            if(height[i] > max){
                max = height[i];
            }
            rightMax[i] = max;
        }
        for(int i = 0 ; i < n ; i++){
            dp[i] = Math.min(leftMax[i], rightMax[i]) - height[i];
            res += dp[i];
        }
        
        return res;
    }
}
