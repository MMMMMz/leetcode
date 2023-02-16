class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c != ']'){
                stack.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while(stack.peek() != '['){
                    sb.append(stack.pop());
                }
                stack.pop();
                StringBuilder numString = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() - '0' <= 9){
                    numString.append(stack.pop());
                }
                int num = Integer.parseInt(numString.reverse().toString());
                String now = sb.reverse().toString();
                for(int i = 0 ; i < num ; i++){
                    for(char d : now.toCharArray()){
                        stack.push(d);
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
