class Solution {
    public void reverseString(char[] s) {
        int slow = 0;
        int fast = s.length - 1;
        int count = s.length / 2;
        for(int i = 0 ; i < count ; i++){
            char temp = s[slow];
            s[slow] = s[fast];
            s[fast] = temp;
            slow++;
            fast--;
        }
    }
}
