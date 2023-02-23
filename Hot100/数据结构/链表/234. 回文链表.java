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
        ListNode p = head;
        int len = 0;
        while(p != null){
            p = p.next;
            len++;
        }
        p = head;
        ListNode pre = null;
        for(int i = 0 ; i < len / 2 ; i++){
            ListNode temp = p;
            p = p.next;
            temp.next = pre;
            pre = temp;
        }
        if(len % 2 != 0){
            p = p.next;
        }
        while(p != null){
            if(p.val != pre.val){
                return false;
            }
            p = p.next;
            pre = pre.next;
        }
        return true;
    }
}
