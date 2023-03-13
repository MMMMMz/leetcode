class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        if(s1.charAt(0) != s2.charAt(0)){
            dp[0][0] = (int)s1.charAt(0) + (int)s2.charAt(0);
        }

        for(int i = 1 ; i < m ; i++){
            if(s1.charAt(i) != s2.charAt(0)){
                dp[i][0] = dp[i - 1][0] + (int)s1.charAt(i);
            } else{
                for(int j = 0 ; j < i ; j++){
                    dp[i][0] += (int)s1.charAt(j);
                }
            }
        }
        for(int i = 1 ; i < n ; i++){
            if(s2.charAt(i) != s1.charAt(0)){
                dp[0][i] = dp[0][i - 1] + (int)s2.charAt(i);
            } else {
                for(int j = 0 ; j < i ; j++){
                    dp[0][i] += (int)s2.charAt(j);
                }
            }
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if(s1.charAt(i) != s2.charAt(j)){
                    int left = dp[i][j - 1] + (int)s2.charAt(j);
                    int up = dp[i - 1][j] + (int)s1.charAt(i);
                    dp[i][j] = Math.min(left, up);
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
