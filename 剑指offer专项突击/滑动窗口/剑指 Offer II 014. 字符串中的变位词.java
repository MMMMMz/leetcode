class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1CharArray = s1.toCharArray();
        Arrays.sort(s1CharArray);
        String target = new String(s1CharArray);
        for(int i = 0 ; i <= s2.length() - target.length() ; i++){
            char[] s2CharArray = s2.substring(i, i + target.length()).toCharArray();
            Arrays.sort(s2CharArray);
            if(target.equals(new String(s2CharArray))){
                return true;
            }
        }
        return false;
    }
}
