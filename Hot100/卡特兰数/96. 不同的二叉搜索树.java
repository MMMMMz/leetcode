class Solution {
    public int numTrees(int n) {
        long [] cat = new long[n + 1];
        cat[0] = 1;
        cat[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            cat[i] = cat[i - 1] * (4 * i - 2)/(i + 1);
        }
        return (int)cat[n];
    }
}
