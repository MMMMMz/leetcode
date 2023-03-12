class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> deadendsSet = new HashSet<>();
        int res = 0;
        for(String deadend : deadends){
            deadendsSet.add(deadend);
        }
        Queue<String> q = new LinkedList<>();
        visited.add("0000");
        q.offer("0000");
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0 ; i < len ; i++){
                String str = q.poll();
                if(deadendsSet.contains(str)){
                    continue;
                }
                if(str.equals(target)){
                    return res;
                }

                for(int j = 0 ; j < 4 ; j++){
                    String up = up(str, j);
                    if(!visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = down(str, j);
                        if(!visited.contains(down)){
                            q.offer(down);
                            visited.add(down);
                        }
                    }
                }
                res++;
            }
            return -1;
        }

    String up(String str, int i){
        char[] charArray = str.toCharArray();
        if(charArray[i] == '9'){
            charArray[i] = '0';
        } else{
            charArray[i] += 1;
        }
        return new String(charArray);
    }

    String down(String str, int i){
        char[] charArray = str.toCharArray();
        if(charArray[i] == '0'){
            charArray[i] = '9';
        } else{
            charArray[i] -= 1;
        }
        return new String(charArray);
    }
}
