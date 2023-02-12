/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while(p != null){
            ++len;
            list.add(p.val);
            p = p.next;
        }
        p = head;
        for(int i = 0 ; i < len / 2 ; i++){
            p = p.next;
        }  
        if(len % 2 != 0) p = p.next; 
        for(int i = len /2 - 1; i >= 0; i--){
            if(list.get(i) != p.val){
                return false;
            }
            p = p.next;
        }
        return true;
    }
}
