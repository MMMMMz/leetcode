/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode();
        ListNode p3 = head;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                p3.next = p1;
                ListNode temp = p1;
                p1 = p1.next;
                temp.next = null;
            } else {
                p3.next = p2;
                ListNode temp = p2;
                p2 = p2.next;
                temp.next = null;
            }
            p3 = p3.next;
        }
        if(p1 == null){
            p3.next = p2;
        } else {
            p3.next = p1;
        }

        return head.next;
    }
}
