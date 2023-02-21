class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0){
            return word2.length();
        }
        if(word2.length() == 0){
            return word1.length();
        }
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        if(word1.charAt(0) != word2.charAt(0)){
            dp[0][0] = 1;
        }
        for(int i = 1 ; i < m ; i++){
            if(word1.charAt(i) == word2.charAt(0)){
                dp[i][0] = i;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }

        for(int i = 1 ; i < n ; i++){
            if(word1.charAt(0) == word2.charAt(i)){
                dp[0][i] = i;
            } else {
                dp[0][i] = dp[0][i - 1] + 1;
            }
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }
