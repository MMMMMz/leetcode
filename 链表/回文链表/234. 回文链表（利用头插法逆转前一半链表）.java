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
        if(head.next == null) return true;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = head;
        ListNode p = head;
        ListNode slow = dummy;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            if(fast == null || fast.next == null) break;
            ListNode temp = p.next;
            p.next = p.next.next;
            temp.next = slow.next;
            slow.next = temp;
        }
        if(fast != null){
            p = p.next.next;
        } else {
            p = p.next;
        }
        slow = dummy.next;
        while(p != null){
            if(p.val != slow.val) return false;
            p = p.next;
            slow = slow.next;
        }
        return true;
    }
}
