class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuffer(), 0, 0, n);
        return result;
    }

    void backtrack(List<String> result, StringBuffer sb, int open, int close, int max){
        if(sb.length() == 2 * max){
            result.add(sb.toString());
            return;
        } else {
            if(open < max){
                sb.append('(');
                backtrack(result, sb, open + 1, close, max);
                sb.deleteCharAt(sb.length() - 1);
            }
            if(close < open){
                sb.append(')');
                backtrack(result, sb, open, close + 1, max);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
