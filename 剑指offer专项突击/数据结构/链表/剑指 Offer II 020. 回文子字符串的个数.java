class Solution {

    int res;

    public int countSubstrings(String s) {
        for(int i = 0 ; i < s.length() ; i++){
            traverse(s, i, i);
            traverse(s, i, i + 1);
        }
        return res;
    }

    void traverse(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            res++;
        }
    }
}
