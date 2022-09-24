class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] inStacK = new boolean[256];
        int[] count = new int[256];

        for(int i = 0 ; i < s.length() ; i++)
        {
            count[s.charAt(i)]++;
        }

        for(char c : s.toCharArray())
        {
            count[c]--;
            if(inStacK[c]){
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > c){
                if(count[stack.peek()] == 0){
                    break;
                }

                inStacK[stack.pop()] = false;
            }

            stack.push(c);
            inStacK[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
