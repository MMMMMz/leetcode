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
       ListNode fast = head;
       ListNode slow = head;
       ListNode pre = null;
       while(fast != null && fast.next != null){
           fast = fast.next.next;
           ListNode next = slow.next;
           slow.next = pre;
           pre = slow;
           slow = next;
       }
       if(fast != null){
           slow = slow.next;
       }
       while(pre != null){
           if(pre.val != slow.val){
               return false;
           }
           pre = pre.next;
           slow = slow.next;
       }
       return true;
    }

}
