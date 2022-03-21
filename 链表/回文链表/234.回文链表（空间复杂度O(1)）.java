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
       while(fast != null && fast.next != null){
           slow = slow.next;
           fast = fast.next.next;
       }
       if(fast != null){
           slow = slow.next;
       }
       ListNode newHead = reverse(slow);
       ListNode cur = head;
       while(newHead != null){
           if(newHead.val != cur.val){
               return false;
           }
           newHead = newHead.next;
           cur = cur.next;
       }
       return true;
    }

    ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
