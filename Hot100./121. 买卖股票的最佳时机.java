class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minVal = Integer.MAX_VALUE;
        for(int i = 0 ; i < prices.length ; i++)
        {
           if(prices[i] < minVal) minVal = prices[i];
           res = Math.max(res, prices[i] - minVal);

        }
        return res;
    }
}
