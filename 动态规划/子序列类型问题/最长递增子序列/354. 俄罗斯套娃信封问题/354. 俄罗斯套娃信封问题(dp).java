class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        int[] height = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 0 ; i < n ; i++){
            height[i] = envelopes[i][1];
        }

        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < i ; j++)
            {
                if(height[i] > height[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 1;
        for(int i = 0 ; i < n ; i++)
        {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
