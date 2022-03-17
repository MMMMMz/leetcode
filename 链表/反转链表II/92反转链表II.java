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
    ListNode successor;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode fast = dummy.next;
        ListNode slow = dummy;
        
        for(int i = 1 ; i < left ; i++)
        {
            slow = slow.next;
            fast = fast.next;
        }
        
        for(int i = 0 ; i < right - left ; i++)
        {
            ListNode removed = fast.next;
            fast.next = fast.next.next;
            removed.next = slow.next;
            slow.next = removed;
        }
       
        return dummy.next;
    }
   
}
