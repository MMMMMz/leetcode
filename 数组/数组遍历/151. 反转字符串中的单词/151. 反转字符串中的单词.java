class Solution {
    public String reverseWords(String s) {
        //先将整个字符串反转，在将每个单词反转
        String reverse = new StringBuffer(s).reverse().toString();
        String res = "";
        String[] resverseSplit = reverse.split(" ");
        for(int i = 0 ; i < resverseSplit.length ; i++)
        {
            if(resverseSplit[i] != ""){
                res += new StringBuffer(resverseSplit[i]).reverse().toString();
                if(i != resverseSplit.length - 1){
                    res += " ";
                }
            }
        }
        return res;
    }
}
