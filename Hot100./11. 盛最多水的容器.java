class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            res = height[left] < height[right] ? Math.max(res, (right - left) * Math.min(height[left++], height[right])) :  Math.max(res, (right - left) * Math.min(height[left], height[right--]));
        }
        return res;
    }
}
