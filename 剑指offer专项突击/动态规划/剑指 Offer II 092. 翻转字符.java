class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i = 1 ; i < n ; i++){
            if(s.charAt(i) == '0' && s.charAt(i - 1) == '1' || (dp[i - 1] != 0 && s.charAt(i - 1) == '0')){
                int count = 0;
                int zero = 0;
                for(int j = 0 ; j < i ; j++){
                    if(s.charAt(j) == '1'){
                        count++;
                    }
                }
                for(int j = i - 1 ; j >= 0 ; j--){
                    if(s.charAt(j) == '0' && dp[j] != 0){
                        zero = dp[j];
                        break;
                    }
                }
                dp[i] = Math.min(zero + 1, count);
            }
        }

        int res = 0;
        for(int j = n - 1 ; j >= 0 ; j--){
            if(s.charAt(j) == '0'){
                res = dp[j];
                break;
            }
        }
        return res;
    }
}
