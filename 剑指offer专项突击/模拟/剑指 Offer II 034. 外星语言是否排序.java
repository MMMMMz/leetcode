class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < order.length() ; i++){
            map.put(order.charAt(i), i);
        }
        for(int i = 1 ; i < words.length ; i++){
            String prev = words[i - 1];
            String now = words[i];
            int index = 0;
            while(index < prev.length() && index < now.length() && prev.charAt(index) == now.charAt(index)){
                index++;
            }
            if(index == now.length() && index == prev.length() || index == prev.length()){
                continue;
            }
            if(index == now.length() && index != prev.length()){
                return false;
            }
            if(map.get(prev.charAt(index)) > map.get(now.charAt(index))){
                return false;
            }
        }
        return true;
    }
}
