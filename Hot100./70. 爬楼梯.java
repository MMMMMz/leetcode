class Solution {
    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        int p = 1;
        int q = 2;
        int res = 2;
        for(int i = 2 ; i < n ; i++)
        {
            res = p + q;
            p = q;
            q = res;
        }
        return res;
    }

}
