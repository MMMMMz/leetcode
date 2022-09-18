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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode dummy1 = new ListNode(0);
        dummy1.next = head;
        ListNode dummy2 = new ListNode(0);
        ListNode p3 = dummy1;
        ListNode p4 = dummy2;

        for(int i = 0 ; i < left - 1; i++)
        {
            p1 = p1.next;
            p3 = p3.next;
        }
        ListNode p5 = p1;
        for(int i = 0 ; i < right ; i++)
        {
            p2 = p2.next;
        }
        int gap = right - left;
        for(int i = 0 ; i < gap + 1; i++)
        {
            ListNode temp = p1;
            p1 = p1.next;
            temp.next = p4.next;
            p4.next = temp;
        }

        p3.next = dummy2.next;
        p5.next = p2;
        return dummy1.next;
    }
}
