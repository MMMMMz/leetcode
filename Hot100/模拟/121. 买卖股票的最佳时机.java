class Solution {
    public int maxProfit(int[] prices) {
        int minVal = prices[0];
        int res = 0;

        for(int i = 1 ; i < prices.length ; i++){
            if(minVal > prices[i - 1]) minVal = prices[i - 1];
            res = Math.max(res, prices[i] - minVal);
        }
        return res;
    }
}
