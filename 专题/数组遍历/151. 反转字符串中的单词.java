class Solution {
    public String reverseWords(String s) {
        String[] splitStr = s.split(" ");
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(String str : splitStr){
            if(str.length() != 0){
                list.add(str);
            }
        }
        int n = list.size();
        for(int i = 0 ; i < n / 2; i++){
           
            String temp = list.get(n - 1 - i);
            list.set(n - 1 - i, list.get(i));
            list.set(i, temp);
            
        }

        for(String str : list){
            sb.append(str).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
