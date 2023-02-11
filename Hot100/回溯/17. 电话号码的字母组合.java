class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(res, map, digits, 0, new StringBuilder());

        return res;
    }

    void backtrack(List<String> res, Map<Character, String> map, String digits, int index, StringBuilder sb){
        if(index == digits.length()){
            res.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for(int i = 0 ; i < letters.length() ; i++){
            sb.append(letters.charAt(i));
            backtrack(res, map, digits, index + 1, sb);
            sb.deleteCharAt(index);
        }
    }
}
