class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            List<String> temp = map.getOrDefault(s, new ArrayList<String>());
            temp.add(str);
            map.put(s, temp);
        }

        return new ArrayList<>(map.values());
    }
}
