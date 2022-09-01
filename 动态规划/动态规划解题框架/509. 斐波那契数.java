class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int dp_1 = 1;
        int dp_2 = 0;

        for(int i = 2 ; i < n + 1; i++)
        {
           int dp = dp_1 + dp_2;
           dp_2 = dp_1;
           dp_1 = dp;
        }
        return dp_1;
    }
}
