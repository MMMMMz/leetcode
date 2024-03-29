class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0 ; i < s.length() ; i++)
        {
            String s1 = sub(s, i, i);
            String s2 = sub(s, i, i + 1);

            res = s1.length() > res.length() ? s1 : res;
            res = s2.length() > res.length() ? s2 : res;
        }
        return res;
    }

    String sub(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
