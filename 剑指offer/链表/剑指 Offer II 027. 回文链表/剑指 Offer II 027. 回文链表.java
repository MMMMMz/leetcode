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
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode pre = null;
        while(p1 != null && p1.next != null)
        {
           
            p1 = p1.next.next;
            ListNode temp = p2.next;
            p2.next = pre;
            pre = p2;
            p2 = temp;
          
        }
        if(p1 != null){
            p2 = p2.next;
        }
        
        while(p2 != null){
            if(pre.val != p2.val){
                return false;
            }
            pre = pre.next;
            p2 = p2.next;
        }

        return true;
    }
}
