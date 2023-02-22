class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        HashSet<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                left++;
            } else if(c == ')'){
                if(left > 0){
                    left--;
                } else {
                    right++;
                }
            }
        }
        
        backtrack(s, set, 0, left, right);
        for(String str : set){
            res.add(str);
        }
        if(set.isEmpty()){
            res.add("");
        }
        return res;
    }
    
    void backtrack(String s, HashSet<String> set, int start, int left, int right){
        if(left == 0 && right == 0){
            if(isValid(s)){
                set.add(s);
            }
        }

        for(int i = start ; i < s.length() ; i++){
            if(left + right > s.length() - i){
                return;
            } 
            if(left > 0 && s.charAt(i) == '('){
                backtrack(s.substring(0, i) + s.substring(i + 1), set, i, left - 1, right);
            } else if(right > 0 && s.charAt(i) == ')'){
                backtrack(s.substring(0, i) + s.substring(i + 1), set, i, left, right - 1);
            }
        }
    }

    boolean isValid(String s){
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                count++;
            } else if(c == ')'){
                if(count == 0){
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }
}
