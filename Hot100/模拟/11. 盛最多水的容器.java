class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while(left <= right){
            res = Math.max(res, (right-left) * (height[left] > height[right] ? height[right--] : height[left++]));
        }

        return res;
    }
}
