class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, 0, 0, n, new StringBuilder());

        return res;
    }

    void backtrack(List<String> res, int open, int close, int n, StringBuilder sb){
        if(close == n){
            res.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append("(");
            backtrack(res, open + 1, close, n , sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open){
            sb.append(")");
            backtrack(res, open, close + 1, n , sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
