class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                left++;
            } else if(c ==')'){
                if(left == 0){
                    right++;
                } else {
                    left--;
                }
            }
        }

        HashSet<String> set = new HashSet<>();
        backtrack(set, s, left, right, 0);
        List<String> res = new ArrayList<>();
        for(String key : set){
            res.add(key);
        }
        return res;
        
    }

    void backtrack(HashSet<String> res, String s, int left, int right, int start){
        if(left == 0 && right == 0){
            if(isValid(s)){
                res.add(s);
            }
            return;
        }

        for(int i = start ; i < s.length() ; i++){
            if(s.charAt(i) == ')' && right > 0){
                backtrack(res, s.substring(0, i) + s.substring(i + 1), left, right - 1, i);
            } else if(s.charAt(i) == '(' && left > 0){
                backtrack(res, s.substring(0, i) + s.substring(i + 1), left - 1, right, i);
            }
        }
    }

    boolean isValid(String s){
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                cnt++;
            } else if(c == ')'){
                if(cnt <= 0){
                    return false;
                }
                cnt--;
            }
        }
        return cnt == 0;
    }
}
