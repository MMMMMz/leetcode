class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        if(word1.charAt(0) != word2.charAt(0)){
            dp[0][0] = 2;
        }
        for(int i = 1 ; i < m ; i++){
            if(word1.charAt(i) != word2.charAt(0)){
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = i;
            }
        }

        for(int i = 1 ; i < n ; i++){
            if(word2.charAt(i) != word1.charAt(0)){
                dp[0][i] = dp[0][i - 1] + 1; 
            } else {
                dp[0][i] = i;
            }
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if(word1.charAt(i) != word2.charAt(j)){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
