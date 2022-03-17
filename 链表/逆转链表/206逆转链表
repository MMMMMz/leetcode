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
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode fast = head.next;
        ListNode mid = head.next;
        ListNode slow = head;
        while(fast != null)
        {
            fast = fast.next;
            mid.next = slow;
            slow = mid;
            mid = fast;
        }
        head.next = null;
        return slow;
    }
}
