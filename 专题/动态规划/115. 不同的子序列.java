class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m][n];
        if(s.charAt(0) == t.charAt(0)){
            dp[0][0] = 1;
        }

        for(int i = 1 ; i < m ; i++){
            if(s.charAt(i) == t.charAt(0)){
                dp[i][0] = 1;
                for(int j = i - 1; j >= 0 ; j--){
                    if(s.charAt(j) == t.charAt(0)){
                        dp[i][0] += dp[j][0];
                        break;
                    }
                }
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if(j > i){
                    break;
                }
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]; //可以和当前字符匹配，也可以不和当前字符匹配
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                
                
            }
        }
        return dp[m - 1][n - 1];
    }
}
