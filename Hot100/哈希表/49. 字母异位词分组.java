class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            List<String> group = map.getOrDefault(s, new ArrayList<>());
            group.add(str);
            map.put(s, group);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
