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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p1 = head;
        ListNode p2 = dummy;
        for(int i = 0 ; i < n ; i++)
        {
            p1 = p1.next;
        }
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;

        return dummy.next;
    }
}
